package com.example.teelab.service;

import com.example.teelab.exception.CartException;
import com.example.teelab.exception.ProductException;
import com.example.teelab.exception.UserException;
import com.example.teelab.model.entity.Cart;
import com.example.teelab.model.entity.CartItem;
import com.example.teelab.model.entity.User;
import com.example.teelab.request.AddItemRequest;

public interface CartService {
//    public Cart createCart(User user);

    Cart createCart(Long userId) throws UserException;

    public Cart addCartItem(User userId, AddItemRequest addItemRequest) throws ProductException, UserException, CartException;

    Cart addCart(User user, AddItemRequest[] items) throws UserException, ProductException;

    Cart demo(User user, AddItemRequest req, CartItem[] cartItems) throws UserException, ProductException;

    public Cart findCartByUserId(Long userId);


}
