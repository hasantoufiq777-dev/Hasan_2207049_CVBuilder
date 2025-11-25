package com.example.cvbuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {

    public static void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS cv (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    email TEXT
                );
                """;

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static int insertCV(CVModel cv) {
        String sql = "INSERT INTO cv(name, email) VALUES (?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, cv.getName());
            ps.setString(2, cv.getEmail());
            int affected = ps.executeUpdate();

            if (affected == 0) return -1;
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }


    public static boolean updateCV(int id, String name, String email) {
        String sql = "UPDATE cv SET name = ?, email = ? WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete by id
    public static boolean deleteCV(int id) {
        String sql = "DELETE FROM cv WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static List<CVModel> getAllCVs() {
        List<CVModel> list = new ArrayList<>();
        String sql = "SELECT id, name, email FROM cv ORDER BY id DESC";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                CVModel cv = new CVModel();
                cv.setName(rs.getString("name"));
                cv.setEmail(rs.getString("email"));

                list.add(cv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
