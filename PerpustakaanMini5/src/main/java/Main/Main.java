/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import Model.Buku;
import Model.Majalah;
import ORM.BukuORM;
import ORM.MajalahORM;
import Service.PerpustakaanService;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        PerpustakaanService service = new PerpustakaanService();
        service.loadDataAwal();
        
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Manajemen Perpustakaan Mini ===");
            System.out.println("1. Tambah item");
            System.out.println("2. Lihat daftar item");
            System.out.println("3. Update item");
            System.out.println("4. Hapus item");
            System.out.println("5. Cari item");
            System.out.println("6. Keluar");
            System.out.println("7. Tampilkan data(Buku) dari Database");
            System.out.println("8. Lihat data via ORM (Majalah)");
            System.out.println("9. Tambah item (Buku dan Majalah) ke Database (ORM)");
            System.out.print("Pilih menu: ");

            int pilihan = -1;
            if (input.hasNextInt()) {
                pilihan = input.nextInt();
                input.nextLine();
            } else {
                System.out.println("Input harus berupa angka ya");
                input.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1 -> service.tambahItem();
                case 2 -> service.lihatItem();
                case 3 -> service.updateItem();
                case 4 -> service.hapusItem();
                case 5 -> service.cariItem();
                case 6 -> {
                    System.out.println("Terima kasih sudah menggunakan sistem perpustakaan mini.");
                    return;
                }
                case 7 -> {
                    Database.TampilData tampil = new Database.TampilData();
                    tampil.tampilkanDataBuku(); // tampilkan data buku (pakai JDBC)
                }
                case 8 -> {
                    ORM.MajalahORM ormMajalah = new ORM.MajalahORM();
                    ormMajalah.tampilkanMajalah(); // tampilkan data majalah (pakai ORM)
                }
                case 9 -> {
                    System.out.println("Pilih jenis item yang ingin disimpan ke database:");
                    System.out.println("1. Buku");
                    System.out.println("2. Majalah");
                    System.out.print("Pilihan: ");
                    int jenis = input.nextInt();
                    input.nextLine();

                    if (jenis == 1) {
                        System.out.print("Masukkan judul buku: ");
                        String judul = input.nextLine();
                        System.out.print("Masukkan penulis buku: ");
                        String penulis = input.nextLine();
                        System.out.print("Masukkan tahun terbit: ");
                        int tahun = input.nextInt();

                        Buku bukuBaru = new Buku(judul, penulis, tahun);
                        new BukuORM().simpanBuku(bukuBaru);

                    } else if (jenis == 2) {
                        System.out.print("Masukkan judul majalah: ");
                        String judul = input.nextLine();
                        System.out.print("Masukkan tahun terbit: ");
                        int tahun = input.nextInt();
                        System.out.print("Masukkan edisi: ");
                        int edisi = input.nextInt();

                        Majalah majalahBaru = new Majalah(judul, tahun, edisi);
                        new MajalahORM().simpanMajalah(majalahBaru);

                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                }
                default -> System.out.println("Pilihan tidak ada, coba lagi ya");
            }
        }
    }
}