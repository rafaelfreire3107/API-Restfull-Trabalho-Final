package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.DTO.ProdutoRequestDTO;
import br.com.serratec.DTO.ProdutoResponseDTO;
import br.com.serratec.entity.Produto;
import br.com.serratec.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Operation(summary = "Lista os produtos inseridos", description = "A resposta retorna nome do produto, valor, quantidade em estoque e"
			+ " nome da categoria")
	@GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listar() {
        List<ProdutoResponseDTO> produtos = produtoService.listar();
        return ResponseEntity.ok(produtos);
    }
	
	@Operation(summary = "Insere um novo produto", description = "A resposta retorna nome do produto, valor, quantidade em estoque e"
			+ " nome da categoria")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "201", 
			content = {@Content(schema = @Schema(implementation = Produto.class), mediaType = "application/json")},
			description = "Produto cadastrado com sucesso"),
			@ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") })
	@PostMapping
	public ResponseEntity<ProdutoResponseDTO> inserir(@RequestBody ProdutoRequestDTO dtos) {
		ProdutoResponseDTO dto = produtoService.inserir(dtos);
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}

	@Operation(summary = "Atualiza um produto existente", description = "A resposta retorna nome do produto, valor, quantidade em estoque e"
			+ " nome da categoria")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "201", 
			content = {@Content(schema = @Schema(implementation = Produto.class), mediaType = "application/json")},
			description = "Produto atualizado com sucesso"),
			@ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") })
	@PutMapping("{id}")
	public ResponseEntity<ProdutoResponseDTO> alterar(@PathVariable Long id, @RequestBody ProdutoRequestDTO dtos) {
		 ProdutoResponseDTO dto = produtoService.alterar(id, dtos);
         return ResponseEntity.ok(dto);
	}
	 
	
	
}
