package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.DTO.ProdutoRequestDTO;
import br.com.serratec.DTO.ProdutoResponseDTO;
import br.com.serratec.service.ProdutoService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listar() {
        List<ProdutoResponseDTO> produtos = produtoService.listar();
        return ResponseEntity.ok(produtos);
    }
	
	@PostMapping
	public ResponseEntity<ProdutoResponseDTO> inserir(@RequestBody ProdutoRequestDTO dtos) {
		ProdutoResponseDTO dto = produtoService.inserir(dtos);
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<ProdutoResponseDTO> alterar(@PathVariable Long id, @RequestBody ProdutoRequestDTO dtos) {
		 ProdutoResponseDTO dto = produtoService.alterar(id, dtos);
         return ResponseEntity.ok(dto);
	}
	
}
