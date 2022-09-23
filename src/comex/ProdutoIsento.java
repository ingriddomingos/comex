package comex;

	public class ProdutoIsento extends Produto{
		int id = 0;
		String nome;
		String descricao;
		double precoUnitario;
		int quantidadeEstoque;
		String categoriaProduto;
		
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
