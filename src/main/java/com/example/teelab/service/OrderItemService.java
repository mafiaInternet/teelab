package com.example.teelab.service;

import com.example.teelab.model.entity.CartItem;
import com.example.teelab.model.entity.OrderItem;

public interface OrderItemService {

    OrderItem createOrderItem(CartItem cartItem);

//    @Query("SELECT o, a FROM Order o, Address a WHERE o.id = :orderId AND (o.address = :addressId AND a.id = :addressId)")
//    public List<Object[]> getOrder(@Param("addressId") long addressId, @Param("orderId") long orderId);
}
