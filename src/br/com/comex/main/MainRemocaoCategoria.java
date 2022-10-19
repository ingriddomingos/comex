package br.com.comex.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.comex.modelos.ConnectionFactory;

public class MainRemocaoCategoria {
	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();

		PreparedStatement stm = connection.prepareStatement("DELETE FROM comex.CATEGORIA WHERE status = ?");
		stm.setString(1, "INATIVA");
		stm.execute();
		Integer linhasAlteradas = stm.getUpdateCount();
		System.out.println("Categorias excluídas com êxito: " + linhasAlteradas);
		connection.close();

	}
}
