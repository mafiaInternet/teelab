package com.example.teelab.controller;

import com.example.teelab.exception.CartException;
import com.example.teelab.exception.UserException;
import com.example.teelab.model.dao.CartDao;
import com.example.teelab.model.entity.Cart;
import com.example.teelab.model.entity.User;
import com.example.teelab.request.AddItemRequest;
import com.example.teelab.request.AddOrderItemRequest;
import com.example.teelab.response.ApiResponse;
import com.example.teelab.service.CartItemService;
import com.example.teelab.service.CartService;
import com.example.teelab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
//@Tag(name ="Cart Managemet", description="find user cart, add item to cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private CartDao cartDao;
    @GetMapping("/user")
    public ResponseEntity<Cart> findUserCart(@RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserProfileByJwt(jwt);
        Cart cart=cartService.findCartByUserId(user.getId());

        return new ResponseEntity<>(cart, HttpStatus.ACCEPTED);
    }

    @PutMapping("/add")
    public ResponseEntity<Cart>addItemToCart(@RequestBody AddItemRequest req,
                                                    @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserProfileByJwt(jwt);

        Cart cart = cartService.addCartItem(user, req);

        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }

    @PostMapping("/add/demo")
    public ResponseEntity<Cart>addItemTOrder(@RequestBody AddOrderItemRequest req,
                                                    @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserProfileByJwt(jwt);
        Cart cart = cartService.demo(user, req.getAddItemRequest(), req.getCartItems());
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }



    @DeleteMapping("/cartItem/1/delete")
    public ResponseEntity<ApiResponse> deleteCartItems(@RequestBody Long cartItemId, @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserProfileByJwt(jwt);
       cartItemService.deleteCartItems(user.getId(), cartItemId);
        ApiResponse res = new ApiResponse();
        res.setMessage("Delete item");
        res.setStatus(true);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/cartItem/delete")
    public ResponseEntity<Cart>removeItemToCart(@RequestBody Long[] cartItemIds, @RequestHeader("Authorization") String jwt) throws UserException, CartException {
        User user = userService.findUserProfileByJwt(jwt);

        Cart cart = cartItemService.removeCartItem(user.getId(), cartItemIds);

        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping("/cartItem/{cartItemId}/update")
    public ResponseEntity<Cart> updateCartItem(@PathVariable Long cartItemId, @RequestHeader("Authorization") String jwt, @RequestBody int quantity) throws Exception {
        User user =userService.findUserProfileByJwt(jwt);
        System.out.println(quantity);
        cartItemService.updateCartItem(user, cartItemId, quantity);
        Cart cart = cartService.findCartByUserId(user.getId());
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

}
