package main;

import java.io.Serializable;

import DanhSach.*;
import KiemTra.KiemTra;

public abstract class SanPham implements Serializable{
    private String maSP;
    private String tenSP;
    private int donGia;
    private String moTa;


    public SanPham() {
        maSP = "";
        tenSP = "";
        donGia = 0;
        moTa = "";
    }

    public SanPham(String maSP, String tenSP, int donGia, String moTa) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.moTa = moTa;
    }

    public SanPham(SanPham a) {
        this.maSP = a.maSP;
        this.tenSP = a.tenSP;
        this.donGia = a.donGia;
        this.moTa = a.moTa;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setMaSP() {
        do {
            System.out.print("Nhập mã sản phẩm: ");
            this.maSP = KiemTra.kiemTraNhapMaSP();
            if (DanhSachSanPham.timKiemSanPhamTheoMaSP(maSP) != null) {
                System.out.println("Mã sản phẩm đã tồn tại. Vui lòng nhập lại!");
            }
            else break;
        } while (true);
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String TenSP) {
        this.tenSP = TenSP;
    }

    public void setTenSP() {
        System.out.print("Nhập tên sản phẩm: ");
        tenSP = KiemTra.kiemTraNhapChuoi();
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public void setDonGia() {
        System.out.print("Nhập đơn giá sản phẩm: ");
        donGia = KiemTra.kiemTraSoNguyenDuong();
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setMoTa() {
        System.out.print("Nhập mô tả sản phẩm: ");
        moTa = KiemTra.kiemTraNhapChuoi();
    }

    public void nhapSanPham() {
        setMaSP();
        setTenSP();
        setDonGia();
        setMoTa();
    }

    public abstract void suaSanPham();

    public abstract void xuatSanPham();

    public abstract int ktraSoLuong();

    public abstract void cheBien(int soLuong);
}
