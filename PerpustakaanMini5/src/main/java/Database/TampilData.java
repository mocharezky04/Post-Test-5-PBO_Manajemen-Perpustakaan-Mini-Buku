/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class TampilData {
    public void tampilkanDataBuku() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String query = "SELECT * FROM buku";
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\n=== Data Buku dari Database ===");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("judul") + " | " +
                    rs.getString("penulis") + " | " +
                    rs.getInt("tahun_terbit")
                );
            }

        } catch (Exception e) {
            System.out.println("Gagal menampilkan data: " + e.getMessage());
        }
    }
}
