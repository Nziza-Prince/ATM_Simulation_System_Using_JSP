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

        // Debug logs
        System.out.println("Deposit amount: " + amount);
        System.out.println("User ID: " + user.getId());
        System.out.println("User balance before deposit: " + user.getBalance());

        DepositDAO depositDAO = new DepositDAO();
        if (depositDAO.deposit(user, amount)) {
            // Update the user's balance in the session
            user.setBalance(user.getBalance() + amount); // Update the balance in the session
            session.setAttribute("user", user); // Save the updated user object in the session

            // Debug logs
            System.out.println("User balance after deposit: " + user.getBalance());

            response.sendRedirect("dashboard");
        } else {
            response.sendRedirect("depositPage?error=1");
        }
    }
}