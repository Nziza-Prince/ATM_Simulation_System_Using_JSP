package com.atm.controller;

import com.atm.dao.BalanceDAO;
import com.atm.dao.WithdrawDAO;
import com.atm.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double amount = Double.parseDouble(request.getParameter("amount"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // Refresh the user's balance from the database
        BalanceDAO balanceDAO = new BalanceDAO();
        double currentBalance = balanceDAO.getBalance(user);
        user.setBalance(currentBalance); // Update the balance in the session
        session.setAttribute("user", user); // Save the updated user object in the session

        System.out.println("Withdraw amount: " + amount); // Debug statement
        System.out.println("User balance before withdrawal: " + user.getBalance()); // Debug statement

        WithdrawDAO withdrawDAO = new WithdrawDAO();
        if (withdrawDAO.withdraw(user, amount)) {
            // Update the user's balance in the session after withdrawal
            user.setBalance(user.getBalance() - amount);
            session.setAttribute("user", user);
            System.out.println("User balance after withdrawal: " + user.getBalance()); // Debug statement
            response.sendRedirect("dashboard");
        } else {
            response.sendRedirect("withdrawPage?error=1");
        }
    }
}