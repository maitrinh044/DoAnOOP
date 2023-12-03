package main;

import java.io.Serializable;

public abstract class NhanVien implements Serializable {
    protected String maNV;
    protected String tenNV;
    protected String ngaySinh;
    protected String dienThoai;

    //Constructor
    public NhanVien() {
        maNV = null;
        tenNV = null;
        ngaySinh = null;
        dienThoai = null;
    }

    public NhanVien(String maNV, String tenNV, String ngaySinh, String dienThoai) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.dienThoai = dienThoai;
    }

    //Getter - Setter
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    //Phương thức tính lương
    public abstract String getChucVu();

    public abstract double tinhLuong();

    //Phương thức in hồ sơ nhân viên
    public abstract void inHoSoNhanVien();

    //Phương thức nhập hồ sơ nhân viên
    public abstract void nhapHoSoNhanVien();

    //Ghi thông tin nhân viên vào file
    @Override
    public String toString() {
        return  maNV + "#" + tenNV + "#" + ngaySinh + "#" + dienThoai;
    }
}
