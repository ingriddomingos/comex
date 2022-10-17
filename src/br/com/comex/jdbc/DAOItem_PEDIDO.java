package br.com.comex.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelos.ItemPedido;
import br.com.comex.modelos.Pedido;
import br.com.comex.modelos.Produto;
import br.com.comex.modelos.ConnectionFactory;

public class DAOItem_PEDIDO {


public static void remover(Integer id) throws SQLException {
	
	ConnectionFactory factory = new ConnectionFactory();
	Connection connection = factory.recuperarConexao();
	
	String sql = "DELETE FROM comex.ITEM_PEDIDO where id = ?";
	PreparedStatement stm = connection.prepareStatement(sql);
	
	stm.setInt(1, id);
	connection.close();
}
public static List<ItemPedido> listar() throws SQLException {
	
	List<ItemPedido> ipedidos = new ArrayList<>();
	ConnectionFactory factory = new ConnectionFactory();
	Connection connection = factory.recuperarConexao();
	Statement pstm = connection.createStatement();
	
	pstm.execute("SELECT * FROM comex.ITEM_PEDIDO");
	
	ResultSet result = pstm.getResultSet();
	
	while (result.next()) {
		Double desconto = result.getDouble("desconto");
		String tipo_desconto = result.getString("tipo_desconto");
		Integer id = result.getInt("id");
		Double preco_unitario = result.getDouble("preco_unitario");
		Integer quantidade = result.getInt("quantidade");
		Produto produto_id = (Produto) result.getObject("produto_id");
		Pedido pedido_id = (Pedido) result.getObject("pedido_id");

		
	}
	
	connection.close();
	return ipedidos;

}
public static void inserir(ItemPedido itemPedido, Produto produto, Pedido pedido) throws SQLException {
	
	ConnectionFactory factory = new ConnectionFactory();
	Connection connection = factory.recuperarConexao();
	
	String insertSql = "INSERT INTO comex.ITEM_PEDIDO(id, preco_unitario, quantidade, produto_id, pedido_id,"
			+ " desconto, tipo_desconto) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	PreparedStatement pstm = connection.prepareStatement(insertSql);
	
	pstm.setLong(1, itemPedido.getId());
	pstm.setDouble(2, itemPedido.getPrecoUnitario());
	pstm.setFloat(3, produto.getId());
	pstm.setLong(4, pedido.getId());
	pstm.setDouble(5, itemPedido.getDesconto());
	pstm.setLong(7, itemPedido.getTipoDesconto());
	
	pstm.execute();
	
	connection.close();
	
}public static void atualizar(ItemPedido itemPedido, Produto produto, Pedido pedido) throws SQLException {
	
	ConnectionFactory factory = new ConnectionFactory();
	Connection connection = factory.recuperarConexao();
	
	String insertSql = "UPDATE comex.ITEM_PEDIDO SET preco_unitario = ?, quantidade = ?, "
		//	+ "produto_id = ?, "
		//	+ "pedido_id = ?, desconto = ?, "
			+ "tipo_desconto = ? where id = ?";
	
	PreparedStatement pstm = connection.prepareStatement(insertSql);
	
	pstm.setDouble(1, itemPedido.getPrecoUnitario());
	pstm.setInt(2, itemPedido.getQuantidade());
	pstm.setFloat(3, produto.getId());
	pstm.setLong(4, pedido.getId());
	pstm.setDouble(5, itemPedido.getDesconto());
	pstm.setLong(6, itemPedido.getId());
	
	pstm.execute();
	
	connection.close();
}}
