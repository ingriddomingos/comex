package br.com.comex.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.comex.modelos.ConnectionFactory;

public class MainAtualizacaoCategoria {
	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();

		Statement stm = connection.createStatement();
		stm.execute("UPDATE comex.CATEGORIA SET nome = 'LIVROS TÉCNICOS' WHERE nome = 'LIVROS'");
		System.out.println("Categoria atualizada com êxito!");
		connection.close();
	}
}