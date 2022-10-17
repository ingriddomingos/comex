package br.com.comex.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.comex.modelos.ConnectionFactory;

public class CRUDPedidos {

	public static void inserir(String data, String cliente_id) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.recuperarConexao()) {

			connection.setAutoCommit(false);
			try {
				PreparedStatement stm = connection.prepareStatement(
						"INSERT INTO comex.PEDIDO(data, cliente_id"
						+ "	VALUES (?, ?)",
						Statement.RETURN_GENERATED_KEYS);

				stm.setString(1, data);
				stm.setString(2, cliente_id);


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

		PreparedStatement stm = connection.prepareStatement("SELECT * FROM comex.PEDIDO");
		stm.execute();
		ResultSet rst = stm.getResultSet();

		while (rst.next()) {
			Integer id = rst.getInt("ID");
			System.out.println(id);
			String data = rst.getString("DATA");
			System.out.println(data);
			String cliente_id = rst.getString("CLIENTE");
			System.out.println(cliente_id);

		}
		connection.close();
	}
public static void remover(Integer id) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();

		PreparedStatement stm = connection.prepareStatement("DELETE FROM comex.PEDIDO where id = ?");
		stm.setInt(1, id);
		stm.execute();
		Integer linhasAlteradas = stm.getUpdateCount();
		System.out.println("Categorias excluídas com êxito: " + linhasAlteradas);
		connection.close();

	}

public static void atualizar(String[] args) throws SQLException {

	ConnectionFactory factory = new ConnectionFactory();
	Connection connection = factory.recuperarConexao();

	Statement stm = connection.createStatement();
	stm.execute("UPDATE comex.PEDIDO SET data = ?, cliente_id = ? where id = ?");
	System.out.println("Categoria atualizada com êxito!");
	connection.close();
}}