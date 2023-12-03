package main;

import KiemTra.KiemTra;

public class NVBanHang extends NhanVien {
    KiemTra kiemTra = new KiemTra();
    private static final double LUONG_CB = 10000000;    //10 triệu
    private double tienThuong;

    //Constructor
    public NVBanHang() {
        super();
        tienThuong = 0.0;
    }

    public NVBanHang(String maNV, String tenNV, String ngaySinh, String dienThoai, double tienThuong) {
        super(maNV, tenNV, ngaySinh, dienThoai);
        this.tienThuong = tienThuong;
    }

    //Getter - Setter
    public double getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(double tienThuong) {
        this.tienThuong = tienThuong;
    }

    @Override
    public String getChucVu() {
        return "Bán hàng";
    }

    //Tính lương cho NV
    @Override
    public double tinhLuong() {
        return LUONG_CB + tienThuong;
    }

    @Override
    public void inHoSoNhanVien() {
        System.out.printf("|%-5s|%-30s|%-10s|%-10s|%-10s|%4.1f\n",
                          maNV, tenNV, "Bán hàng", ngaySinh, dienThoai, tinhLuong());
    }

    @Override
    public void nhapHoSoNhanVien() {
        System.out.print("Nhập mã nhân viên: ");
        maNV = KiemTra.kiemTraNhapMaNV();
        System.out.print("Nhập tên nhân viên: ");
        tenNV = KiemTra.kiemTraNhapTen();
        System.out.print("Nhập ngày sinh: ");
        ngaySinh = KiemTra.kiemTraNgayThangNam();
        System.out.print("Nhập số điện thoại: ");
        dienThoai = KiemTra.kiemTraNhapSDT();
        System.out.print("Nhập tiền thưởng: ");
        tienThuong = KiemTra.kiemTraTienThuong();
    }

    @Override
    public String toString() {
        return super.toString() + "#" + getChucVu() + "#" + tienThuong + "#" + tinhLuong();
    }
}
