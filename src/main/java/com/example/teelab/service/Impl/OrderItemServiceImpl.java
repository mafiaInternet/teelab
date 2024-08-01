package com.example.teelab.service.Impl;

import com.example.teelab.model.dao.OrderItemDao;
import com.example.teelab.model.entity.CartItem;
import com.example.teelab.model.entity.OrderItem;
import com.example.teelab.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemDao orderItemDao;


    @Override
    public OrderItem createOrderItem(CartItem cartItem) {
        OrderItem orderItem = new OrderItem();
        orderItem.setPrice(cartItem.getPrice());
        orderItem.setQuantity(cartItem.getQuantity());
        orderItem.setSize(cartItem.getSize());
        orderItem.setColor(cartItem.getColor());
        orderItem.setImageUrl(cartItem.getImageUrl());
        orderItem.setDiscountedPrice(cartItem.getDiscountedPrice());
        orderItem.setProduct(cartItem.getProduct());
        return orderItemDao.save(orderItem);
    }




}
