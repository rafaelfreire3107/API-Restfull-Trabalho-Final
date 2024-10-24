package br.com.serratec.DTO;

import br.com.serratec.entity.Carrinho;

public class CarrinhoRequestDTO {
	
	private Integer quantidade;
	private Long idPedido;
	private Long idProduto;
	private Double valorVenda;

	public CarrinhoRequestDTO() {
	}

	public CarrinhoRequestDTO(Carrinho carrinho) {
		this.quantidade = carrinho.getQuantidade();
		this.idPedido = carrinho.getPedido().getId();
		this.idProduto = carrinho.getProduto().getId();
	}
	

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
