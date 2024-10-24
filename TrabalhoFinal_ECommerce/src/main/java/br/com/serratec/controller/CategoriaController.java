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

import br.com.serratec.entity.Categoria;
import br.com.serratec.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@Operation(summary = "Lista as categorias", description = "A resposta retorna o nome da categoria")
	@GetMapping
	public List<Categoria> listar() {
		return categoriaService.listar();
	}

	@Operation(summary = "Insere uma nova categoria", description = "A resposta retorna nome da categoria")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "201", 
			content = {@Content(schema = @Schema(implementation = Categoria.class), mediaType = "application/json")},
			description = "Categoria cadastrada com sucesso"),
			@ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") })
	@PostMapping
	public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria) {
		Categoria novaCategoria = categoriaService.inserir(categoria);
		return ResponseEntity.ok(novaCategoria);
	}
	
	@Operation(summary = "Atualiza uma categoria existente", description = "A resposta retorna nome da categoria")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "201", 
			content = {@Content(schema = @Schema(implementation = Categoria.class), mediaType = "application/json")},
			description = "Atualização de cadastro com sucesso"),
			@ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") })
	 @PutMapping("{id}")
	    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
	        Categoria categorias = categoriaService.atualizar(id, categoria);
	        if (categoria != null) {
	            return ResponseEntity.ok(categorias);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
