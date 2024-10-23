package br.com.serratec.DTO;

import br.com.serratec.entity.Pedido;
import br.com.serratec.enums.StatusEnum;

public class PedidoResponseDTO {

	private Double valorTotal;
	private StatusEnum statusPedido;
	private String nomeCliente;

	public PedidoResponseDTO(Pedido pedido) {
		this.statusPedido = pedido.getStatus();
		this.nomeCliente = pedido.getCliente().getNome();
		this.valorTotal = pedido.getValorTotal();
	}


	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public StatusEnum getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusEnum statusPedido) {
		this.statusPedido = statusPedido;
	}

}
