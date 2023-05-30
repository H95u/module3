package com.example.btvn_product.controller;

import com.example.btvn_product.model.Category;
import com.example.btvn_product.model.Product;
import com.example.btvn_product.service.CategoryService;
import com.example.btvn_product.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createGet(request, response);
                break;
            case "update":
                updateGet(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createPost(request, response);
                break;
            case "update":
                updatePost(request, response);
                break;
            case "search":
                searchByName(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", ProductService.getInstance().getProductListt());
        request.getRequestDispatcher("/product/home.jsp").forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("category", CategoryService.getInstance().getCategoryList());
        request.getRequestDispatcher("/product/create.jsp").forward(request, response);
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String timeString = request.getParameter("time");
        LocalDateTime time = LocalDateTime.parse(timeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int categoryID = Integer.parseInt(request.getParameter("categoryId"));
        Category category = CategoryService.getInstance().getById(categoryID);
        Product product = new Product(id, name, price, time, category);
        ProductService.getInstance().addProduct(product);
        response.sendRedirect("/products");
    }

    private void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = ProductService.getInstance().getById(id);
        request.setAttribute("product", product);
        request.setAttribute("category", CategoryService.getInstance().getCategoryList());
        request.getRequestDispatcher("/product/update.jsp").forward(request, response);
    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = ProductService.getInstance().getById(id);
        String timeString = request.getParameter("time");
        LocalDateTime time = LocalDateTime.parse(timeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int categoryID = Integer.parseInt(request.getParameter("categoryId"));
        Category category = CategoryService.getInstance().getById(categoryID);
        product.setExpireTime(time);
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        response.sendRedirect("/products");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductService.getInstance().deleteById(id);
        response.sendRedirect("/products");
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Product> products = ProductService.getInstance().searchByName(search);
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/home.jsp");
        requestDispatcher.forward(request, response);
    }
}