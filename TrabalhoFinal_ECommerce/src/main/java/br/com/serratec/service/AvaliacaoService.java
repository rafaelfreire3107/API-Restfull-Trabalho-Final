package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Avaliacao;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {
	    
	    @Autowired
	    private AvaliacaoRepository avaliacaoRepository;

	    public List<Avaliacao> getAvaliacaoByProduto(Long produtoId) {
	        return avaliacaoRepository.findByProdutoId(produtoId);
	    }
	    
	    public List<Avaliacao> getAllAvaliacoes() {
	        return avaliacaoRepository.findAll();
	    }

	    public Avaliacao addReview(Avaliacao avaliacao) {
	        return avaliacaoRepository.save(avaliacao);
	    }

	    public void deleteReview(Long avaliacaoId) {
	    	avaliacaoRepository.deleteById(avaliacaoId);
	    }

	    public Avaliacao updateReview(Long id, Avaliacao atualizacaoAvaliacao) {
	    	Avaliacao existenteAvaliacao = avaliacaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Avaliacao nao encontrada"));
	    	existenteAvaliacao.setAvaliacao(atualizacaoAvaliacao.getAvaliacao());
	    	existenteAvaliacao.setComentario(atualizacaoAvaliacao.getComentario());
	        return avaliacaoRepository.save(existenteAvaliacao);
	    }
}


