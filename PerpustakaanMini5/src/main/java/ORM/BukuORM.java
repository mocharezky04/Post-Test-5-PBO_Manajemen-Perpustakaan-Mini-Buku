/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ORM;

import Database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class BukuORM {
    public void tampilSemuaBuku() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM buku";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\n=== Data Buku dari ORM ===");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("judul") + " | " +
                    rs.getString("penulis") + " | " +
                    rs.getInt("tahun_terbit")
                );
            }
        } catch (Exception e) {
            System.out.println("Gagal ambil data buku: " + e.getMessage());
        }
    }
}