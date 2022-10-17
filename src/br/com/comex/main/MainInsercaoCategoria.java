package br.com.comex.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.comex.modelos.StatusCategoria;

import br.com.comex.modelos.ConnectionFactory;

public class MainInsercaoCategoria {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();

		Statement stm = connection.createStatement();

		stm.execute("INSERT INTO comex.CATEGORIA(nome, status) VALUES ('INFORMÁTICA', 'ATIVA')");
		stm.execute("INSERT INTO comex.CATEGORIA(nome, status) VALUES ('MÓVEIS', 'INATIVA')");
		stm.execute("INSERT INTO comex.CATEGORIA(nome, status) VALUES ('LIVROS', 'ATIVA')");

		System.out.println("Campos inseridos com êxito! ");
		
		connection.close();

	}

}