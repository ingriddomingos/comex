package comex;

public class MainCategoria {

	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria();
		categoria1.setId(1);
		categoria1.setNome("INFORMATICA");
		categoria1.setStatus(StatusCategoria.ATIVA);
		
		Categoria categoria2 = new Categoria();
		categoria2.setId(2);
		categoria2.setNome("MOVEIS");
		categoria2.setStatus(StatusCategoria.INATIVA);
		
		Categoria categoria3 = new Categoria();
		categoria3.setId(3);
		categoria3.setNome("LIVROS");
		categoria3.setStatus(StatusCategoria.ATIVA);

			System.out.println("Categoria " + categoria1.getNome()+ "  (" + categoria1.getId() + " - " + categoria1.getStatus() .name().toLowerCase() + ")");
			System.out.println("Categoria " + categoria2.getNome()+ "  (" + categoria2.getId() + " - " + categoria2.getStatus() .name().toLowerCase() + ")");
			System.out.println("Categoria " + categoria3.getNome()+ "  (" + categoria3.getId() + " - " + categoria3.getStatus() .name().toLowerCase()+ ")");

	}

}
