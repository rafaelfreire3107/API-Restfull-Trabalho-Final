package br.com.serratec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.model.WishlistItem;

@Repository
public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {
    List<WishlistItem> findByUserProfileId(Long userId);
}
