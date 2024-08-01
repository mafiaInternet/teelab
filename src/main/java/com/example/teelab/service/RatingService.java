package com.example.teelab.service;

import com.example.teelab.exception.ProductException;
import com.example.teelab.model.entity.Rating;
import com.example.teelab.model.entity.User;
import com.example.teelab.request.RatingRequest;

import java.util.List;


public interface RatingService {
    public Rating createRating(RatingRequest req, User user) throws ProductException;
    public List<Rating>getProductsRating(Long productId);
}
