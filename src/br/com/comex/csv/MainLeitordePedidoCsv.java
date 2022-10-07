package br.com.comex.csv;

import java.io.FileNotFoundException;
import java.util.List;

public class MainLeitordePedidoCsv {
	public static void main (String[] args) throws FileNotFoundException {
		LeitorPedidosCsv leitorPedidosCsv = new LeitorPedidosCsv();
		List<PedidoCsv> pedidosCsv = leitorPedidosCsv.lerPedidoCsv();
		
		
		for (PedidoCsv pedido : pedidosCsv) {
			System.out.println(pedido.getProduto() + "- " + " Preço: " + pedido.getPreco() + "  Quantidade: " +
					pedido.getQuantidade() + "  Data: "+ pedido.getData() + "  Cliente: "+ pedido.getCliente());
			}
	}
	

}
