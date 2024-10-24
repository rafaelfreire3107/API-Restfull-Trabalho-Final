package br.com.serratec.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Cliente;
import br.com.serratec.entity.Favorite;
import br.com.serratec.entity.Produto;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.repository.ClienteRepository;
import br.com.serratec.repository.FavoriteRepository;
import br.com.serratec.repository.ProdutoRepository;

import java.util.List;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Favorite addFavorite(Long clienteId, Long produtoId) {
        Cliente cliente = clienteRepository.findById(clienteId)
            .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        Produto produto = produtoRepository.findById(produtoId)
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        if (favoriteRepository.findByClienteIdAndProdutoId(clienteId, produtoId).isPresent()) {
            throw new RuntimeException("Produto já está nos favoritos");
        }

        Favorite favorite = new Favorite();
        favorite.setCliente(cliente);
        favorite.setProduto(produto);

        return favoriteRepository.save(favorite);
    }

    public void removeFavorite(Long clienteId, Long produtoId) {
        Favorite favorite = favoriteRepository.findByClienteIdAndProdutoId(clienteId, produtoId)
            .orElseThrow(() -> new ResourceNotFoundException("Favorito não encontrado"));
        favoriteRepository.delete(favorite);
    }

    public List<Favorite> getFavorites(Long clienteId) {
        return favoriteRepository.findByClienteId(clienteId);
    }
}

