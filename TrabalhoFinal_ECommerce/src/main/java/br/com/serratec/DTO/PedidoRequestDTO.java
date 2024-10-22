package br.com.serratec.DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import br.com.serratec.entity.Carrinho;
import br.com.serratec.entity.Pedido;
import br.com.serratec.enums.StatusEnum;

public class PedidoRequestDTO {

	private Double valorTotal;
	private LocalDate dataPedido;
	private LocalTime horaPedido;
	private StatusEnum statusPedido;

	private Set<Carrinho> carrinho = new HashSet<>();

	public PedidoRequestDTO() {
	}

	public PedidoRequestDTO(Pedido pedido) {
		this.valorTotal = pedido.getValorTotal();
		this.dataPedido = pedido.getData();
		this.horaPedido = pedido.getHora();
		this.statusPedido = pedido.getStatus();
	}

	public Set<Carrinho> getCarrinho() {
		return carrinho;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalTime getHoraPedido() {
		return horaPedido;
	}

	public void setHoraPedido(LocalTime horaPedido) {
		this.horaPedido = horaPedido;
	}

	public StatusEnum getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusEnum statusPedido) {
		this.statusPedido = statusPedido;
	}

}
