package br.com.comex.csv;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class MontanteTotalVendas {

	public static void main(String[] args) throws IOException {

		LeitorPedidosCsv leitor = new LeitorPedidosCsv();
		List<PedidoCsv> pedidosCsv = leitor.lerPedidoCsv();
		Locale localBrasil = new Locale("pt", "BR");

		double soma = 0.0;

		for (PedidoCsv produto : pedidosCsv) {
			String vendas = produto.getPreco();
			String quantidades = produto.getQuantidade();

			double pVendas = Double.parseDouble(vendas);
			double pQuantidades = Double.parseDouble(quantidades);

			soma = soma + pVendas * pQuantidades;
		}

		System.out.println("Montante de vendas: " + NumberFormat.getCurrencyInstance(localBrasil).format(soma));

	}
}