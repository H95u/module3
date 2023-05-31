package com.example.product_web.service;

import com.example.product_web.DAO.CategoryDAO;
import com.example.product_web.DAO.ProductDAO;
import com.example.product_web.model.Category;
import com.example.product_web.model.Product;

import javax.servlet.http.HttpServletRequest;

public class ProductService {
    private static ProductService productService;

    public static ProductService getInstance() {
        if (productService == null) {
            productService = new ProductService();
        }
        return productService;
    }

    public void save(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Category category = CategoryService.getInstance().getById(categoryId);
        if (id != null) {
            int idUpdate = Integer.parseInt(id);
            ProductDAO.getInstance().updateProduct(new Product(idUpdate, name, price, quantity, category));
        } else {
            ProductDAO.getInstance().addProduct(new Product(name, price, quantity, category));
        }
    }
}
