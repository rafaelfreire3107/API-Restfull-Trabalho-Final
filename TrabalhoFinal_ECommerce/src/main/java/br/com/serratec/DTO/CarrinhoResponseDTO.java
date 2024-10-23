package br.com.serratec.DTO;

import br.com.serratec.entity.Carrinho;

public class CarrinhoResponseDTO {
	
	private Double preço;
	private Double desconto;
	private Integer quantidade;
	private Double subTotal;
	
	public CarrinhoResponseDTO() {
	}

	public CarrinhoResponseDTO(Carrinho carrinho, Double subTotal) {
		this.preço = carrinho.getProduto().getValor();
		this.desconto = carrinho.getDesconto();
		this.quantidade = carrinho.getQuantidade();
		this.subTotal = subTotal;
	}

	public Double getPreço() {
		return preço;
	}

	public void setPreço(Double preço) {
		this.preço = preço;
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

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	
}
