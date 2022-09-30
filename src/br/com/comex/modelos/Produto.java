package br.com.comex.modelos;

public class Produto {

	private static long proximoId = 1;
	private long id;
	private String nome;
	private String descricao;
	private double precoUnitario;
	private float quantidadeEstoque;
	private String categoriaProduto;
	int Isento;


	public Produto(long id, String nome, String descricao, double precoUnitario, float quantidadeEstoque,
			String categoriaProduto) {
		if (id != proximoId) {
			throw new IllegalArgumentException("Favor informar o id na ordem! ");
		}
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
		this.quantidadeEstoque = quantidadeEstoque;
		this.categoriaProduto = categoriaProduto;
	}

	public Produto(String nome, double precoUnitario, float quantidadeEstoque, String categoriaProduto) {
		if (nome == null) {
			throw new IllegalArgumentException("É necessário informar um nome para o curso! ");
		}
		if (id == 0) 
			throw new IllegalArgumentException("O Id deve ser maior que 0! ");

		if (nome.length() <= 5) {
			throw new IllegalArgumentException("Favor informar um nome para o curso com no mínimo 5 caracteres! ");
		}
		if (precoUnitario == 0) {
			throw new IllegalArgumentException("O preço não pode ser igual a zero! ");
		}
		if (quantidadeEstoque == 0) {
			throw new IllegalArgumentException("A quantidade não pode ser igual a zero! ");
		}
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.quantidadeEstoque = quantidadeEstoque;
		this.categoriaProduto = categoriaProduto;
	}

	public Produto(int i, String string, String string2, double d, int j, String string3) {
	}

	public Produto() {
	}


	public Produto(String nome, String descricao, double precoUnitario, double quantidadeEstoque, String categoriaProduto) {
	}

		public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public float getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(String categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public int getProdutoIsento() {
		return 0;
	}

	public void setIsento(int Isento) {
		this.Isento = Isento;
	}

	public String calculaValorEstoque() {
		return null;
	}

	public String calculaImposto() {
		return null;
	}


}