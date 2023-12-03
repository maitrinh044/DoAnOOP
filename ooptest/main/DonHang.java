package main;

import DanhSach.DanhSachCTDonHang;

import java.util.Date;
import java.util.List;

public class DonHang {
    private static int soDonHang = 0;
    private String maDH;
    private Date ngayLapDon;
    private String maNV;
    private String maKH;

    //Constructor
    public DonHang() {
        
    }

    //Phương thức tạo mã đơn hàng tự động
    public static String taoMaDonHang() {
        soDonHang++;
        //Mã đơn hàng có dạng: DH001, DH002, ...
        return String.format("DH%03d", soDonHang);
    }

    public DonHang(String maNV, String maKH) {
        maDH = taoMaDonHang();
        ngayLapDon = new Date();
        this.maNV = maNV;
        this.maKH = maKH;
        //Khởi tạo lại số lượng chi tiết đơn hàng khi tạo 1 đơn hàng mới
        ChiTietDonHang.khoiTaoLaiSoCTDH();
    }

    public DonHang(String maDH, Date ngayLapDon, String maNV, String maKH) {
        this.maDH = maDH;
        this.ngayLapDon = ngayLapDon;
        this.maNV = maNV;
        this.maKH = maKH;
    }


    //Getter - Setter
    public static int getSoDonHang() {
        return soDonHang;
    }

    public static void setSoDonHang(int soDonHang) {
        DonHang.soDonHang = soDonHang;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public Date getNgayLapDon() {
        return ngayLapDon;
    }

    public void setNgayLapDon(Date ngayLapDon) {
        this.ngayLapDon = ngayLapDon;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    //Phương thức tính tổng tiền của 1 đơn hàng
    public double tongTienHoaDon() {
        DanhSachCTDonHang danhSachCTDonHang = new DanhSachCTDonHang();
        List<ChiTietDonHang> dsCTDH = danhSachCTDonHang.getDS_CTDonHang();
        double tongTien = 0;
        for(ChiTietDonHang ctDH : dsCTDH) {
            //lấy những chi tiết đơn hàng thuộc mã đơn hàng trong danh sách CTDH
            String[] maCTDH = ctDH.getMaCTDH().split("_");
            if(maCTDH[0].equals(maDH)) {
                tongTien += ctDH.thanhTien();
            }
        }
        return tongTien;
    }

    //Phương thức in thông tin đơn hàng
    public void inThongTinDonHang() {
        System.out.printf("|%-5s|%-20s|%-5s|%-5s|%.2f\n",
                           maDH, ngayLapDon, maNV, maKH, tongTienHoaDon());
    }
}
