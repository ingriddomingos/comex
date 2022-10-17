package br.com.comex.modelos;

public class Cliente {
	private static long contadorID = 1;
	private long id;
	private String nome;
	private String cpf;
	private String telefone;
	private String rua;
	private String numeroEnd;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estados;
	private Estado estado;

	public Cliente(String nome, String cpf, String telefone, String rua, String numeroEnd, String complemento, 
			String bairro, String cidade, Estado estado) {
		
		this.id = contadorID;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.rua = rua; 
		this.numeroEnd = numeroEnd;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		contadorID++;
		

		validacaoCpf();
		
	}
	
	public Cliente(Integer id,String nome, String cpf, String telefone, String rua,
			String numeroEnd, String complemento, String bairro, String cidade, String estados) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.rua = rua;
		this.numeroEnd = numeroEnd;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estados = estados;
	}
	
	public void validacaoId() throws Exception {
		if (id < 0)
			throw new Exception("Id deve ser maior que 0");
	}
	
	public void validacaoNome() throws Exception {
		if (nome.length() < 5 | nome == null)
			throw new Exception("O nome deve ser maior que 5, e não pode ser  nulo");
		
		if (nome.matches("[0-9].*")) 
			throw new Exception("O nome deve iniciar somente com letras!");
	
	
		if (!telefone.matches("^\\([0-9]{2}\\) [0-9]{1} ([0-9]{4}-[0-9]{4})$")) 
			throw new Exception("O telefone deve ser formatado da "
					+ "forma a seguir. Ex: (00) 0 0000-0000");
	}
	
	public void validacaoCpf() {
		if (cpf.length() < 11 | cpf.length() > 14 | cpf == null)
			throw new IllegalArgumentException("cpf deve conter de 11 a 14 caracteres");}
		
	
	public long getId() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public String getRua() {
		return this.rua;
	}
	
	public String getNumeroEnd() {
		return this.numeroEnd;
	}
	
	public String getComplemento() {
		return this.complemento;
	}
	
	public String getBairro() {
		return this.bairro;
	}
	
	public String getCidade() {
		return this.cidade;
	}
	
	public enum Estado {
		AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, MT, MS, MG,
		PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO;
	}
	
	public Estado getEstado() {
		return this.estado;
	}
	public String getEstados() {
		return estados;
		
	}
	
	public String toString() {
		return "ID: " + getId() + "\n Nome: " + getNome() + "\n CPF: " + getCpf() +
				"\n Telefone: " + getTelefone() + "\n Rua: " + getRua()
				+ "\n Numero Endereço: " + getNumeroEnd() + "\n Complemento: " + getComplemento() +
				"\n Bairro: " + getBairro() + "\n Cidade: " + getCidade() + "\n\n";


	}}


