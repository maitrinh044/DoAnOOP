package main;

import KiemTra.KiemTra;

import java.util.Date;

import DanhSach.DanhSachGiaoHang;

public class GiaoHang {
    private String maGiaoHang;
    private String maDH;
    private Date ngayGiaoHang;
    private String diaChiGiaoHang;
    private int phiGiaoHang;
    private String phuongThucGiaoHang;

    //Constructor
    public GiaoHang() {
        this.maGiaoHang = String.format("DGH%03d", DanhSachGiaoHang.getSoLuong()+1);
        this.maDH = "";
        long millis = System.currentTimeMillis();
        this.ngayGiaoHang = new Date(millis);
        this.diaChiGiaoHang = "";
        this.phiGiaoHang = 0;
        this.phuongThucGiaoHang = "";
    }

    public GiaoHang(String maGiaoHang, String maDH, Date ngayGiaoHang, String diaChiGiaoHang, int phiGiaoHang, String phuongThucGiaoHang) {
        this.maGiaoHang = maGiaoHang;
        this.maDH = maDH;
        this.ngayGiaoHang = ngayGiaoHang;
        this.diaChiGiaoHang = diaChiGiaoHang;
        this.phiGiaoHang = phiGiaoHang;
        this.phuongThucGiaoHang = phuongThucGiaoHang;
    }

    public GiaoHang(String maDH, String diaChiGiaoHang, int phiGiaoHang, String phuongThucGiaoHang) {
        this.maGiaoHang = String.format("DGH%03d", DanhSachGiaoHang.getSoLuong());
        this.maDH = maDH;
        long millis = System.currentTimeMillis();
        this.ngayGiaoHang = new Date(millis);
        this.diaChiGiaoHang = diaChiGiaoHang;
        this.phiGiaoHang = phiGiaoHang;
        this.phuongThucGiaoHang = phuongThucGiaoHang;
    }

    //Getter - Setter
    public String getMaGiaoHang() {
        return maGiaoHang;
    }

    public void setMaGiaoHang(String maGiaoHang) {
        this.maGiaoHang = maGiaoHang;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public Date getNgayGiaoHang() {
        return ngayGiaoHang;
    }

    public void setNgayGiaoHang(Date ngayGiaoHang) {
        this.ngayGiaoHang = ngayGiaoHang;
    }

    public String getDiaChiGiaoHang() {
        return diaChiGiaoHang;
    }

    public void setDiaChiGiaoHang(String diaChiGiaoHang) {
        this.diaChiGiaoHang = diaChiGiaoHang;
    }

    public int getPhiGiaoHang() {
        return phiGiaoHang;
    }

    public void setPhiGiaoHang(int phiGiaoHang) {
        this.phiGiaoHang = phiGiaoHang;
    }

    public String getPhuongThucGiaoHang() {
        return phuongThucGiaoHang;
    }

    public void setPhuongThucGiaoHang(String phuongThucGiaoHang) {
        this.phuongThucGiaoHang = phuongThucGiaoHang;
    }

    //Phương thức in đơn giao hàng
    public void inThongTinGiaoHang() {
        System.out.printf("|%-6s|%-5s|%-10s|%-30s|%-10s|%-15s\n",
                          maGiaoHang, maDH, KiemTra.chuyenDateThanhChuoi(ngayGiaoHang), diaChiGiaoHang, phiGiaoHang, phuongThucGiaoHang);
    }
}
