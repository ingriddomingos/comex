package br.com.comex.modelos;

public class Categoria {
	private int id;
	private String nome;
	private String status;
	
	
	public Categoria(String string, StatusCategoria ativa) {
	}

	public Categoria() {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", status=" + status + "]";
	}
	public void setStatus(StatusCategoria ativa) {
		
	}

}