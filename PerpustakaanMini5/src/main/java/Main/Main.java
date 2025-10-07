/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

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
            System.out.println("7. Tampilkan data dari Database");
            System.out.println("8. Lihat data via ORM (Majalah)");
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
                default -> System.out.println("Pilihan tidak ada, coba lagi ya");
            }
        }
    }
}