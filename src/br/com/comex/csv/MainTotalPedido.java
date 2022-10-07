package br.com.comex.csv;

import java.io.FileNotFoundException;
import java.util.List;

public class MainTotalPedido {

	public static void main(String[] args) throws FileNotFoundException {

		LeitorPedidosCsv total = new LeitorPedidosCsv();
		List<PedidoCsv> pedidoCsv = total.lerPedidoCsv();

		int contador = 0;

		for (PedidoCsv linha : pedidoCsv) {
			contador++;
		}

		System.out.println("Total de pedidos: " + contador);
	}

}