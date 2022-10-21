package br.com.comex.ws;
	import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
	import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.comex.jdbc.CategoriaDAO;
import br.com.comex.jdbc.ClienteDAO;
import br.com.comex.jdbc.ProdutoDAO;
import br.com.comex.modelos.Categoria;
import br.com.comex.modelos.Cliente;
import br.com.comex.modelos.ConnectionFactory;
import br.com.comex.modelos.Produto;



	@WebService
	public class ComexWS {

		@WebMethod(operationName = "listarCategorias")
		@WebResult(name = "categoria")

		public List<Categoria> getCategorias() throws SQLException {
			List<Categoria> listaDeCategorias = new ArrayList<Categoria>();

			Connection connection = new ConnectionFactory().recuperarConexao();
				CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
				listaDeCategorias = categoriaDAO.listCategoria();

			
			return listaDeCategorias;
		}
	
		
		@WebMethod(operationName="CadastrarCategoria") 
		@WebResult(name="categoria")
		public Categoria adicionarCategoria(@WebParam(name = "nome")String nome) throws SQLException {
			Categoria categoria = new Categoria();
			
			Connection connection = new ConnectionFactory().recuperarConexao();
				CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
				categoria.setNome(nome);
				categoria.setStatus("ATIVA");
				categoriaDAO.createCategoria(categoria);
		
			return categoria;
		}
	
		
		@WebMethod(operationName="TodosOsClientes")
		@WebResult(name="cliente")
		public List<Cliente> listarClientes()throws SQLException{
			List<Cliente> listaDeClientes = new ArrayList<Cliente>();
			
			Connection connection = new ConnectionFactory().recuperarConexao();
				ClienteDAO clienteDAO = new ClienteDAO(connection);
				listaDeClientes = clienteDAO.listClientes();
			
			return listaDeClientes;	
		}
		
		
		@WebMethod(operationName="CadastrarCliente") 
		@WebResult(name="cliente")
		public Cliente adicionarCliente(
				@WebParam(name = "nome")String nome, 
				@WebParam(name = "cpf")String cpf,
				@WebParam(name = "telefone")String telefone,
				@WebParam(name = "rua")String rua,
				@WebParam(name = "numero")String numero,
				@WebParam(name = "complemento")String complemento,
				@WebParam(name = "bairro")String bairro,
				@WebParam(name = "cidade")String cidade,
				@WebParam(name = "UF")String uf)
				throws SQLException {
			
			Cliente cliente = new Cliente();
			
			Connection connection = new ConnectionFactory().recuperarConexao();
				ClienteDAO clienteDAO = new ClienteDAO(connection);
				cliente.setNome(nome);
				cliente.setCpf(cpf);
				cliente.setTelefone(telefone);
				cliente.setRua(rua);
				cliente.setNumero(numero);
				cliente.setComplemento(complemento);
				cliente.setBairro(bairro);
				cliente.setCidade(cidade);
				cliente.setUf(uf);
				clienteDAO.createCliente(cliente);
			
			return cliente;
		}

		
		@WebMethod(operationName="TodosOsProdutos")
		@WebResult(name="produto")
		public List<Produto> listarProdutos()throws SQLException{
			List<Produto> listaDeProdutos = new ArrayList<Produto>();
			
			Connection connection = new ConnectionFactory().recuperarConexao();
				ProdutoDAO produtoDAO = new ProdutoDAO(connection);
				listaDeProdutos = produtoDAO.listProdutos();
			
			return listaDeProdutos;	
		}

	}
	