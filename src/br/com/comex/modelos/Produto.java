package br.com.comex.modelos;

public class Produto {

	private static long proximoId = 1;
	private long id;
	private String nome;
	private String descricao;
	private double precoUnitario;
	private float quantidadeEstoque;
	private String categoriaProduto;
	private int Isento;


	public Produto(long id, String nome, double precoUnitario, float quantidadeEstoque,
			String categoriaProduto) {
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

	public Produto(String nome, String descricao, double precoUnitario, float quantidadeEstoque, int i, int j, String categoriaProduto) {
	}

	public Produto() {
	}


	public Produto(long id,String nome, String descricao, double precoUnitario, float quantidadeEstoque, String categoriaProduto) {
	
	if (id == 0) 
		throw new IllegalArgumentException("O Id deve ser maior que 0! ");
	}

		public Produto(String nome2, String descricao2, Integer preco_unitario, Integer quantidade_estoque,
			int categoria_id, Integer id2, String tipo) {
	}



		public Produto(String nome2, String descricao2, double precoUnitario2, int quantidadeEstoque2, int i, int j,
				String categoriaProduto2) {
		}

		public Produto(String string, String string2, String string3, String string4, char c, String string5) {
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