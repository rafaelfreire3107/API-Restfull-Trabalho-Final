package br.com.serratec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.DTO.AvaliacaoResponseDTO;
import br.com.serratec.entity.Avaliacao;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {
	    
	 @Autowired
	    private AvaliacaoRepository avaliacaoRepository;

	    public List<AvaliacaoResponseDTO> getAvaliacaoByProduto(Long produtoId) {
	        List<Avaliacao> avaliacoes = avaliacaoRepository.findByProdutoId(produtoId);
	        return avaliacoes.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    public List<AvaliacaoResponseDTO> getAllAvaliacoes() {
	        List<Avaliacao> avaliacoes = avaliacaoRepository.findAll();
	        return avaliacoes.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    private AvaliacaoResponseDTO convertToDTO(Avaliacao avaliacao) {
	        return new AvaliacaoResponseDTO(
	                avaliacao.getAvaliacao(),
	                avaliacao.getComentario(),
	                avaliacao.getProduto().getNome(),  // Assumindo que Produto tenha um atributo 'nome'
	                avaliacao.getCliente().getNome()   // Assumindo que Cliente tenha um atributo 'nome'
	        );
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


