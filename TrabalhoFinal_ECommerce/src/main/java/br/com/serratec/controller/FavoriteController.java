package br.com.serratec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.serratec.entity.Favorite;
import br.com.serratec.service.FavoriteService;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/{clienteId}/produtos/{produtoId}")
    public ResponseEntity<Favorite> addFavorite(@PathVariable Long clienteId, @PathVariable Long produtoId) {
        Favorite favorite = favoriteService.addFavorite(clienteId, produtoId);
        return ResponseEntity.ok(favorite);
    }

    @DeleteMapping("/{clienteId}/produtos/{produtoId}")
    public ResponseEntity<Void> removeFavorite(@PathVariable Long clienteId, @PathVariable Long produtoId) {
        favoriteService.removeFavorite(clienteId, produtoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<List<Favorite>> getFavorites(@PathVariable Long clienteId) {
        List<Favorite> favorites = favoriteService.getFavorites(clienteId);
        return ResponseEntity.ok(favorites);
    }
}
