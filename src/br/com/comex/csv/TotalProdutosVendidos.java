package br.com.comex.csv;

import java.io.IOException;
import java.util.List;

public class TotalProdutosVendidos {
	
	public static void main(String[] args) throws IOException {
		
		LeitorPedidosCsv leitor = new LeitorPedidosCsv();
		List<PedidoCsv> pedidosCsv = leitor.lerPedidoCsv();
		
		int totalProdutos = 0;
		
		for (PedidoCsv produto : pedidosCsv) {
			int parseInt = Integer.parseInt(produto.getQuantidade());
			totalProdutos = totalProdutos + parseInt ;
		}
		
		System.out.println("Total de produtos vendidos: " + totalProdutos);

	}
}