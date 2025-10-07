/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ORM;

import Database.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class MajalahORM {
    public void tampilkanMajalah() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) {
                System.out.println("Koneksi database gagal!");
                return;
            }

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM majalah";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\n=== Data Majalah dari ORM ===");
            while (rs.next()) {
                int id = rs.getInt("id");
                String judul = rs.getString("judul");
                int tahun = rs.getInt("tahun_terbit");
                int edisi = rs.getInt("edisi");

                System.out.println(id + " | " + judul + " | Edisi " + edisi + " | " + tahun);
            }

        } catch (Exception e) {
            System.out.println("Gagal memuat data majalah: " + e.getMessage());
        }
    }
}