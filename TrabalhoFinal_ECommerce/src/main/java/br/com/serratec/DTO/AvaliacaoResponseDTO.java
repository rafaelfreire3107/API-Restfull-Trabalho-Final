package br.com.serratec.DTO;

public class AvaliacaoResponseDTO {
	
	private int avaliacao;
    private String comentario;
    private String nomeProduto;
    private String nomeCliente;

    public AvaliacaoResponseDTO(int avaliacao, String comentario, String nomeProduto, String nomeCliente) {
        this.avaliacao = avaliacao;
        this.comentario = comentario;
        this.nomeProduto = nomeProduto;
        this.nomeCliente = nomeCliente;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
