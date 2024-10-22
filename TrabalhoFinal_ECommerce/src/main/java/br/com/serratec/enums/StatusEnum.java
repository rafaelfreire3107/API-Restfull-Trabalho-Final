package br.com.serratec.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.serratec.exception.EnumException;


public enum StatusEnum {
	EM_PROCESSAMENTO(1,"Em processamento"), 
	CONFIRMADO(2,"Confirmado"), 
	ENVIADO(3,"Enviado"), 
	EM_ROTA(4,"Em rota"), 
	ENTREGUE(5,"Entregue");
	
	private Integer codigo;
	private String status;
	
	private StatusEnum(Integer codigo, String status) {
		this.codigo = codigo;
		this.status = status;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getstatus() {
		return status;
	}

	public void setstatus(String status) {
		this.status = status;
	}

	@JsonCreator
	public static StatusEnum verificar(Integer valor) {
		for (StatusEnum c : StatusEnum.values()) {
			if(c.getCodigo().equals(valor)) {
				return c;
			}
		}
		throw new EnumException("Status inválido");
	}
}
