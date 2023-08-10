package org.bookstore.repository;

import org.bookstore.entities.CartItem;
import org.bookstore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

    public interface CartItemRepository extends JpaRepository<CartItem, Long> {
        List<CartItem> findByUser(User user);
    }
