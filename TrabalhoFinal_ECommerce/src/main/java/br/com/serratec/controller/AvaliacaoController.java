package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.DTO.AvaliacaoResponseDTO;
import br.com.serratec.entity.Avaliacao;
import br.com.serratec.service.AvaliacaoService;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

	@Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/produto/{produtoId}")
    public List<AvaliacaoResponseDTO> getAvaliacaoByProduto(@PathVariable Long produtoId) {
        return avaliacaoService.getAvaliacaoByProduto(produtoId);
    }
    
    @GetMapping("/all")
    public List<AvaliacaoResponseDTO> getAllAvaliacoes() {
        return avaliacaoService.getAllAvaliacoes();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avaliacao> updateReview(@PathVariable Long id, @RequestBody Avaliacao avaliacao) {
        Avaliacao updateAvaliacao = avaliacaoService.updateReview(id, avaliacao);
        return ResponseEntity.ok(updateAvaliacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
    	avaliacaoService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
