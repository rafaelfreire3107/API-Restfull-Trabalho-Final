package br.com.serratec.entity;

import br.com.serratec.entity.pk.CarrinhoPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Carrinho {
	
	@EmbeddedId
	private CarrinhoPK id = new CarrinhoPK();
	
	private Double valor;
	private Double desconto;
	private Integer quantidade;
	
	public Carrinho() {
	}

	public Carrinho(Produto produto, Pedido pedido, Double valor, Double desconto, Integer quantidade) {
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.valor = valor;
		this.desconto = desconto;
		this.quantidade = quantidade;
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Pedido getPedido() {
		return id.getPedido();
	}

	public CarrinhoPK getId() {
		return id;
	}

	public void setId(CarrinhoPK id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
