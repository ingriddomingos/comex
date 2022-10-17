package br.com.comex.modelos;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;



	public class ItemPedido {

		private static final AtomicInteger count = new AtomicInteger(0);
		private int id;
		private double precoUnitario;
		private int quantidade;
		private Produto produtoItemPedido;
		private Pedido pedido;
		private double desconto;
		private int tipoDesconto = 0;


		Locale localeBR = new Locale("pt", "BR");
		NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);

		public ItemPedido(double precoUnitario, int quantidade, Produto produtoItemPedido, Pedido pedido, double desconto,
				int tipoDesconto) {

			this.id = count.incrementAndGet();
			this.precoUnitario = precoUnitario;
			this.quantidade = quantidade;
			this.produtoItemPedido = produtoItemPedido;
			this.pedido = pedido;
			this.desconto = desconto;
			this.tipoDesconto = tipoDesconto;

		}


		public ItemPedido(Integer id) {

			this.id = id;
		}

		public ItemPedido() {

		}



		public int getId() {
			return id;
		


		}

		public double getPrecoUnitario() {
			return precoUnitario;
		}

		public int getQuantidade() {
			return quantidade;
		}

		public Produto getProduto() {
			return produtoItemPedido;
		}

		public Pedido getPedido() {
			return this.pedido;
		}

		public double getDesconto() {
			return this.desconto;
		}

		public int getTipoDesconto() {
			return this.tipoDesconto;
		}

		public double SemDesconto() {
			return this.precoUnitario * this.quantidade;
		}

		
		public void setId(int id) {
			this.id = id;
		}

		public void setPrecoUnitario(double precoUnitario) {
			this.precoUnitario = precoUnitario;
		}

		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}

		public void setProdutoItemPedido(Produto produtoItemPedido) {
			this.produtoItemPedido = produtoItemPedido;
		}

		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}

		public void setDesconto(double desconto) {
			this.desconto = desconto;
		}

		public void setTipoDesconto(int tipoDesconto) {
			this.tipoDesconto = tipoDesconto;
		}



		public void setLocaleBR(Locale localeBR) {
			this.localeBR = localeBR;
		}

		public void setDinheiro(NumberFormat dinheiro) {
			this.dinheiro = dinheiro;
		}

	}
