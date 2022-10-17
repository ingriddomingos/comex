package br.com.comex.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.comex.modelos.StatusCategoria;

import br.com.comex.modelos.ConnectionFactory;

public class MainInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		try(Connection connection = factory.recuperarConexao()){
		
		connection.setAutoCommit(false);
		try {
			PreparedStatement stm = connection.prepareStatement("INSERT INTO comex.CATEGORIA (nome, status) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
		
//		(nome, status, stm);
		adicionarVariavel("BRINQUEDOS", StatusCategoria.ATIVA, stm);
		adicionarVariavel("ELETRODOMESTICOS", StatusCategoria.INATIVA, stm);
		
		connection.commit();
		stm.close();
		connection.close();
		
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Rollback efetuado! ");
			connection.rollback();
		}
		
	}
	}

	private static void adicionarVariavel(String nome, StatusCategoria status, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, status.name());

		stm.execute();

		System.out.println("A categoria foi criada com êxito! ");
	}
	
}



