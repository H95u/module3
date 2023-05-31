package com.example.product_web.controller;

import com.example.product_web.DAO.CartDAO;
import com.example.product_web.DAO.ProductDAO;
import com.example.product_web.model.Cart;
import com.example.product_web.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends HttpServlet {
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
                deleteCart(request, response);
                break;
            case "add":
                addToCart(request, response);
                break;
            case "updateQuantity":
                updateQuantity(request, response);
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
        request.setAttribute("cart", CartDAO.getInstance().findAll());
        request.setAttribute("total", CartDAO.getInstance().getTotalPrice());
        request.getRequestDispatcher("/cart/cart.jsp").forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/category/create.jsp").forward(request, response);
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/cart");
    }

    private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int productId = Integer.parseInt((request.getParameter("productId")));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        CartDAO.getInstance().deleteById(id);
        ProductDAO.getInstance().updateQuantityIncrease(quantity, productId);
        response.sendRedirect("/cart");
    }

    private void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/cart");
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Product product = ProductDAO.getInstance().findById(id);
        Cart cart = new Cart(product, quantity);
        boolean check = true;
        int cartId = -1;
        for (Cart c : CartDAO.getInstance().findAll()) {
            if (c.getProduct().getId() == product.getId()) {
                check = false;
                cartId = c.getId();
                break;
            }
        }
        if (check) {
            CartDAO.getInstance().addCart(cart);
        } else {
            CartDAO.getInstance().updateCartQuantity(cartId, quantity);
        }
        ProductDAO.getInstance().updateQuantityDecrease(quantity, id);
        response.sendRedirect("/cart");
    }

    private void updateQuantity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        if (quantity == 0) {
            response.sendRedirect("/cart");
        } else if (quantity > 0) {
            CartDAO.getInstance().updateCartQuantity(id, quantity);
            ProductDAO.getInstance().updateQuantityDecrease(CartDAO.getInstance().findById(id).getProduct().getId(),quantity);
            response.sendRedirect("/cart");
        } else {
            CartDAO.getInstance().updateCartQuantity(id, quantity);
            ProductDAO.getInstance().updateQuantityDecrease(CartDAO.getInstance().findById(id).getProduct().getId(), quantity);
            response.sendRedirect("/cart");
        }
    }
}