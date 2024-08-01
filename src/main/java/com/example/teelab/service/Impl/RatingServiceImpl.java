package com.example.teelab.service.Impl;

import com.example.teelab.exception.ProductException;
import com.example.teelab.model.dao.RatingDao;
import com.example.teelab.model.entity.Product;
import com.example.teelab.model.entity.Rating;
import com.example.teelab.model.entity.User;
import com.example.teelab.request.RatingRequest;
import com.example.teelab.service.ProductService;
import com.example.teelab.service.RatingService;
import com.example.teelab.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class RatingServiceImpl implements RatingService {
    private UserService userService;
    private ProductService productService;
    private RatingDao ratingDao;
    public RatingServiceImpl(ProductService productService, RatingDao ratingDao){
        this.productService = productService;
        this.ratingDao = ratingDao;
    }
    @Override
    public Rating createRating(RatingRequest req, User user) throws ProductException {
        Product product=productService.findProductById(req.getProductId());

        Rating rating= new Rating();
        rating.setProduct(product);
        rating.setUser(user);
        rating.setRating(req.getRating());
        rating.setCreateAt(LocalDateTime.now());

        return ratingDao.save(rating);
    }

    @Override
    public List<Rating> getProductsRating(Long productId) {
        return ratingDao.getAllProductsRating(productId);
    }
}
