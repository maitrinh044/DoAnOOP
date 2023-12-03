package main;

import java.io.Serializable;

import DanhSach.*;
import KiemTra.KiemTra;

public class CongThuc implements Serializable{
    private String maSP;
    private String maCT;
    
    public CongThuc() {
        maSP = "";
        maCT = "";
    }

    public CongThuc(String maSP, String maCT) {
        this.maCT = maCT;
        this.maSP = maSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP() {
        do {
            System.out.print("Nhập mã sản phẩm: ");
            maSP = KiemTra.kiemTraNhapMaSP();
            if (DanhSachSanPham.timKiemSanPhamTheoMaSP(maSP) == null) {
                System.out.println("Không tồn tại sản phẩm. Vui lòng nhập lại!");
            }
            else if (DanhSachCongThuc.timKiemCongThuc(maSP) != null) {
                    System.out.println("Sản phẩm này đã có công thức. Vui lòng nhập lại!");
                }
            else break;
        } while (true);
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaCT() {
        return maCT;
    }

    public void setMaCT() {
        do {
            System.out.print("Nhập mã công thức: ");
            maCT = KiemTra.kiemTraNhapChuoi();
            if (DanhSachCongThuc.timKiemCongThuc(maCT) != null) {
                System.out.println("Mã công thức đã tồn tại. Vui lòng nhập lại");
            }
            else break;
        } while (true);
    }

    public void setMaCT(String maCT) {
        this.maCT = maCT;
    }
    
    public void nhapCongThuc() {
        setMaSP();
        setMaCT();
    }    

    public void suaCongThuc() {
        String input;
        int opt;
        do {
            System.out.println("Các thao tác:");
            System.out.println("0. Thoát.");
            System.out.println("1. Sửa mã công thức.");
            System.out.println("2. Sửa mã sản phẩm.");
            System.out.println("3. Sửa các chi tiết của công thức.");
            opt = KiemTra.kiemTraNhapSoNguyen();
            System.out.println();
            switch (opt) {
                case 0:
                    break;
                case 1:
                    setMaCT();
                    break;
                case 2:
                    setMaSP();
                    break;
                case 3:
                    System.out.print("Nhập mã hoặc tên nguyên liệu: ");
                    input = KiemTra.kiemTraNhapChuoi();
                    if (DanhSachChiTietCongThuc.timkiemCTCT(input) == null) {
                        System.out.println("Chi tiết công thức không tồn tại.");
                    }
                    else {
                        DanhSachChiTietCongThuc.timkiemCTCT(input).suaCTCT();
                    }
                default:
                    System.out.println("Lựa chọn không hợp lệ. Thoát!");
                    break;
            }
        }
        while (opt != 0);
    }

    public void xuatCongThuc() {
        System.out.printf("%-10s%-10s\n", getMaCT(), getMaSP());
    }
}