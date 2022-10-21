package br.com.comex.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelos.Cliente;


public class ClienteDAO {
	private Connection con;
	
	public ClienteDAO(Connection con) {
		this.con = con;
	}
	
	
	public void createCliente(Cliente cliente) throws SQLException {
		
		String[] colunaParaRetornar = { "id" };
		String comandoSql = "INSERT INTO comex.cliente (NOME,CPF,TELEFONE,RUA,NUMERO,COMPLEMENTO,BAIRRO,CIDADE,UF) VALUES(?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement stm = con.prepareStatement(comandoSql, colunaParaRetornar);

		stm.setString(1,cliente.getNome());
		stm.setString(2,cliente.getCpf());
		stm.setString(3,cliente.getTelefone());
		stm.setString(4,cliente.getRua());
		stm.setString(5,cliente.getNumero());
		stm.setString(6,cliente.getComplemento());
		stm.setString(7,cliente.getBairro());
		stm.setString(8,cliente.getCidade());
		stm.setString(8, cliente.getUf());
		
		stm.execute();
		
	    ResultSet rs = stm.getGeneratedKeys();
	    rs.next();
	    cliente.setId(rs.getInt(1));
		stm.close();
	}
	
	public void deleteCliente(int id) throws SQLException {
		String comandoSql = "DELETE FROM comex.cliente WHERE id=?";
		
		PreparedStatement stm = con.prepareStatement(comandoSql); 
		
		stm.setInt(1, id);
		
		stm.execute();
		
		stm.close();
	}
	
	public void updateCliente(Cliente cliente, int id) throws SQLException {
		String comandoSql = "UPDATE comex.cliente SET nome=?, cpf=?, telefone=?, rua=?, numero=?, complemento=?, bairro=?, cidade=?, uf=?"
				+ "WHERE id=?";
		
		PreparedStatement stm = con.prepareStatement(comandoSql);
		
		stm.setString(1, cliente.getNome());
		stm.setString(2, cliente.getCpf());
		stm.setString(3, cliente.getTelefone());
		stm.setString(4, cliente.getRua());
		stm.setString(5, cliente.getNumero());
		stm.setString(6, cliente.getComplemento());
		stm.setString(7, cliente.getBairro());
		stm.setString(8, cliente.getCidade());
		stm.setString(9, cliente.getUf());
		stm.setInt(10, id);
		
		stm.execute();
		stm.close();
	}
	
	public List<Cliente> listClientes() throws SQLException {
		String comandoSql = "SELECT * FROM comex.cliente";
		List<Cliente> clientes = new ArrayList<Cliente>();
		PreparedStatement stm = con.prepareStatement(comandoSql);
		stm.execute();
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Cliente cliente = new Cliente();
			
			cliente.setId(rst.getInt("ID"));
			cliente.setNome(rst.getString("NOME"));
			cliente.setCpf(rst.getString("CPF"));
			cliente.setTelefone(rst.getString("TELEFONE")); 
			cliente.setRua(rst.getString("RUA"));
			cliente.setNumero(rst.getString("NUMERO"));;
			cliente.setComplemento(rst.getString("COMPLEMENTO"));
			cliente.setBairro(rst.getString("BAIRRO"));
			cliente.setCidade(rst.getString("CIDADE"));
			cliente.setUf(rst.getString("UF"));
			clientes.add(cliente);
		}
		
		rst.close();
		stm.close();
		return clientes;
	}
}