package com.example.teelab.request;

import com.example.teelab.model.entity.Address;
import com.example.teelab.model.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
    private Address address;
    private Cart cart;
    private String paymentMethod;
    private int discountedPrice;


}
