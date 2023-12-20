package main;

import KiemTra.KiemTra;

import java.io.Serializable;

import DanhSach.*;


public class ChiTietPhieuNhap implements Serializable{
    private String maPN;
    private String maNL;
    private int soLuong;
    private int donGia;
    
    public ChiTietPhieuNhap(){
        maPN = "";
        maNL = "";
        soLuong = 0;
        donGia = 0;
    }
    public ChiTietPhieuNhap(String maPN, String maNL, int soLuong, int donGia){
        this.maPN = maPN;
        this.maNL = maNL;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public void setMaNL(String maNL) {
        this.maNL = maNL;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
    private void setMaPN(){
        do {
            System.out.println("Nhập mã phiếu nhập: ");
            maPN = KiemTra.kiemTraNhapMaPN();
            if (DanhSachPhieuNhap.timPhieuNhap(maPN) == null) {
                System.out.println("Không tồn tại phiếu nhập. Vui lòng nhập lại!");
            }
            else break;
        } while (true);

    }
    private void setMaNL(){
        do {
            System.out.print("Nhập mã nguyên liệu: ");
            maNL = KiemTra.kiemTraNhapMaNL();
            if (DanhSachNguyenLieu.timKiemNguyenLieu(maNL) == null) {
                System.out.println("Nguyên liệu không tồn tại. Vui lòng nhập lại!");
            }
            else break;
        } while (true);
    }
    
    private void setSoLuong(){
        System.out.print("Nhập số lượng nguyên liệu: ");
        soLuong = KiemTra.kiemTraSoNguyenDuong();
    }

    private void setDonGia(){
        donGia = DanhSachNguyenLieu.timKiemNguyenLieu(maNL).getDonGia();
    }

    public String getMaPN(){
        return maPN;
    }

    public String getMaNL(){
        return maNL;
    }

    public String toStringMaNL() {
        return DanhSachNguyenLieu.timKiemNguyenLieu(maNL).getTenNL();
    }

    public int getSoLuong(){
        return soLuong;
    }

    public int getDonGia(){
        return donGia;
    }

    public void nhapChiTietPN(String maPN){
        setMaPN(maPN);
        setMaNL();
        setSoLuong();
        setDonGia();
    }

    public void suaChiTietPN() {
        int opt;
        do {
            System.out.println("Các thao tác: ");
            System.out.println("0. Thoát.");
            System.out.println("1. Sửa mã phiếu nhập.");
            System.out.println("2. Sửa mã nguyên liệu .");
            System.out.println("3. Sửa số lượng.");
            opt = KiemTra.kiemTraNhapSoNguyen();
            switch (opt) {
                case 0:
                    break;
                case 1:
                    setMaPN();
                    break;
                case 2: 
                    setMaNL();
                    break;
                case 3:
                    setSoLuong();
                    break;
                default:
                    break;
            }
        } while (opt != 0);
    }

    public void xuatChiTietPN(){
        System.out.printf("%-10s%-10s%-10s%-10s\n",getMaPN(), getMaNL(), getSoLuong(), getDonGia());
    }

    public void xuatChiTietPN1(){
        System.out.printf("%-10s%-20s%-10s%-10s\n", getMaNL(), toStringMaNL(), getSoLuong(), getDonGia());
    }
}
