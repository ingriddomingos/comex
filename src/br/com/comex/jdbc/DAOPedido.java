package br.com.comex.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelos.Cliente;
import br.com.comex.modelos.ConnectionFactory;
import br.com.comex.modelos.Pedido;
import br.com.comex.modelos.Produto;

public class DAOPedido {

	private Connection connection;

	public DAOPedido(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Pedido pedido, Cliente cliente) throws SQLException {
		String sql = "INSERT INTO comex.PEDIDO(data, cliente_id) VALUES (?, ?)";
		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, pedido.getData());
			pstm.setLong(2, cliente.getId());

			pstm.execute();

			connection.close();

			pstm.execute();

			connection.close();

		}

	}

	public static void atualizar(Pedido pedido, Cliente cliente) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();

		String sql = "UPDATE comex.PEDIDO SET data = ?, cliente_id = ? where id = ?";

		PreparedStatement stm = connection.prepareStatement(sql);

		stm.setString(1, pedido.getData());
		stm.setLong(2, cliente.getId());
		stm.setLong(3, pedido.getId());

		stm.execute();

		connection.close();
	}

	public static List<Pedido> listar() throws SQLException {

		List<Produto> pedidos = new ArrayList<>();

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		Statement stm = connection.createStatement();

		stm.execute("SELECT * FROM comex.PEDIDO");

		ResultSet resultS = stm.getResultSet();

		while (resultS.next()) {
			Integer id = resultS.getInt("id");
			String data = resultS.getString("data");
			Cliente cliente_id = (Cliente) resultS.getObject("cliente_id");

			System.out.println(pedidos);
		}

		connection.close();
		return listar();
	}

	public static void remover(Integer id) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		String sql = "DELETE FROM comex.PEDIDO where id = ?";
		PreparedStatement stm = connection.prepareStatement(sql);

		stm.setInt(1, id);
		connection.close();
	}
}
