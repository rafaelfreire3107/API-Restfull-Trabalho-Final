package br.com.serratec.DTO;

import br.com.serratec.entity.Cliente;

public class ClienteRequestDTO {
	
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String cep;
	
	public ClienteRequestDTO() {
	}

	public ClienteRequestDTO(Cliente cliente) {
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.email = cliente.getEmail();
		this.telefone = cliente.getTelefone();
		this.cep = cliente.getEndereco().getCep();
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	
	
}
