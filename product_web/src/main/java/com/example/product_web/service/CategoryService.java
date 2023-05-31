package com.example.product_web.service;

import com.example.product_web.DAO.CategoryDAO;
import com.example.product_web.model.Category;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CategoryService {
    private static CategoryService categoryService;
    public static CategoryService getInstance(){
        if (categoryService == null){
            categoryService = new CategoryService();
        }
        return categoryService;
    }
    public List<Category> findAll() {
        return CategoryDAO.getInstance().findAll();
    }

    public Category getById(int id) {
        return CategoryDAO.getInstance().findById(id);
    }

    public void save(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        if (id != null) {
            int idUpdate = Integer.parseInt(id);
            CategoryDAO.getInstance().updateCategory(new Category(idUpdate, name));
        } else {
            CategoryDAO.getInstance().addCategory(new Category(name));
        }
    }

    public void deleteById(int id) {
        CategoryDAO.getInstance().deleteById(id);
    }
}
