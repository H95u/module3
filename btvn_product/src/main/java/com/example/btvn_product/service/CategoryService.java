package com.example.btvn_product.service;

import com.example.btvn_product.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private final List<Category> categoryList;
    private static CategoryService categoryService;

    private CategoryService() {
        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Drink"));
        categoryList.add(new Category(2, "Snack"));
        categoryList.add(new Category(3, "Phone"));
    }

    public static CategoryService getInstance() {
        if (categoryService == null) {
            categoryService = new CategoryService();
        }
        return categoryService;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void addCategory(Category category) {
        categoryList.add(category);
    }

    public Category getById(int id) {
        for (Category category : categoryList) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        Category classes = getById(id);
        if (classes != null) {
            categoryList.remove(classes);
        }
    }
}
