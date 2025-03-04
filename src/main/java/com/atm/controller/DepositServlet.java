package com.atm.controller;

import com.atm.dao.DepositDAO;
import com.atm.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double amount = Double.parseDouble(request.getParameter("amount"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        DepositDAO depositDAO = new DepositDAO();
        if (depositDAO.deposit(user, amount)) {
            response.sendRedirect("dashboard");
        } else {
            response.sendRedirect("depositPage?error=1");
        }
    }
}