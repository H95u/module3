package com.example.case_study.controller;

import com.example.case_study.DAO.AccountDAO;
import com.example.case_study.model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "AccountServlet", value = "/home")
@MultipartConfig
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Account> accountList = AccountDAO.getInstance().findAll();
        req.setAttribute("account", accountList);
        req.getRequestDispatcher("/homePage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file");
        InputStream fileContent = filePart.getInputStream();
        AccountDAO.getInstance().addAccount(fileContent);
    }

    protected void finAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
