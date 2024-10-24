package br.com.serratec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.DTO.CarrinhoRequestDTO;
import br.com.serratec.DTO.CarrinhoResponseDTO;
import br.com.serratec.entity.Carrinho;
import br.com.serratec.entity.Produto;
import br.com.serratec.repository.CarrinhoRepository;
import br.com.serratec.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;

	@Service
	public class CarrinhoService {

	    @Autowired
	    private CarrinhoRepository carrinhoRepository;
	    
	    @Autowired
	    private ProdutoRepository produtoRepository;
	    
//	    public CarrinhoResponseDTO inserir(CarrinhoRequestDTO dto) {
//	    	Optional<Produto> produtos = produtoRepository.findById(dto.getIdProduto());
//			Carrinho carrinhos = new Carrinho();
//	    	if (produtos.isPresent()) {
//				carrinhos.setProduto(produtos.get());
//			}
//			else {
//				throw new EntityNotFoundException("Produto não existente");
//			}
//	    	
//	    	
//	    }
	
}
