package main;

import KiemTra.KiemTra;

public class NVQuanLy extends NhanVien {
    KiemTra kiemTra = new KiemTra();
    private static final double LUONG_CB = 12000000;    //12 triệu
    private double tienThuong;

    //Constructor
    public NVQuanLy() {
        super();
        tienThuong = 0.0;
    }

    public NVQuanLy(String maNV, String tenNV, String ngaySinh, String dienThoai, double tienThuong) {
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
        return "Quản lý";
    }

    //Tính lương cho NV
    @Override
    public double tinhLuong() {
        return LUONG_CB + tienThuong;
    }

    @Override
    public void inHoSoNhanVien() {
        System.out.printf("|%-5s|%-30s|%-10s|%-10s|%-10s|%4.1f\n",
                          maNV, tenNV, "Quản lý", ngaySinh, dienThoai, tinhLuong());
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
