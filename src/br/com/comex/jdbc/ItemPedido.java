package br.com.comex.jdbc;

import br.com.comex.modelos.Pedido;
import br.com.comex.modelos.Produto;

public class ItemPedido {
	private int id;
	private double preco_unitario;
	private int quantidade;
	private Produto produto;
	private Pedido pedido;
	private int produto_id;
	private int pedido_id;
	private Double desconto;
	private String tipo_desconto;
	
	
	
	public int getProduto_id() {
		return produto_id;
	}
	public void setProduto_id(int produto_id) {
		this.produto_id = produto_id;
	}
	public int getPedido_id() {
		return pedido_id;
	}
	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPreco_unitario() {
		return preco_unitario;
	}
	public void setPreco_unitario(double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public String getTipo_desconto() {
		return tipo_desconto;
	}
	public void setTipo_desconto(String tipo_desconto) {
		this.tipo_desconto = tipo_desconto;
	}
	
	
	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", preco_unitario=" + preco_unitario + ", quantidade=" + quantidade
				+ ", produto=" + produto_id + ", pedido=" + pedido_id + ", desconto=" + desconto + ", tipo_desconto="
				+ tipo_desconto + "]";
	}
}