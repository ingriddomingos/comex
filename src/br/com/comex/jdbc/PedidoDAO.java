package br.com.comex.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelos.Pedido;


public class PedidoDAO {
	private Connection con;
	
	public PedidoDAO(Connection con) {
		this.con = con;
	}
	
	public void createPedido(Pedido pedido) throws SQLException {
		String comandoSql = "INSERT INTO comex.pedido (DATA,CLIENTE_ID) VALUES(?,?)";
		
		PreparedStatement stm = con.prepareStatement(comandoSql);
	
		stm.setDate(1,pedido.getData());
		stm.setInt(2,pedido.getCliente_id());
		
		stm.execute();
		stm.close();
	}
	
	public void deletePedido(int id) throws SQLException{
		String comandoSql = "DELETE FROM comex.pedido WHERE id=?";
		
		PreparedStatement stm = con.prepareStatement(comandoSql);
		
		stm.setInt(1,id);
		
		stm.execute();
		stm.close();
	}
	
	public void updatePedido(Pedido pedido, int id) throws SQLException {
		String comandoSql = "UPDATE comex.pedido SET data=?, cliente_id=? WHERE id=?";
		
		PreparedStatement stm = con.prepareStatement(comandoSql); 
		
		stm.setDate(1, pedido.getData());
		stm.setInt(2, pedido.getCliente_id());
		stm.setInt(3, id);
		
		stm.execute();
		stm.close();
	}
	
	public List<Pedido> listPedidos() throws SQLException {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		String comandoSql = "SELECT * FROM comex.pedido";
		
		PreparedStatement stm = con.prepareStatement(comandoSql);
		stm.execute();
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Pedido pedido = new Pedido();
			
			pedido.setId(rst.getInt("ID"));
			pedido.setData(rst.getDate("DATA")); 
			pedido.setCliente_id( rst.getInt("CLIENTE_ID"));
			
			pedidos.add(pedido);
			
		}
		
		rst.close();
		stm.close();
		return pedidos;
	}
}