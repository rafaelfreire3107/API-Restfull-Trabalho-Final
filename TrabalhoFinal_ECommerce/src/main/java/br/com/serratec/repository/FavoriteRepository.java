package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.Favorite;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByClienteId(Long clienteId);
    Optional<Favorite> findByClienteIdAndProdutoId(Long clienteId, Long produtoId);
}

