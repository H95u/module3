package com.example.btvn_product.controller;

import com.example.btvn_product.model.Category;
import com.example.btvn_product.model.Product;
import com.example.btvn_product.service.CategoryService;
import com.example.btvn_product.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "/categories")
public class CategoryServlet extends HttpServlet {
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
                deleteCategory(request, response);
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
            default:
                break;
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = CategoryService.getInstance().getCategoryList();
        List<Product> productList = ProductService.getInstance().getProductListt();
        for (Category category : categoryList) {
            int i = 0;
            for (Product product : productList) {
                if (category.getName().equals(product.getCategory().getName())) {
                    ++i;
                    category.setSlsp(i);
                }
            }
        }
        request.setAttribute("category", categoryList);
        request.getRequestDispatcher("/categories/home.jsp").forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/categories/create.jsp").forward(request, response);
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Category category = new Category(id, name);
        CategoryService.getInstance().addCategory(category);
        response.sendRedirect("/categories");
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CategoryService.getInstance().deleteById(id);
        response.sendRedirect("/categories");
    }

    private void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = CategoryService.getInstance().getById(id);
        request.setAttribute("category", category);
        request.getRequestDispatcher("/categories/update.jsp").forward(request, response);
    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = CategoryService.getInstance().getById(id);
        String name = request.getParameter("name");
        category.setName(name);
        response.sendRedirect("/categories");
    }
}