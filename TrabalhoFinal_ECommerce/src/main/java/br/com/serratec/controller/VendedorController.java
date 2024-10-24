package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Vendedor;
import br.com.serratec.service.VendedorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;
	
	 @GetMapping
	    public List<Vendedor> listar() {
	        return vendedorService.listar();
	    }

	@GetMapping("{id}")
	public ResponseEntity<Vendedor> obterVendedorPorId(@PathVariable Long id) {
		Vendedor vendedor = vendedorService.listarPorId(id);
		return ResponseEntity.ok(vendedor);
	}

	@PostMapping
	public ResponseEntity<Vendedor> inserir(@Valid @RequestBody Vendedor vendedor) {
		Vendedor novoVendedor = vendedorService.inserirVendedor(vendedor);
		return ResponseEntity.ok(novoVendedor);
	}
	
	 @PutMapping("{id}")
	    public ResponseEntity<Vendedor> alterar(@PathVariable Long id, @RequestBody Vendedor vendedor) {
	        Vendedor vendedores = vendedorService.alterar(id, vendedor);
	        return ResponseEntity.ok(vendedores);
	    }
	 
	 @DeleteMapping("{id}")
	    public ResponseEntity<Void> deletar(@PathVariable Long id) {
	        vendedorService.deletar(id);
	        return ResponseEntity.noContent().build();
	    }
}