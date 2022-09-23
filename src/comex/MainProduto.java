package comex;

public class MainProduto {

	public static void main(String[] args) {
		Produto produto1 = new Produto();
		Produto produto2 = new Produto();
		Produto produto3 = new Produto();
	
		produto1.id = 1;
		produto1.nome = "Notebook Samsung";
		produto1.descricao = "Notebook prático, leve e perfeito para acompanhar sua rotina! ";
		produto1.precoUnitario = 3523.00;
		produto1.quantidadeEstoque = 1;
		produto1.categoriaProduto = "Informática";
		
		produto2.id = 2;
		produto2.nome = "Clean Architecture";
		produto2.descricao = "A Craftsman's Guide to Software Structure and Design! ";
		produto2.precoUnitario = 109.90;
		produto2.quantidadeEstoque = 2;
		produto2.categoriaProduto = "Livros";
		
		produto3.id = 3;
		produto3.nome = "Monitor Dell 27";
		produto3.descricao = "Manteha a produtividade onde quer que você trabalhe! ";
		produto3.precoUnitario = 1889.00;
		produto3.quantidadeEstoque = 3;
		produto3.categoriaProduto = "Informática";
		
				
		System.out.println("Produto: " + produto1.getId() + " ID: " + produto1.getId());
		System.out.println("Nome: " + produto1.getNome());
		System.out.println("Descrição: " + produto1.getDescricao());
		System.out.println("Preço Unitário: " + produto1.getPrecoUnitario());
		System.out.println("Quantidade em estoque: " + produto1.getQuantidadeEstoque());
		System.out.println("Categoria: " + produto1.getCategoriaProduto());
		System.out.println("Imposto: " + produto1.getPrecoUnitario() * 40 / 100);
		System.out.println("Valor total em estoque: " + produto1.getPrecoUnitario() * produto1.getQuantidadeEstoque() + " \n");
		
		System.out.println("Produto: " + produto2.getId() + " ID: " + produto2.getId());
		System.out.println("Nome: " + produto2.getNome());
		System.out.println("Descrição: " + produto2.getDescricao());
		System.out.println("Preço Unitário: " + produto2.getPrecoUnitario());
		System.out.println("Quantidade em estoque: " + produto2.getQuantidadeEstoque());
		System.out.println("Categoria: " + produto2.getCategoriaProduto());
		System.out.println("Imposto: " + produto2.getProdutoIsento());
		System.out.println("Valor total em estoque: " + produto2.getPrecoUnitario() * produto2.getQuantidadeEstoque() + "\n");
		
		System.out.println("Produto: " + produto3.getId() + " ID: " + produto3.getId());
		System.out.println("Nome: " + produto3.getNome());
		System.out.println("Descrição: " + produto3.getDescricao());
		System.out.println("Preço Unitário: " + produto3.getPrecoUnitario());
		System.out.println("Quantidade em estoque: " + produto3.getQuantidadeEstoque());
		System.out.println("Categoria: " + produto3.getCategoriaProduto());
		System.out.println("Imposto: " + produto3.getPrecoUnitario() * 40 / 100);
		System.out.println("Valor total em estoque: " + produto3.getPrecoUnitario() * produto3.getQuantidadeEstoque());
		

}
	}