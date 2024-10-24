package br.com.serratec.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.model.WishlistItem;
import br.com.serratec.repository.WishlistItemRepository;

@Service
public class WishlistService {

    @Autowired
    private WishlistItemRepository wishlistItemRepository;

    public List<WishlistItem> getAllWishlistItems(Long userId) {
        return wishlistItemRepository.findByUserProfileId(userId);
    }

    public WishlistItem addWishlistItem(Long userId, WishlistItem wishlistItem) {
        wishlistItem.setUserProfile(new br.com.serratec.model.UserProfile());
        wishlistItem.getUserProfile().setId(userId);
        return wishlistItemRepository.save(wishlistItem);
    }

    public void deleteWishlistItem(Long id) {
        wishlistItemRepository.deleteById(id);
    }
}
