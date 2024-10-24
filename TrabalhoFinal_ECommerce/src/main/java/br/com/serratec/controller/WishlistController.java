package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.model.WishlistItem;
import br.com.serratec.service.WishlistService;

@RestController
@RequestMapping("/api/users/{userId}/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @GetMapping
    public List<WishlistItem> getWishlistItems(@PathVariable Long userId) {
        return wishlistService.getAllWishlistItems(userId);
    }

    @PostMapping
    public WishlistItem addWishlistItem(@PathVariable Long userId, @RequestBody WishlistItem wishlistItem) {
        return wishlistService.addWishlistItem(userId, wishlistItem);
    }

    @DeleteMapping("/{id}")
    public void deleteWishlistItem(@PathVariable Long id) {
        wishlistService.deleteWishlistItem(id);
    }
}
