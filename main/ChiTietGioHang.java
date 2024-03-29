package main;

import java.io.Serializable;

import KiemTra.KiemTra;

public class ChiTietGioHang implements Serializable{
    private String maGioHang;
    private String maSP;
    private int soLuong;
    private int donGia;

    public ChiTietGioHang()
    {
        maGioHang = "";
        maSP = "";
        soLuong = 0;
        donGia = 0;
    }

    public ChiTietGioHang(String maGioHang, String maSP, int soLuong, int donGia)
    {
        this.maGioHang = maGioHang;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaGioHang() {
        return maGioHang;
    }

    public void setMaGioHang(String maTK) {
        this.maGioHang = maTK;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setSoLuong() {
        System.out.print("Nhập số lượng: ");
        soLuong = KiemTra.kiemTraSoNguyenDuong();
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public void xuatCTGioHang()
    {
        System.out.printf("%-15s%-10s%-10s%-10s\n", maSP, donGia, soLuong, donGia*soLuong);
    }

    
    
}
