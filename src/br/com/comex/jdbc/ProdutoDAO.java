package br.com.comex.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelos.Produto;


public class ProdutoDAO {
	private Connection con;
	
	public ProdutoDAO(Connection con) {
		this.con = con;
	}
	
	public void createProduto(Produto produto) 
			throws SQLException {
		String comandoSql = "INSERT INTO comex.produto (NOME,DESCRICAO,PRECO_UNITARIO,QUANTIDADE_ESTOQUE,CATEGORIA_ID,TIPO) VALUES(?,?,?,?,?,?)";
		
		PreparedStatement stm = con.prepareStatement(comandoSql);
		
		stm.setString(1,produto.getNome());
		stm.setString(2,produto.getDescricao());
		stm.setDouble(3,produto.getPreco_unitario());
		stm.setInt(4,produto.getQuantidade_estoque());
		stm.setInt(5,produto.getCategoria_id());
		stm.setString(6,produto.getTipo());
		
		stm.execute();
		stm.close();
	}
	
	public List<Produto> listProdutos() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		
		String comandoSql = "SELECT * FROM comex.produto";
		PreparedStatement stm = con.prepareStatement(comandoSql);
		stm.execute();
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Produto produto = new Produto();
			
			produto.setId(rst.getInt("ID")); 
			produto.setNome( rst.getString("NOME"));
			produto.setDescricao(rst.getString("DESCRICAO"));
			produto.setPreco_unitario(rst.getDouble("PRECO_UNITARIO"));
			produto.setQuantidade_estoque(rst.getInt("QUANTIDADE_ESTOQUE"));
			produto.setCategoria_id(rst.getInt("CATEGORIA_ID"));
			produto.setTipo(rst.getString("TIPO")); 
			
			produtos.add(produto);
		}
		
		rst.close();
		stm.close();
		return produtos;
	}
	
	public void deleteProduto(int id) throws SQLException{
		String comandoSql = "DELETE FROM comex.produto WHERE id=?";
		
		PreparedStatement stm = con.prepareStatement(comandoSql);
		
		stm.setInt(1,id);
		
		stm.execute();
		stm.close();
	}
	
	public void updateProduto(Produto produto, int id) throws SQLException {
		String comandoSql = "UPDATE comex.produto SET nome=?, descricao=?, preco_unitario=?, quantidade_estoque=?, categoria_id=?,tipo=?"
				+ "WHERE id=?";
		
		PreparedStatement stm = con.prepareStatement(comandoSql); 
		
		stm.setString(1, produto.getNome());
		stm.setString(2, produto.getDescricao());
		stm.setDouble(3, produto.getPreco_unitario());
		stm.setInt(4, produto.getQuantidade_estoque());
		stm.setInt(5, produto.getCategoria_id());
		stm.setString(6, produto.getTipo());
		stm.setInt(7, id);
		
		stm.execute();
		stm.close();
	}
	
	
}