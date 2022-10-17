package br.com.comex.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.comex.modelos.ConnectionFactory;

public class CRUDProdutos {

	public static void inserir(String nome, String descricao, double preco_unitario, int quantidade_estoque,
			int categoria_id, String tipo) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();

		String sql = "INSERT INTO comex.PRODUTO(nome, descricao, preco_unitario, quantidade_estoque, categoria_id) "
				+ "VALUES (?, ?, ?, ?, ?)";

		PreparedStatement stm = connection.prepareStatement(sql);

		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.setDouble(3, preco_unitario);
		stm.setInt(4, quantidade_estoque);
		stm.setInt(5, categoria_id);

		stm.execute();

		connection.close();

	}

	public static void deletar(Integer id) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		String sql = "DELETE FROM comex.PRODUTO where id = ?";
		PreparedStatement stm = connection.prepareStatement(sql);

		stm.setInt(1, id);
		connection.close();
	}

	public static void listar() throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		Statement stm = connection.createStatement();

		stm.execute("SELECT * FROM comex.PRODUTO");

		ResultSet resultS = stm.getResultSet();

		while (resultS.next()) {
			Integer id = resultS.getInt("id");
			String nome = resultS.getString("nome");
			String descricao = resultS.getString("descricao");
			Integer preco_unitario = resultS.getInt("preco_unitario");
			Integer quantidade_estoque = resultS.getInt("quantidade_estoque");
			String categoria_id = resultS.getString("categoria_id");


			System.out.println("Id: " + id 
					+ " Nome: " + nome + "\n" 
					+ " Descrição: " + descricao + "\n"
					+ " Preço : " + preco_unitario + "\n" 
					+ " Quantidade em estoque: " + quantidade_estoque + "\n"
					+ " Categoria Id: " + categoria_id + "\n" );
		}
		connection.close();
		return ;
	}

	public static void atualizar(String nome, String descricao, double preco_unitario, int quantidade_estoque, int categoria_id, String tipo, int id) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();

		String sql = "UPDATE comex.PRODUTO SET nome = ?"
				//+ ", descricao = ?, preco_unitario = ?, "
				//"quantidade_estoque = ?, categoria_id = ? 
				+ " where id = ?";

		PreparedStatement stm = connection.prepareStatement(sql);

		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.setDouble(3, preco_unitario);
		stm.setInt(4, quantidade_estoque);
		stm.setInt(5, categoria_id);
		stm.setInt(7, id);

		stm.execute();

		connection.close();
	}


}