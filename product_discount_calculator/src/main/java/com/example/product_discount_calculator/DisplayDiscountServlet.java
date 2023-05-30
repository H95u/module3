package com.example.product_discount_calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DisplayDiscountServlet", value = "/display-discount")
public class DisplayDiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("description");
        double inputPrice = Double.parseDouble(request.getParameter("inputPrice"));
        double discountPercent = Double.parseDouble(request.getParameter("discountPercent"));
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        double discountAmount = inputPrice * discountPercent * 0.01;
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\">");
        writer.println("</head>");
        writer.println("<body>");
        double discountPrice = inputPrice - discountAmount;
        writer.println("product description : " + productDescription + "<br>");
        writer.println("list price : " + inputPrice + "<br>");
        writer.println("discount percent : " + discountPercent + "<br>");
        writer.println("discount amount : " + discountAmount + "<br>");
        writer.println("discount price : " + discountPrice + "<br>");
    }
}