package main;

import java.io.Serializable;

import DanhSach.DanhSachNguyenLieu;
import KiemTra.KiemTra;

public class ChiTietCongThuc implements Serializable{
    private String maCT;
    private String maNL;
    private int soLuong;

    public ChiTietCongThuc() {
        maCT = "";
        maNL = "";
        soLuong = 0;
    }

    public ChiTietCongThuc(String maCT, String maNL, int soLuong) {
        this.maCT = maCT;
        this.maNL = maNL;
        this.soLuong = soLuong;
    }

    public String getMaCT() {
        return maCT;
    }

    public void setMaCT() {
        do {
            System.out.print("Nhập mã công thức: ");
            maCT = KiemTra.kiemTraNhapChuoi();
            //
        } while (true);
    }

    public void setMaCT(String maCT) {
        this.maCT = maCT;
    }

    public String getMaNL() {
        return maNL;
    }

    public String toStringMaNL() {
        return DanhSachNguyenLieu.timKiemNguyenLieu(maNL).getTenNL();
    }

    public void setMaNL() {
        do {
            System.out.println("Nhập mã nguyên liệu: ");
            maNL = KiemTra.kiemTraNhapMaNL();
            //
        } while (true);
    }

    public void setMaNL(String maNL) {
        this.maNL = maNL;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong() {
        System.out.print("Nhập số lượng: ");
        soLuong = KiemTra.kiemTraSoNguyenDuong();
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonViTinh() {
        return DanhSachNguyenLieu.timKiemNguyenLieu(maNL).getDonViTinh();
    }

    public void nhapCTCT() {
        setMaCT();
        setMaNL();
        setSoLuong();
    }

    public void suaCTCT() {
        int opt;
        do {
            System.out.println("Các thao tác: ");
            System.out.println("1. Sửa mã công thức.");
            System.out.println("2. Sửa mã nguyên liệu.");
            System.out.println("3. Sửa số lượng.");
            System.out.print("Lựa chọn: ");
            opt = KiemTra.kiemTraNhapSoNguyen();
            switch (opt) {
                case 0:
                    break;
                case 1:
                    setMaCT();
                    break;
                case 2:
                    setMaNL();
                    break;
                case 3:
                    setSoLuong();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Thoát!");
                    break;
            }
        } while (opt != 0);
    }

    public void xuatCTCT() {
        System.out.printf("%-20s");
        System.out.printf("%-`10s%-20s%-10s%-15s", getMaCT(), toStringMaNL(), getSoLuong(), getDonViTinh());
    }

    public void xuatCTCT1() {
        System.out.printf("%-20s");
        System.out.printf("%-`10s%-20s%-10s%-15s", getMaNL(), toStringMaNL(), getSoLuong(), getDonViTinh());
    }
}
