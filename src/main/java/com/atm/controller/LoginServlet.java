package com.atm.controller;

import com.atm.dao.UserDAO;
import com.atm.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle GET requests (e.g., initial page load or language change)
        String language = request.getParameter("language");
        HttpSession session = request.getSession();
        if (language != null) {
            session.setAttribute("lang", language);
        }
        request.getRequestDispatcher("/index").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String language = request.getParameter("language");

        HttpSession session = request.getSession();
        session.setAttribute("lang", language); // Always update language

        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            response.sendRedirect("dashboard");
        } else {
            request.setAttribute("error", "1"); // Set error flag
            request.getRequestDispatcher("/index").forward(request, response);
        }
    }
}