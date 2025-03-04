package com.atm.dao;

import com.atm.model.User;
import com.atm.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DepositDAO {
    public boolean deposit(User user, double amount) {
        String query = "UPDATE users SET balance = balance + ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDouble(1, amount);
            stmt.setInt(2, user.getId());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0; // Return true if the balance was updated
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}