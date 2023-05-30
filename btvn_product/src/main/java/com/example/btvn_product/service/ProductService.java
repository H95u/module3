package com.example.btvn_product.service;

import com.example.btvn_product.model.Category;
import com.example.btvn_product.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final List<Product> productList;
    private static ProductService productService;

    private ProductService() {
        productList = new ArrayList<>();
    }

    public static ProductService getInstance() {
        if (productService == null) {
            productService = new ProductService();
        }
        return productService;
    }

    public List<Product> getProductListt() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Product getById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        Product product = getById(id);
        if (product != null) {
            productList.remove(product);
        }
    }

    public void deleteByCategory(Category category) {
        productList.removeIf(product -> product.getCategory() == category);
    }

    public List<Product> searchByName(String name) {
        List<Product> productSearch = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                productSearch.add(product);
            }
        }
        return productSearch;
    }
}
