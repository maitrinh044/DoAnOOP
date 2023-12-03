package main;

import java.io.Serializable;
import java.util.ArrayList;

import DanhSach.*;
import main.*;
import KiemTra.KiemTra;

public class GioHang implements Serializable {
    private String maGioHang;
    
    // constructor
    public GioHang()
    {
        maGioHang ="";
    }

    public GioHang(String maGioHang) 
    {
        this.maGioHang = maGioHang;
    }

    public String getMaGioHang() {
        return maGioHang;
    }

    public void setMaGioHang(String maGioHang) {
        this.maGioHang = maGioHang;
    }

    public void xuatGioHang() {
        if (DanhSachChiTietGioHang.getSoLuong() == 0) {
            System.out.println("Giỏ hàng của bạn đang trống.\n");
            return;
        }
        ArrayList<ChiTietGioHang> arr = DanhSachChiTietGioHang.timKiemCTGioHang(maGioHang);

        if (arr.size() == 0) {
            System.out.println("Giỏ hàng của bạn đang trống.");
        }
        else {
            System.out.printf("%-15s%-10s%-10s%-10s\n", "Tên sản phẩm", "Đơn giá", "Số lượng", "Tổng tiền");
            for (ChiTietGioHang i : arr) {
                i.xuatCTGioHang();
            }
        }
        System.out.println();
    }

    public void xoaToanBoSP()
    {
        ArrayList<ChiTietGioHang> arrCTGioHang = DanhSachChiTietGioHang.timKiemCTGioHang(maGioHang);
        System.out.println("Bạn có muốn xóa toàn bộ sản phẩm trong giỏ hàng? (1.Có 2.Không)");
        System.out.print("Lựa chọn");
        int opt = KiemTra.kiemTraNhapSoNguyen();
        if (opt ==1) {
            for (ChiTietGioHang i : arrCTGioHang) {
                DanhSachChiTietGioHang.xoaCTGioHang(i);
            }
            System.out.println("Đã xóa toàn bộ sản phẩm.\n");
            DanhSachChiTietGioHang.ghiFile();

        }
        else return;
    }

}