package br.com.serratec.DTO;

import br.com.serratec.entity.Produto;

public class ProdutoResponseDTO {
	
	private Long idProduto;
	private String nomeProduto;
	private Double valorProduto;
	private Long qtdEstoque;
	private String nomeCategoria;
	
	public ProdutoResponseDTO() {
	}

	public ProdutoResponseDTO(Produto produto) {
		this.idProduto = produto.getId();		
		this.nomeProduto = produto.getNome();
		this.valorProduto = produto.getValor();
		this.qtdEstoque = produto.getQuantidadeEstoque();
		this.nomeCategoria = produto.getCategoria().getNome();
	}

	
	
	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
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

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	
	
}
