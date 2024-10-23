package br.com.serratec.entity;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Schema(description = "Identificador único do cliente")
	private Long id;
	
	@NotBlank(message = "Preencha o campo corretamente")
	@Column(nullable = false, length = 60)
	private String nome;
	
	@CPF(message = "CPF inválido")
	@NotBlank(message = "Preencha o campo corretamente")
	private String cpf;
	
	@Email(message = "E-mail inválido") 
	@NotBlank(message = "Preencha o campo corretamente")
	private String email;
	
    @Pattern(regexp = "^\\(\\d{2}\\) 9\\d{4}-\\d{4}$", 
    		message = "Preencha o campo de telefone corretamente, exemplo:(XX) 9XXXX-XXXX")
    @Column(nullable = false)
	private String telefone;
    
    @ManyToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
    
    public String toString() {
		return "Id: " + id + "\n" + "Nome: " + nome + "\n" + "E-mail: " + email + "\n" + "Telefone: " + telefone + "\n" + "CEP: " + getEndereco().getCep();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
