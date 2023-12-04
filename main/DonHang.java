package main;

import DanhSach.DanhSachCTDonHang;
import DanhSach.DanhSachDonHang;
import KiemTra.KiemTra;

import java.sql.Date;
import java.util.ArrayList;

public class DonHang {
    private String maDH;
    private Date ngayLapDon;
    private String maNV;
    private String maKH;

    // Constructor
    public DonHang() {
        maDH = String.format("DH%03d", DanhSachDonHang.soDH);
        long millis = System.currentTimeMillis();
        ngayLapDon = new Date(millis);
        maNV = "";
        maKH = "";
    }

    public DonHang(String maDH, String maNV, String maKH) {
        this.maDH = maDH;
        long millis = System.currentTimeMillis();
        ngayLapDon = new Date(millis);
        this.maNV = maNV;
        this.maKH = maKH;
    }

    // Getter - Setter
    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public void setMaDH() {
        System.out.print("Nhập mã đơn hàng: ");
        maDH = KiemTra.kiemTraNhapMaDH();
    }

    public Date getNgayLapDon() {
        return ngayLapDon;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setMaNV() {
        System.out.print("Nhập mã nhân viên: ");
        maNV = KiemTra.kiemTraNhapMaNV();
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setMaKH() {
        System.out.print("Nhập mã khách hàng: ");
        maKH = KiemTra.kiemTraNhapMaKH();
    }

    // Phương thức tính tổng tiền của 1 đơn hàng
    public int tongTienHoaDon() {
        ArrayList<ChiTietDonHang> dsCTDH = DanhSachCTDonHang.timKiemCTDH(getMaDH());
        int tongTien = 0;
        for (ChiTietDonHang ctDH : dsCTDH) {
            if (ctDH.getMaDH().equals(maDH)) {
                tongTien += ctDH.thanhTien();
            }
        }
        return tongTien;
    }

    // Phương thức in thông tin đơn hàng
    public void inThongTinDonHang() {
        System.out.printf("|%-5s|%-20s|%-5s|%-5s|%.2f\n",
                maDH, ngayLapDon, maNV, maKH, tongTienHoaDon());
    }

    public void nhapThongTinDonHang() {
        setMaDH();
        setMaNV();
        setMaKH();
        System.out.println();
    }

    public void suaDonHang() {
        int opt;
        do {
            System.out.println("Các thao tác: ");
            System.out.println("0.Thoát.");
            System.out.println("1.Mã đơn hàng.");
            System.out.println("2.Mã nhân viên.");
            System.out.println("3.Mã khách hàng.");
            System.out.print("Lựa chọn: ");
            opt = KiemTra.kiemTraNhapSoNguyen();
            switch (opt) {
                case 0:
                    break;
                case 1:
                    setMaDH();
                    break;
                case 2:
                    setMaNV();
                    break;
                case 3:
                    setMaKH();
                default:
                    System.out.println("Lựa chọn không hợp lệ. Thoát!");
                    break;
            }
        } while (opt != 0);
    }
}
