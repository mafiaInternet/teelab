package com.example.teelab.model.dao;

import com.example.teelab.model.entity.Cart;
import com.example.teelab.model.entity.CartItem;
import com.example.teelab.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemDao extends JpaRepository<CartItem, Long> {
    @Query("SELECT ci FROM CartItem ci WHERE ci.cart =:cart AND ci.product =:product AND ci.size=:size AND ci.userId=:userId AND ci.color = :color")
    public CartItem isCartItemExist(@Param("cart") Cart cart, @Param("product")Product product,@Param("color") String color, @Param("size")String size,
                                    @Param("userId")Long userId);

}
