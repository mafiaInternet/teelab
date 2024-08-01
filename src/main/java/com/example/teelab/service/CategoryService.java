package com.example.teelab.service;

import com.example.teelab.model.entity.Category;

public interface CategoryService {
    Category findByName(String name);

    void createCategory();
}
