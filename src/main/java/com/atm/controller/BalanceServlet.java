package com.atm.controller;

import com.atm.dao.BalanceDAO;
import com.atm.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/balance")
public class BalanceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            BalanceDAO balanceDAO = new BalanceDAO();
            double balance = balanceDAO.getBalance(user);
            request.setAttribute("balance", balance); // Set the balance attribute
            request.getRequestDispatcher("balancePage").forward(request, response);
        } else {
            response.sendRedirect("index"); // Redirect to login if user is not in session
        }
    }
}