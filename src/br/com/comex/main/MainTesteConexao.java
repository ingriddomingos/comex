package br.com.comex.main;

import java.sql.SQLException;

import br.com.comex.modelos.ConnectionFactory;

import java.sql.Connection;

public class MainTesteConexao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();

		System.out.println("Conexão Efetuada! ");

		connection.close();
	}
}
