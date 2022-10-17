package br.com.comex.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelos.Categoria;
import br.com.comex.modelos.ConnectionFactory;
import br.com.comex.modelos.Produto;

public class DAOProduto {

	private Connection connection;

	public DAOProduto(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws SQLException {
		String sql = "INSERT INTO comex.PRODUTO(nome, descricao, preco_unitario, quantidade_estoque, categoria_id) VALUES (?, ?, ?, ?, ?)";
		try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
					
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setDouble(3, produto.getPrecoUnitario());
			pstm.setFloat(4, produto.getQuantidadeEstoque());
			pstm.setString(5, produto.getCategoriaProduto());

			
			pstm.execute();
			
			connection.close();
				
	}

}
	public static void atualizar(Produto produto, Categoria Categoria) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		String sql = "UPDATE comex.PRODUTO SET nome = ?, descricao = ?, preco_unitario = ?, "
				+ "quantidade_estoque = ?, categoria_id = ?, tipo = ?  where id = ?";
		
		PreparedStatement stm = connection.prepareStatement(sql);
		
		stm.setString(1, produto.getNome());
		stm.setString(2, produto.getDescricao());
		stm.setDouble(3, produto.getPrecoUnitario());
		stm.setFloat(4, produto.getQuantidadeEstoque());
		stm.setFloat(7, produto.getId());
		
		stm.execute();
		
		connection.close();
	}
	
	public static void remover(Integer id) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		String sql = "DELETE FROM comex.PRODUTO where id = ?";
		PreparedStatement stm = connection.prepareStatement(sql);
		
		stm.setInt(1, id);
		connection.close();
	}

public static List<Produto> listar() throws SQLException {
	
	List<Produto> produtos = new ArrayList<>();
	
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
		int categoria_id = resultS.getInt("categoria_id");
		String tipo = resultS.getString("tipo");
		
		produtos.add(new Produto(nome, descricao,
				preco_unitario, quantidade_estoque, categoria_id, id, tipo));
		

	}
	
	connection.close();
	return produtos;
}}
