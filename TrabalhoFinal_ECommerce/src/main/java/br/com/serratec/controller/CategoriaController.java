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

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public List<Categoria> listar() {
		return categoriaService.listar();
	}

	@PostMapping
	public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria) {
		Categoria novaCategoria = categoriaService.inserir(categoria);
		return ResponseEntity.ok(novaCategoria);
	}
	
	
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
