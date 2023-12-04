package main;

import DanhSach.DanhSachSanPham;
import KiemTra.KiemTra;

public class ChiTietDonHang {
    private static int soCTDH = 0;
    private String maCTDH;
    private String maSP;
    private int soLuong;
    private String maKM;

    public ChiTietDonHang(String maCTDH, String maSP, int soLuong, String maKM) {
        this.maCTDH = maCTDH;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.maKM = maKM;
    }

    public ChiTietDonHang() {
        maCTDH = "";
        maSP = "";
        soLuong = 0;
        maKM = "";
    }

    private static String taoMaChiTietDonHang(DonHang donHang) {
        soCTDH++;
        return String.format("%s_%d", donHang.getMaDH(), soCTDH);
    }

    public SanPham sanPham() {
        // DanhSachSanPham danhSachSanPham = new DanhSachSanPham();
        return DanhSachSanPham.timKiemSanPhamTheoMaSP(maSP);
    }

    public ChiTietDonHang(DonHang donHang, String maSP, int soLuong, String maKM) {
        this.maCTDH = taoMaChiTietDonHang(donHang);
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.maKM = maKM;
    }

    // Phương thức khởi tạo lại số lượng chi tiết đơn hàng (khi tạo 1 đơn hàng mới)
    public static void khoiTaoLaiSoCTDH() {
        soCTDH = 0;
    }

    // Getter - Setter
    public String getMaCTDH() {
        return maCTDH;
    }

    public void setMaCTDH(String maCTDH) {
        this.maCTDH = maCTDH;
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
    public double thanhTien() {
        SanPham sanPham = DanhSachSanPham.timKiemSanPhamTheoMaSP(maSP);
        double giaBan = 0;
        if (sanPham instanceof ThucAn thucAn) {
            giaBan = thucAn.getDonGia();
        } else if (sanPham instanceof ThucUong thucUong) {
            giaBan = thucUong.getDonGia();
        }
        return soLuong * giaBan;
    }

    // Phương in chi tiết đơn hàng
    // MaCTDH, TenSP, SoLuong, DonGia, ThanhTien
    public void inCTDonHang() {
        SanPham sanPham = DanhSachSanPham.timKiemSanPhamTheoMaSP(maSP);
        System.out.printf("\t%10s\t%30s\tSL: %d\tĐơn giá: %.2f\tThành tiền: %.2f\n", maCTDH, sanPham.getTenSP(),
                soLuong, sanPham.getDonGia(), thanhTien());
    }

    // public void

    public void nhapThongTinCTDH() {
        System.out.print("Nhập mã chi tiết đơn hàng: ");
        maCTDH = KiemTra.kiemTraNhapMaCTDH();
        System.out.print("Nhập mã sản phẩm: ");
        maSP = KiemTra.kiemTraNhapMaSP();
        System.out.print("Nhập số lượng: ");
        soLuong = KiemTra.kiemTraSoNguyenDuong();
        System.out.print("Nhập mã khuyến mãi: ");
        maKM = KiemTra.kiemTraNhapMaKM();
    }
}
