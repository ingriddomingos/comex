package br.com.comex.csv;

import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class TotalCategorias {
	public static void main(String[] args) throws FileNotFoundException {

		LeitorPedidosCsv leitorPedidos = new LeitorPedidosCsv();
		List<PedidoCsv> pedidosCsv = leitorPedidos.lerPedidoCsv();
		List<String> categorias = new ArrayList<>();

		for (PedidoCsv categoria : pedidosCsv) {
			String categoriaContem = categoria.getCategoria();

			if (!categorias.contains(categoriaContem))
				categorias.add(categoriaContem);
		}

		System.out.println("Total de categorias: " + categorias.size());
	}
}
