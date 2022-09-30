package br.com.comex.main;

import br.com.comex.modelos.Categoria;
import br.com.comex.modelos.StatusCategoria;

public class MainCategoria {

	public static void main(String[] args) {
		try {

			Categoria categoria1 = new Categoria(1, "INFORMATICA", StatusCategoria.ATIVA);
			System.out.println("Categoria " + categoria1.getNome() + "  (" + categoria1.getId() + " - "
					+ categoria1.getStatus().name().toLowerCase() + ")");

			Categoria categoria2 = new Categoria(2, "MOVEIS", StatusCategoria.INATIVA);
			System.out.println("Categoria " + categoria2.getNome() + "  (" + categoria2.getId() + " - "
					+ categoria2.getStatus().name().toLowerCase() + ")");

			Categoria categoria3 = new Categoria(3, "LIVROS", StatusCategoria.ATIVA);
			System.out.println("Categoria " + categoria3.getNome() + "  (" + categoria3.getId() + " - "
					+ categoria3.getStatus().name().toLowerCase() + ")");
			
			//TESTES
			// forçar erro de nome maior que 3 caracteres
			//Categoria categoria4 = new Categoria(4, "ind");
			//System.out.println("Categoria " + categoria4.getNome() + "  (" + categoria4.getId() + " - "
			//		+ categoria4.getStatus().name().toLowerCase() + ")");
			
			// forçar erro de nome obrigatório:
			//Categoria categoria5 = new Categoria(8, null);
			//System.out.println("Categoria " + categoria5.getNome() + "  (" + categoria5.getId() + " - "
			//		+ categoria5.getStatus().name().toLowerCase() + ")");
			
			// forcar id
			//Categoria categoria4 = new Categoria(null);
			//System.out.println("Categoria " + categoria4.getNome() + "  (" + categoria4.getId() + " - "
			//		+ categoria4.getStatus().name().toLowerCase() + ")");

		} catch (IllegalArgumentException ex) {
			System.out.println("Tente novamente: " + ex.getMessage());
		}

	}
}
