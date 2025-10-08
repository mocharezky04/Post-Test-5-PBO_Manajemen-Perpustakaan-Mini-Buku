/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Administrator
 */
public class Buku extends ItemPerpustakaan implements CetakInfo {
    private String penulis;

    public Buku(String judul, String penulis, int tahunTerbit) {
        super(judul, tahunTerbit);
        this.penulis = penulis;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    // abstract method
    @Override
    public String getInfo() {
        return "Buku: " + getJudul() + " | " + penulis + " | " + getTahunTerbit();
    }

    // interface
    @Override
    public void cetakDetail() {
        System.out.println(getInfo());
    }

    @Override
    public String toString() {
        return getInfo();
    }
}