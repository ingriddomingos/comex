package br.com.comex.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.comex.modelos.ConnectionFactory;

public class CRUDItemPedido {

public static void inserir(int id, Double preco_unitario, int quatidade, int produto_id, int pedido_id, Double desconto, String tipo_desconto) throws SQLException {

	ConnectionFactory factory = new ConnectionFactory();
	try (Connection connection = factory.recuperarConexao()) {

		connection.setAutoCommit(false);
		try {
			PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO comex.ITEM_PEDIDO(id, preco_unitario, quantidade, produto_id, pedido_id,"
					+ "desconto, tipo_desconto)"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			stm.setLong(1, id);
			stm.setDouble(2, preco_unitario);
			stm.setInt(3, quatidade);
			stm.setInt(4, produto_id);
			stm.setLong(5, pedido_id);
			stm.setDouble(6, desconto);
			stm.setString(7, tipo_desconto);

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

	PreparedStatement stm = connection.prepareStatement("SELECT * FROM comex.ITEM_PEDIDO");
	stm.execute();
	ResultSet rst = stm.getResultSet();

	while (rst.next()) {
		Integer id = rst.getInt("ID");
		System.out.println(id);
		String preco_unitario = rst.getString("PRECO");
		System.out.println(preco_unitario);
		String quantidade = rst.getString("QUANTIDADE");
		System.out.println(quantidade);
		String produto = rst.getString("PRODUTO");
		System.out.println(produto);
		String pedido_id = rst.getString("PEDIDO");
		System.out.println(pedido_id);
		Integer desconto = rst.getInt("DESCONTO");
		System.out.println(desconto);
		String tipo_desconto = rst.getString("DESCONTO");
		System.out.println(tipo_desconto);

	}
	connection.close();
}

public static void atualizar(String[] args) throws SQLException {

	ConnectionFactory factory = new ConnectionFactory();
	Connection connection = factory.recuperarConexao();

	Statement stm = connection.createStatement();
	stm.execute("UPDATE comex.ITEM_PEDIDO SET id = ?, preco_unitario = ?");
		//	+ "quantidade = ?, produto = ?, pedido_id = ?, desconto = ?,"
		//	+ " tipo_desconto = ?");
	System.out.println("Campo atualizado com êxito!");
	connection.close();
}
public static void remover(Integer id) throws SQLException {
	
	ConnectionFactory factory = new ConnectionFactory();
	Connection connection = factory.recuperarConexao();

	PreparedStatement stm = connection.prepareStatement("DELETE FROM comex.ITEM_PEDIDO WHERE ID = ?");
	stm.setInt(1, id);
	stm.execute();
	Integer linhasAlteradas = stm.getUpdateCount();
	System.out.println("Categorias excluídas com êxito: " + linhasAlteradas);
	connection.close();

}
}
