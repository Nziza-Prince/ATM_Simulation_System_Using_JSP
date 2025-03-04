package com.atm.dao;

import com.atm.model.User;
import com.atm.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class WithdrawDAO {
    public boolean withdraw(User user, double amount) {
        if (user.getBalance() < amount) {
            System.out.println("Insufficient balance!"); // Debug statement
            return false; // Insufficient balance
        }

        String query = "UPDATE users SET balance = balance - ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDouble(1, amount);
            stmt.setInt(2, user.getId());
            int rowsUpdated = stmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated); // Debug statement
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}