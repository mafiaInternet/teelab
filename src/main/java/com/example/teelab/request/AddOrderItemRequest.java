package com.example.teelab.request;

import com.example.teelab.model.entity.CartItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddOrderItemRequest {
    private AddItemRequest addItemRequest;
    private CartItem[] cartItems;
}
