package br.com.serratec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.DTO.EnderecoResponseDTO;
import br.com.serratec.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService service;
	
	@Operation(summary = "Lista informações de um endereço pelo cep", description = "A resposta retorna CEP, "
			+ "Logradouro, Bairro, Localidade e UF")
	@GetMapping("{cep}")
	public ResponseEntity<EnderecoResponseDTO> buscarCep(@PathVariable String cep) {
		return ResponseEntity.ok(service.buscar(cep));
	}
}
