package com.example.teelab.service.Impl;

import com.example.teelab.model.dao.CategoryDao;
import com.example.teelab.model.entity.Category;
import com.example.teelab.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public Category findByName(String name){
        for (Category category: categoryDao.findAll()){
            if(category.getName().equals(name)){
                return category;
            }
        }
        return null;
    }

    @Override
    public void createCategory(){
        String[] id = {"ao-thun", "bady-tee", "ao-polo", "ao-so-mi", "ao-khoac", "hoodie", "quan", "quan-nu", "phu-kien"};
        String[] name = {"Áo thun", "Baby Tee", "Áo Polo", "Áo sơ mi", "Áo khoác", "Hoodie", "Quần", "Quần nữ", "Phụ kiện"};
        for(int i= 0; i<9; i++){
            Category category = new Category(i, id[i], name[i]);
            categoryDao.save(category);
        }
    }


}
