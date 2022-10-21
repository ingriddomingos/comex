package br.com.comex.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ItemPedidoDAO {
	private Connection con;
	
	public ItemPedidoDAO(Connection con) {
		this.con = con;
	}
	
	public void createItem(ItemPedido item) throws SQLException {
		String comandoSql = "INSERT INTO comex.item_pedido (PRECO_UNITARIO,QUANTIDADE,PRODUTO_ID,PEDIDO_ID,DESCONTO,TIPO_DESCONTO) VALUES(?,?,?,?,?,?)";
		
		PreparedStatement stm = con.prepareStatement(comandoSql);
	
		stm.setDouble(1,item.getPreco_unitario());
		stm.setInt(2,item.getQuantidade());
		stm.setInt(3,item.getProduto_id());
		stm.setInt(4,item.getPedido_id());
		stm.setDouble(5,item.getDesconto());
		stm.setString(6,item.getTipo_desconto());
		
		stm.execute();
		stm.close();
	}
	
	public void deleteItem(int id) throws SQLException{
		String comandoSql = "DELETE FROM comex.item_pedido WHERE id=?";
		
		PreparedStatement stm = con.prepareStatement(comandoSql);
		
		stm.setInt(1,id);
		
		stm.execute();
		stm.close();
	}
	
	public void updateItem(ItemPedido item, int id) throws SQLException {
		String comandoSql = "UPDATE comex.item_pedido SET preco_unitario=?,quantidade=?,produto_id=?,pedido_id=?,desconto=?,tipo_desconto=?"
				+ " WHERE id=?";
		
		PreparedStatement stm = con.prepareStatement(comandoSql); 
		
		stm.setDouble(1, item.getPreco_unitario());
		stm.setInt(2, item.getQuantidade());
		stm.setInt(3, item.getProduto_id());
		stm.setInt(4, item.getPedido_id());
		stm.setDouble(5, item.getDesconto());
		stm.setString(6, item.getTipo_desconto());
		stm.setInt(7, id);
		
		stm.execute();
		stm.close();
	}
	
	public List<ItemPedido> listItens() throws SQLException {
		List<ItemPedido> itens = new ArrayList<ItemPedido>();
		
		String comandoSql = "SELECT * FROM comex.item_pedido";
		
		PreparedStatement stm = con.prepareStatement(comandoSql);
		stm.execute();
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			ItemPedido item = new ItemPedido();
			
			item.setId(rst.getInt("ID"));
			item.setPreco_unitario( rst.getDouble("PRECO_UNITARIO")); 
			item.setQuantidade(rst.getInt("QUANTIDADE")); 
			item.setProduto_id(rst.getInt("PRODUTO_ID"));  
			item.setPedido_id(rst.getInt("PEDIDO_ID"));
			item.setDesconto(rst.getDouble("DESCONTO"));
			item.setTipo_desconto(rst.getString("TIPO_DESCONTO"));
			
			itens.add(item);
		}
		
		rst.close();
		stm.close();
		return itens;
	}
}