/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Administrator
 */
public abstract class ItemPerpustakaan {
    private String judul;
    private int tahunTerbit;

    public ItemPerpustakaan(String judul, int tahunTerbit) {
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    // Abstraction
    public abstract String getInfo();

    @Override
    public String toString() {
        return judul + " | " + tahunTerbit;
    }
}