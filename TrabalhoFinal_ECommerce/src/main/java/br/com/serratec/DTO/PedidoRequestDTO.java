package br.com.serratec.DTO;

import br.com.serratec.entity.Pedido;
import br.com.serratec.enums.StatusEnum;

public class PedidoRequestDTO {
	
	private Double totalPedido;
	private StatusEnum statusPedido;
	private Long idCliente;

	public PedidoRequestDTO() {
	}

	public PedidoRequestDTO(Pedido pedido) {
		this.statusPedido = pedido.getStatus();
		this.totalPedido = pedido.getValorTotal();
		this.idCliente = pedido.getCliente().getId();
	}

	public Double getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(Double totalPedido) {
		this.totalPedido = totalPedido;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public StatusEnum getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusEnum statusPedido) {
		this.statusPedido = statusPedido;
	}

}
