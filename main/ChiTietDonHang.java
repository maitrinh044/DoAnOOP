package main;

import DanhSach.DanhSachSanPham;
import KiemTra.KiemTra;

public class ChiTietDonHang {
    private String maDH;
    private String maSP;
    private int soLuong;
    private String maKM;

    public ChiTietDonHang(String maDH, String maSP, int soLuong, String maKM) {
        this.maDH = maDH;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.maKM = maKM;
    }

    public ChiTietDonHang() {
        maDH = "";
        maSP = "";
        soLuong = 0;
        maKM = "";
    }

    // Getter - Setter
    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
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

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    // Tính thành tiền của từng chi tiết đơn hàng
    public int thanhTien() {
        SanPham sanPham = DanhSachSanPham.timKiemSanPhamTheoMaSP(maSP);
        int giaBan = 0;
        if (sanPham instanceof ThucAn thucAn) {
            giaBan = thucAn.getDonGia();
        } else if (sanPham instanceof ThucUong thucUong) {
            giaBan = thucUong.getDonGia();
        }
        return soLuong * giaBan;
    }

    // Phương in chi tiết đơn hàng
    // MaDH, TenSP, SoLuong, DonGia, ThanhTien
    public void inCTDonHang() {
        SanPham sanPham = DanhSachSanPham.timKiemSanPhamTheoMaSP(maSP);
        System.out.printf("\t%30s\tSL: %d\tĐơn giá: %.2d\tThành tiền: %.2d\n", sanPham.getTenSP(),
                soLuong, sanPham.getDonGia(), thanhTien());
    }

    // public void

    public void nhapThongTinCTDH() {
        System.out.print("Nhập mã sản phẩm: ");
        maSP = KiemTra.kiemTraNhapMaSP();
        System.out.print("Nhập số lượng: ");
        soLuong = KiemTra.kiemTraSoNguyenDuong();
        System.out.print("Nhập mã khuyến mãi: ");
        maKM = KiemTra.kiemTraNhapMaKM();
    }
}
