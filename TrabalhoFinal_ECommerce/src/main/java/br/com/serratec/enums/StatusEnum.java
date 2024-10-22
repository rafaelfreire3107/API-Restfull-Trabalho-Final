package br.com.serratec.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.serratec.exception.EnumException;


public enum StatusEnum {
EM_PROCESSAMENTO(1,"Em processamento"), CONFIRMADO(2,"Confirmado"), ENVIADO(3,"Enviado"), EM_ROTA(4,"Em rota"), ENTREGUE(5,"Entregue");
	
	private Integer codigo;
	private String tipo;
	
	private StatusEnum(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
