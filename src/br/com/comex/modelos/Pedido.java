package br.com.comex.modelos;

public class Pedido {
	private long id;
	private static long contadorID;
	public Cliente cliente;
	private String data;

	public Pedido(String data, Cliente cliente){
		this.id = contadorID;
		this.data = data;
		this.cliente = cliente;
		contadorID++;
	}
	
	public Pedido(Integer id, String data, Cliente cliente) {
		this.data = data;
		this.cliente = cliente;
	}

	public long getId() {
		return id;
	}
	
	public String getData() {
		return data;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public String toString() {
		return "ID: " + getId() + "\n Data: " + getData() + "\n Cliente_id: " + getCliente().getId();
	}

}