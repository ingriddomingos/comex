package comex;

public class Categoria {

	private long id;
	private String nome;
	private StatusCategoria status = StatusCategoria.ativa;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public StatusCategoria getStatus() {
		return status;
	}
	public void setStatus(StatusCategoria status) {
		this.status = status;
	}
	
}
