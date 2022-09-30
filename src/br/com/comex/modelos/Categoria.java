package br.com.comex.modelos;

public class Categoria {

	private static long proximoId = 1;

	private long id;
	private String nome;
	private StatusCategoria status;

	public Categoria(long id, String nome, StatusCategoria status) {
		if (id != proximoId) {
			throw new IllegalArgumentException("O id precisa ser em ordem, favor informar novamente! ");
		}

		this.id = id;
		this.nome = nome;
		this.status = status;
		proximoId++;
	}

	public Categoria(long id, String nome) {
		if (nome == null) {
			throw new IllegalArgumentException("É necessário atribuir um nome para o curso!  ");
		}
		if (nome.length() <= 3) {
			throw new IllegalArgumentException("É necessário ter mais de 3 caracteres o nome do curso! ");
		}

		this.id = proximoId;
		this.nome = nome;
		this.status = StatusCategoria.ATIVA;
		proximoId++;
	}


	public Categoria(String nome, StatusCategoria status) {
	}

	public static long getProximoId() {
		return proximoId;
	}

	public static void setProximoId(long proximoId) {
		Categoria.proximoId = proximoId;
	}

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
