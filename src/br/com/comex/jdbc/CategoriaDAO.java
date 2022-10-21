package br.com.comex.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelos.Categoria;



public class CategoriaDAO {
	private Connection con;
	
	public CategoriaDAO(Connection con) {
		this.con = con;
	}
	
	public void createCategoria(Categoria categoria) throws SQLException {
		String[] colunaParaRetornar = { "id" };
		
		String comandoSql = "INSERT INTO comex.categoria (nome,status) VALUES (?,?)";
		
		PreparedStatement stm = con.prepareStatement(comandoSql, colunaParaRetornar); 
		
		stm.setString(1, categoria.getNome());
		stm.setString(2, categoria.getStatus());
				
		stm.execute();
		
	    ResultSet rs = stm.getGeneratedKeys();
	    rs.next();
	    categoria.setId(rs.getInt(1));
		stm.close();
	}
	
	public void updateCategoria(Categoria categoria, int id) throws SQLException {
		String comandoSql = "UPDATE comex.categoria SET nome=? ,status=?"
				+ "WHERE id=?";
		
		PreparedStatement stm = con.prepareStatement(comandoSql); 
	
		stm.setString(1, categoria.getNome());
		stm.setString(2, categoria.getStatus());
		stm.setInt(3, id);
		
		stm.execute();
		stm.close();
	}
	
	public void deleteCategoria(int id) throws SQLException {		
		String comandoSql = "DELETE FROM comex.categoria WHERE id=?";
		
		PreparedStatement stm = con.prepareStatement(comandoSql); 
		
		stm.setInt(1,id);
		
		stm.execute();
		stm.close();
	}
	
	public List<Categoria> listCategoria() throws SQLException {		
		String comandoSql = "SELECT * FROM comex.categoria";
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		PreparedStatement stm = con.prepareStatement(comandoSql); 
		stm.execute();
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Categoria categoria = new Categoria();
			
			categoria.setId(rst.getInt("ID"));
			categoria.setNome(rst.getString("NOME"));
			categoria.setStatus(rst.getString("STATUS")); 
			
			categorias.add(categoria);
		}
		
		rst.close();
		stm.close();
		
		return categorias;
	}
}