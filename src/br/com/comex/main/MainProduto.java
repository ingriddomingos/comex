package br.com.comex.main;

import br.com.comex.modelos.Produto;

public class MainProduto {

	public static void main(String[] args) {

		Produto produto1 = new Produto();
		
		//produto1.setId(0);
		produto1.setNome(null); 
		produto1.setDescricao("Notebook prático, leve e perfeito para acompanhar sua rotina! "); 
		produto1.setPrecoUnitario(3523.00);
		produto1.setQuantidadeEstoque(1);
		produto1.setCategoriaProduto("Informatica");
		
		System.out.println("Produto: " + produto1.getId() + " ID: " + produto1.getId());
		System.out.println("Nome: " + produto1.getNome());
		System.out.println("Descrição: " + produto1.getDescricao());
		System.out.println("Preço Unitário: " + produto1.getPrecoUnitario());
		System.out.println("Quantidade em estoque: " + produto1.getQuantidadeEstoque());
		System.out.println("Categoria: " + produto1.getCategoriaProduto());
		System.out.println("Imposto: " + produto1.getPrecoUnitario() * 40 / 100);
		System.out.println("Valor total em estoque: " + produto1.getPrecoUnitario() * produto1.getQuantidadeEstoque() + " \n");
	}

}