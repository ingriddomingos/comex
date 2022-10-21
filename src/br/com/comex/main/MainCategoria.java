package br.com.comex.main;

import br.com.comex.modelos.Categoria;
import br.com.comex.modelos.StatusCategoria;

import java.util.ArrayList;



	public class MainCategoria {
		public static ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		public static boolean chave;
		
		public static void main(String[] args) {
		    
			Categoria categoria1 = new Categoria("Informática", StatusCategoria.ATIVA);
			categorias.add(categoria1);
			Categoria categoria2 = new Categoria("Móveis", StatusCategoria.INATIVA);
			categorias.add(categoria2);
			Categoria categoria3 = new Categoria("Livros", StatusCategoria.ATIVA);
			categorias.add(categoria3);}


		
		public static Categoria vincularCategoria(String nomec) {
			
			for(Categoria categoriaCadastrada : categorias) {
				if(categoriaCadastrada.getNome().equals(nomec)) {
					return categoriaCadastrada;
				}
			}
			return null;
		}
}
