package com.example.teelab.service;

import com.example.teelab.exception.OrderException;
import com.example.teelab.exception.ProductException;
import com.example.teelab.exception.ReviewException;
import com.example.teelab.model.entity.Review;
import com.example.teelab.model.entity.User;
import com.example.teelab.request.ReviewRequest;
import com.example.teelab.request.ReviewResponse;
import com.example.teelab.response.NumberOfEachTypeOfStartByProduct;

import java.util.List;

public interface ReviewService {
    List<Review> getReviewByProductId(Long productId, int rating);

    public Review createReview(ReviewRequest req, User user) throws ProductException, OrderException, ReviewException;

    Review createResponseReview(ReviewResponse res, User user);

    List<NumberOfEachTypeOfStartByProduct> getNumberOfEachTypeOfStar(Long productId);


    List<Review> getReviewByUser(User user);

    public List<Review> getAllReview(Long productId);
}
