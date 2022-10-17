package br.com.comex.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.comex.modelos.ConnectionFactory;
import br.com.comex.modelos.Cliente;
public class DAOCliente {

public static void remover(Integer id) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		String sql = "DELETE FROM comex.CLIENTE where id = ?";
		PreparedStatement pstm = connection.prepareStatement(sql);
		
		pstm.setInt(1, id);
		connection.close();
	}

	
public static void atualizar(Cliente cliente) throws SQLException {
	
	ConnectionFactory factory = new ConnectionFactory();
	Connection connection = factory.recuperarConexao();
	
	String sql = "UPDATE comex.CLIENTE SET nome = ?, cpf = ?, telefone = ?, "
			+ "rua = ?,"
			//+ " numero = ?, complemento = ?, bairro = ?, "
			+ "cidade = ?, uf = ?  where id = ?";
	
	PreparedStatement pstm = connection.prepareStatement(sql);
	
	pstm.setString(1, cliente.getNome());
	pstm.setString(2, cliente.getCpf());
	pstm.setString(3, cliente.getTelefone());
	pstm.setString(4, cliente.getRua());
	pstm.setString(5, cliente.getNumeroEnd());
	pstm.setString(6, cliente.getComplemento());
	pstm.setString(7, cliente.getBairro());
	pstm.setString(8, cliente.getCidade());
	pstm.setString(9, cliente.getEstados());
	pstm.setLong(10, cliente.getId());
	
	pstm.execute();
	
	connection.close();
	
	
}public static void inserir(Cliente cliente) throws SQLException {
	
	ConnectionFactory factory = new ConnectionFactory();
	Connection connection = factory.recuperarConexao();
	
	String sql = "INSERT INTO comex.CLIENTE(nome, cpf, telefone, rua, numero,"
			+ " complemento, bairro, cidade, uf) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	PreparedStatement pstm = connection.prepareStatement(sql);
	
	pstm.setString(1, cliente.getNome());
	pstm.setString(2, cliente.getCpf());
	pstm.setString(3, cliente.getTelefone());
	pstm.setString(4, cliente.getRua());
	pstm.setString(5, cliente.getNumeroEnd());
	pstm.setString(6, cliente.getComplemento());
	pstm.setString(7, cliente.getBairro());
	pstm.setString(8, cliente.getCidade());
	pstm.setObject(9, cliente.getEstado());
	
	pstm.execute();
	
	connection.close();
	
}}
