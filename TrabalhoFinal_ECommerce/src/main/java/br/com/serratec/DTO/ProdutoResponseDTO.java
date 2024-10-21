package br.com.serratec.DTO;

import br.com.serratec.entity.Produto;

public class ProdutoResponseDTO {
	
	private String nomeProduto;
	private Double valorProduto;
	private Long qtdEstoque;
	private Long idCategoria;
	
	public ProdutoResponseDTO() {
	}

	public ProdutoResponseDTO(Produto produto) {
		this.nomeProduto = produto.getNome();
		this.valorProduto = produto.getValor();
		this.qtdEstoque = produto.getQuantidadeEstoque();
		this.idCategoria = produto.getCategoria().getId();
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Long getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Long qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	
}
