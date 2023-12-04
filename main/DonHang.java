package main;

import DanhSach.DanhSachCTDonHang;
import KiemTra.KiemTra;

import java.util.List;

public class DonHang {
    private String maDH;
    private String ngayLapDon;
    private String maNV;
    private String maKH;

    public DonHang(String maDH, String ngayLapDon, String maNV, String maKH) {
        this.maDH = maDH;
        this.ngayLapDon = ngayLapDon;
        this.maNV = maNV;
        this.maKH = maKH;
    }

    // Constructor
    public DonHang() {
        maDH = "";
        ngayLapDon = "";
        maNV = "";
        maKH = "";
    }

    // Phương thức tạo mã đơn hàng tự động
    // public static String taoMaDonHang() {
    // soDonHang++;
    // // Mã đơn hàng có dạng: DH001, DH002, ...
    // return String.format("DH%03d", soDonHang);
    // }

    // public DonHang(String maNV, String maKH, String ngaylapdon) {
    // maDH = taoMaDonHang();
    // this.ngayLapDon = ngaylapdon;
    // this.maNV = maNV;
    // this.maKH = maKH;
    // // Khởi tạo lại số lượng chi tiết đơn hàng khi tạo 1 đơn hàng mới
    // ChiTietDonHang.khoiTaoLaiSoCTDH();
    // }

    // public DonHang(String maDH, Date ngayLapDon, String maNV, String maKH) {
    // this.maDH = maDH;
    // this.ngayLapDon = ngayLapDon;
    // this.maNV = maNV;
    // this.maKH = maKH;
    // }

    // Getter - Setter
    // public static int getSoDonHang() {
    // return soDonHang;
    // }

    // public static void setSoDonHang(int soDonHang) {
    // DonHang.soDonHang = soDonHang;
    // }

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

    public String getNgayLapDon() {
        return ngayLapDon;
    }

    public void setNgayLapDon(String ngayLapDon) {
        this.ngayLapDon = ngayLapDon;
    }

    public void setNgayLapDon() {
        System.out.print("Nhập ngày lập đơn: ");
        ngayLapDon = KiemTra.kiemTraNgayThangNam();
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
    public double tongTienHoaDon() {
        DanhSachCTDonHang danhSachCTDonHang = new DanhSachCTDonHang();
        // List<ChiTietDonHang> dsCTDH = DanhSachCTDonHang.getDS_CTDH();
        ChiTietDonHang[] dsCTDH = new ChiTietDonHang[DanhSachCTDonHang.getSoLuong()];
        dsCTDH = DanhSachCTDonHang.getDS_CTDH();
        double tongTien = 0;
        for (ChiTietDonHang ctDH : dsCTDH) {
            // lấy những chi tiết đơn hàng thuộc mã đơn hàng trong danh sách CTDH
            String[] maCTDH = ctDH.getMaCTDH().split("_");
            if (maCTDH[0].equals(maDH)) {
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
        setNgayLapDon();
        setMaNV();
        setMaKH();
        System.out.println();
    }

    public void suaDonHang() {
        int opt;
        do {
            System.out.println("Các thao tác: ");
            System.out.println("0.Thoát.");
            System.out.println("1.MÃ đơn hàng.");
            System.out.println("2.Ngày lập đơn.");
            System.out.println("3.Mã nhân viên.");
            System.out.println("4.Mã khách hàng.");
            System.out.print("Lựa chọn: ");
            opt = KiemTra.kiemTraNhapSoNguyen();
            switch (opt) {
                case 0:
                    break;
                case 1:
                    setMaDH();
                    break;
                case 2:
                    setNgayLapDon();
                    break;
                case 3:
                    setMaNV();
                    break;
                case 4:
                    setMaKH();
                default:
                    System.out.println("Lựa chọn không hợp lệ. Thoát!");
                    break;
            }
        } while (opt != 0);
    }
}
