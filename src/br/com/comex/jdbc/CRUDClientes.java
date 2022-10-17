package br.com.comex.jdbc;

import br.com.comex.modelos.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDClientes {

	public static void inserir(String nome, String cpf, String telefone, String rua, int numero, String complemento,
			String bairro, String cidade, String uf) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.recuperarConexao()) {

			connection.setAutoCommit(false);
			try {
				PreparedStatement stm = connection.prepareStatement(
						"INSERT INTO comex.CLIENTE " + "(nome, cpf, telefone, rua, numero,"
								+ " complemento, bairro, cidade, uf)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);

				stm.setString(1, nome);
				stm.setString(2, cpf);
				stm.setString(3, telefone);
				stm.setString(4, rua);
				stm.setInt(5, numero);
				stm.setString(6, complemento);
				stm.setString(7, bairro);
				stm.setString(8, cidade);
				stm.setString(9, uf);

				connection.commit();
				stm.close();
				connection.close();

			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Rollback efetuado! ");
				connection.rollback();
			}

		}
	}

	public static void listar(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();

		PreparedStatement stm = connection.prepareStatement("SELECT * FROM comex.CLIENTE");
		stm.execute();
		ResultSet rst = stm.getResultSet();

		while (rst.next()) {
			Integer id = rst.getInt("ID");
			System.out.println(id);
			String nome = rst.getString("NOME");
			System.out.println(nome);
			String cpf = rst.getString("CPF");
			System.out.println(cpf);
			String telefone = rst.getString("TELEFONE");
			System.out.println(telefone);
			String rua = rst.getString("RUA");
			System.out.println(rua);
			Integer numero = rst.getInt("NUMERO");
			System.out.println(numero);
			String complemento = rst.getString("COMPLEMENO");
			System.out.println(complemento);
			String bairro = rst.getString("BAIRRO");
			System.out.println(bairro);
			String cidade = rst.getString("CIDADE");
			System.out.println(cidade);
			String uf = rst.getString("UF");
			System.out.println(uf);

		}
		connection.close();
	}

		public static void atualizar(String[] args) throws SQLException {

			ConnectionFactory factory = new ConnectionFactory();
			Connection connection = factory.recuperarConexao();

			Statement stm = connection.createStatement();
			stm.execute("UPDATE comex.CLIENTE SET nome = ?, cpf = ?, "
					+ "telefone = ?, rua = ?, numero = ?, complemento = ?,"
					+ " bairro = ?, cidade = ?, uf = ?  where id = ?");
			System.out.println("Categoria atualizada com êxito!");
			connection.close();
		}
	
	

	public static void remover(Integer id) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();

		PreparedStatement stm = connection.prepareStatement("DELETE FROM comex.CATEGORIA WHERE ID = ?");
		stm.setInt(1, id);
		stm.execute();
		Integer linhasAlteradas = stm.getUpdateCount();
		System.out.println("Categorias excluídas com êxito: " + linhasAlteradas);
		connection.close();

	}
}

