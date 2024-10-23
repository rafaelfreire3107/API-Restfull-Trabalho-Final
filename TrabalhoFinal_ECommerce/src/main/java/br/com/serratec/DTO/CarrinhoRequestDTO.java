package br.com.serratec.DTO;

import br.com.serratec.entity.Carrinho;

public class CarrinhoRequestDTO {

	private Double preço;
	private Integer quantidade;
	private Long idPedido;

	public CarrinhoRequestDTO() {
	}

	public CarrinhoRequestDTO(Carrinho carrinho) {
		this.preço = carrinho.getProduto().getValor();
		this.quantidade = carrinho.getQuantidade();
		this.idPedido = carrinho.getPedido().getId();
	}
	

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Double getPreço() {
		return preço;
	}

	public void setPreço(Double preço) {
		this.preço = preço;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
