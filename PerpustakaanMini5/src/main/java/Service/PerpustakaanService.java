/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Buku;
import Model.ItemPerpustakaan;
import Model.Majalah;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class PerpustakaanService {
    private ArrayList<ItemPerpustakaan> daftarItem = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    // Create
    public void tambahItem() {
        System.out.println("Pilih jenis item:");
        System.out.println("1. Buku");
        System.out.println("2. Majalah");
        System.out.print("Pilihan: ");
        int jenis = validasiAngka();
        input.nextLine();

        if (jenis == 1) {
            System.out.print("Masukkan judul buku: ");
            String judul = input.nextLine();
            System.out.print("Masukkan penulis buku: ");
            String penulis = input.nextLine();
            System.out.print("Masukkan tahun terbit: ");
            int tahun = validasiAngka();

            daftarItem.add(new Buku(judul, penulis, tahun));
            System.out.println("Buku berhasil ditambahkan");
        } else if (jenis == 2) {
            System.out.print("Masukkan judul majalah: ");
            String judul = input.nextLine();
            System.out.print("Masukkan tahun terbit: ");
            int tahun = validasiAngka();
            System.out.print("Masukkan nomor edisi: ");
            int edisi = validasiAngka();

            daftarItem.add(new Majalah(judul, tahun, edisi));
            System.out.println("Majalah berhasil ditambahkan");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    // Read
    public void lihatItem() {
        if (daftarItem.isEmpty()) {
            System.out.println("Belum ada item yang tersimpan.");
        } else {
            System.out.println("\n=== Daftar Item Perpustakaan ===");
            for (int i = 0; i < daftarItem.size(); i++) {
                System.out.println((i + 1) + ". " + daftarItem.get(i).getInfo());
            }
        }
    }

    // Update
    public void updateItem() {
        lihatItem();
        if (daftarItem.isEmpty()) return;

        System.out.print("Masukkan nomor item yang ingin diupdate: ");
        int idx = validasiAngka();
        if (idx <= 0 || idx > daftarItem.size()) {
            System.out.println("Nomor item tidak ada.");
            return;
        }

        ItemPerpustakaan item = daftarItem.get(idx - 1);

        if (item instanceof Buku) {
            input.nextLine();
            System.out.print("Masukkan judul baru: ");
            String judul = input.nextLine();
            System.out.print("Masukkan penulis baru: ");
            String penulis = input.nextLine();
            System.out.print("Masukkan tahun terbit baru: ");
            int tahun = validasiAngka();

            item.setJudul(judul);
            ((Buku) item).setPenulis(penulis);
            item.setTahunTerbit(tahun);

            System.out.println("Buku berhasil diupdate");
        } else if (item instanceof Majalah) {
            input.nextLine();
            System.out.print("Masukkan judul baru: ");
            String judul = input.nextLine();
            System.out.print("Masukkan tahun terbit baru: ");
            int tahun = validasiAngka();
            System.out.print("Masukkan edisi baru: ");
            int edisi = validasiAngka();

            item.setJudul(judul);
            item.setTahunTerbit(tahun);
            ((Majalah) item).setEdisi(edisi);

            System.out.println("Majalah berhasil diupdate");
        }
    }

    // Delete
    public void hapusItem() {
        lihatItem();
        if (daftarItem.isEmpty()) return;

        System.out.print("Masukkan nomor item yang ingin dihapus: ");
        int idx = validasiAngka();
        if (idx <= 0 || idx > daftarItem.size()) {
            System.out.println("Nomor item tidak ada.");
            return;
        }

        daftarItem.remove(idx - 1);
        System.out.println("Item berhasil dihapus");
    }

    // Search Overloading
    public void cariItem(String keyword) {
        boolean ditemukan = false;
        for (ItemPerpustakaan item : daftarItem) {
            if (item.getJudul().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(item);
                ditemukan = true;
            } else if (item instanceof Buku && ((Buku) item).getPenulis().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(item);
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Item tidak ditemukan.");
    }

    public void cariItem(int tahunTerbit) {
        boolean ditemukan = false;
        for (ItemPerpustakaan item : daftarItem) {
            if (item.getTahunTerbit() == tahunTerbit) {
                System.out.println(item);
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Item tidak ditemukan.");
    }

    public void cariItem() {
        if (daftarItem.isEmpty()) {
            System.out.println("Belum ada item yang tersimpan.");
            return;
        }

        System.out.println("Cari berdasarkan: 1. Judul/Penulis | 2. Tahun Terbit");
        int pilihan = validasiAngka();
        input.nextLine();

        if (pilihan == 1) {
            System.out.print("Masukkan keyword: ");
            String keyword = input.nextLine();
            cariItem(keyword);
        } else if (pilihan == 2) {
            System.out.print("Masukkan tahun terbit: ");
            int tahun = validasiAngka();
            cariItem(tahun);
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    // Validasi input angka
    private int validasiAngka() {
        while (!input.hasNextInt()) {
            System.out.print("Input harus berupa angka, coba lagi: ");
            input.next();
        }
        return input.nextInt();
    }
    public void loadDataAwal() {
        try (java.sql.Connection conn = Database.DatabaseConnection.getConnection();
             java.sql.Statement stmt = conn.createStatement()) {

            String sqlBuku = "SELECT * FROM buku";
            java.sql.ResultSet rsBuku = stmt.executeQuery(sqlBuku);
            while (rsBuku.next()) {
                String judul = rsBuku.getString("judul");
                String penulis = rsBuku.getString("penulis");
                int tahun = rsBuku.getInt("tahun_terbit");
                daftarItem.add(new Buku(judul, penulis, tahun));
            }

            String sqlMajalah = "SELECT * FROM majalah";
            java.sql.ResultSet rsMajalah = stmt.executeQuery(sqlMajalah);
            while (rsMajalah.next()) {
                String judul = rsMajalah.getString("judul");
                int tahun = rsMajalah.getInt("tahun_terbit");
                int edisi = rsMajalah.getInt("edisi");
                daftarItem.add(new Majalah(judul, tahun, edisi));
            }

            System.out.println("Data awal berhasil dimuat dari database");

        } catch (Exception e) {
            System.out.println("Gagal memuat data awal: " + e.getMessage());
        }
    }
}