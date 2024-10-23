package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.DTO.ClienteRequestDTO;
import br.com.serratec.DTO.ClienteResponseDTO;
import br.com.serratec.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<ClienteResponseDTO>> listar() {
		return ResponseEntity.ok(clienteService.listar());
	}

	@PostMapping
	public ResponseEntity<Object> inserir(@RequestBody ClienteRequestDTO dto) {
		ClienteResponseDTO dtoResponse = clienteService.inserir(dto);
		return ResponseEntity.created(null).body(dtoResponse);
	}

	@PutMapping("{id}")
	public ResponseEntity<ClienteResponseDTO> atualizarCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO dto) {
		ClienteResponseDTO dtos = clienteService.alterar(id, dto);
		return ResponseEntity.ok(dtos);

	}
}
