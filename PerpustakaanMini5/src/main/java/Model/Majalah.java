/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Administrator
 */
public class Majalah extends ItemPerpustakaan implements CetakInfo {
    private int edisi;

    public Majalah(String judul, int tahunTerbit, int edisi) {
        super(judul, tahunTerbit);
        this.edisi = edisi;
    }

    public int getEdisi() {
        return edisi;
    }

    public void setEdisi(int edisi) {
        this.edisi = edisi;
    }

    // abstract method
    @Override
    public String getInfo() {
        return "Majalah: " + getJudul() + " | Edisi " + edisi + " | " + getTahunTerbit();
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