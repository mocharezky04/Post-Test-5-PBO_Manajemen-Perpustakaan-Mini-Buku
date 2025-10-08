/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ORM;

import Database.DatabaseConnection;
import Model.Buku;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class BukuORM {
    public void simpanBuku(Buku buku) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO buku (judul, penulis, tahun_terbit) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, buku.getJudul());
            stmt.setString(2, buku.getPenulis());
            stmt.setInt(3, buku.getTahunTerbit());
            stmt.executeUpdate();
            System.out.println("Data buku berhasil disimpan ke database.");
        } catch (Exception e) {
            System.out.println("Gagal simpan buku: " + e.getMessage());
        }
    }
}