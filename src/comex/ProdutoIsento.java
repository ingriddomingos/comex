package comex;

	public class ProdutoIsento extends Produto{
		private int id = 0;
		private String nome;
		private String descricao;
		private double precoUnitario;
		private int quantidadeEstoque;
		private String categoriaProduto;
		
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
		public double calculaEstoque() {
			return this.quantidadeEstoque * this.precoUnitario;
		}
	}
