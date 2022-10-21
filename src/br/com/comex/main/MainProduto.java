package br.com.comex.main;

import br.com.comex.modelos.Categoria;
import br.com.comex.modelos.Produto;
import br.com.comex.modelos.StatusCategoria;
import br.com.comex.modelos.ProdutoIsento;

public class MainProduto {

	public static void main(String[] args) {
		try {
				//testes exception 
				//Produto produto1 = new Produto(null, 2403.20,1,"Tecnologia");
				//Produto produto1 = new Produto("ind",2403.20,1,"Tecnologia");
				//Produto produto1 = new Produto("Televisão",0,1,"Tecnologia");
				Produto produto1 = new Produto("Televisão",2403.20,0,"Tecnologia");


//				Produto produto2 = new Produto();
//				Produto produto3 = new Produto();
			
				//String nome, double precoUnitario, float quantidadeEstoque, String categoriaProduto
				
						
				System.out.println("Produto: " + produto1.getId() + " ID: " + produto1.getId());
				System.out.println("Nome: " + produto1.getNome());
				System.out.println("Descrição: " + produto1.getDescricao());
				System.out.println("Preço Unitário: " + produto1.getPreco_unitario());
				System.out.println("Quantidade em estoque: " + produto1.getQuantidade_estoque());
				System.out.println("Categoria: " + produto1.getCategoria_id());
				System.out.println("Imposto: " + produto1.getPreco_unitario() * 40 / 100);
				System.out.println("Valor total em estoque: " + produto1.getPreco_unitario() * produto1.getQuantidade_estoque() + " \n");
				
//				System.out.println("Produto: " + produto2.getId() + " ID: " + produto2.getId());
//				System.out.println("Nome: " + produto2.getNome());
//				System.out.println("Descrição: " + produto2.getDescricao());
//				System.out.println("Preço Unitário: " + produto2.getPreco_unitario());
//				System.out.println("Quantidade em estoque: " + produto2.getQuantidade_estoque());
//				System.out.println("Categoria: " + produto2.getCategoria_id());
//				System.out.println("Imposto: " + produto2.getProdutoIsento());
//				System.out.println("Valor total em estoque: " + produto2.getPreco_unitario() * produto2.getQuantidade_estoque() + "\n");
//				
//				System.out.println("Produto: " + produto3.getId() + " ID: " + produto3.getId());
//				System.out.println("Nome: " + produto3.getNome());
//				System.out.println("Descrição: " + produto3.getDescricao());
//				System.out.println("Preço Unitário: " + produto3.getPreco_unitario());
//				System.out.println("Quantidade em estoque: " + produto3.getQuantidade_estoque());
//				System.out.println("Categoria: " + produto3.getCategoria_id());
//				System.out.println("Imposto: " + produto3.getPreco_unitario() * 40 / 100);
//				System.out.println("Valor total em estoque: " + produto3.getPreco_unitario() * produto3.getQuantidade_estoque());
				

		} catch (IllegalArgumentException ex) {
			System.out.println("Tente novamente: " + ex.getMessage());
		}
	}
}