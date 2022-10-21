package br.com.comex.modelos;

public class Produto {
	private int id;
	private String nome;
	private String descricao;
	private double preco_unitario;
	private int quantidade_estoque;
	private Categoria categoria;
	private String tipo;
	private int categoria_id;
	
	public Produto(String string, double d, int i, String string2) {
	}
	public Produto() {
	}
	public int getCategoria_id() {
		return categoria_id;
	}
	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}
	public int getId() {
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
	public double getPreco_unitario() {
		return preco_unitario;
	}
	public void setPreco_unitario(double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}
	public int getQuantidade_estoque() {
		return quantidade_estoque;
	}
	public void setQuantidade_estoque(int quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco_unitario="
				+ preco_unitario + ", quantidade_estoque=" + quantidade_estoque + ", categoria=" + categoria_id + ", tipo="
				+ tipo + "]";
	}
	public String getProdutoIsento() {
		return null;
	}
}