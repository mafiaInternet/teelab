package com.example.teelab.service;

import com.example.teelab.exception.CartException;
import com.example.teelab.exception.UserException;
import com.example.teelab.model.entity.Cart;
import com.example.teelab.model.entity.CartItem;
import com.example.teelab.model.entity.Product;
import com.example.teelab.model.entity.User;

public interface CartItemService {
    public CartItem createCartItem(CartItem cartItem);
//    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartException, UserException;

    public CartItem updateCartItem(User user, Long id, int quantity) throws CartException, UserException;

    public CartItem isCartItemExist(Cart cart, Product product, String color, String size, Long userId);
    public Cart removeCartItem(Long userId, Long[] cartItemIds) throws CartException, UserException;

    public void deleteCartItems(Long userId, Long cartItemId) throws CartException, UserException;

    public CartItem findCartItemById(Long cartItemId) throws CartException;

}
