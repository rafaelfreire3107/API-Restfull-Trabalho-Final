package br.com.serratec.DTO;

import br.com.serratec.entity.Cliente;

public class ClienteResponseDTO {
	
	private Long id;
	private String nome;
	private String email;
	private String numeroCep;
	

	public ClienteResponseDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.numeroCep = cliente.getEndereco().getCep();
	}
	
	public String getNumeroCep() {
		return numeroCep;
	}
	
	public void setNumeroCep(String numeroCep) {
		this.numeroCep = numeroCep;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}
