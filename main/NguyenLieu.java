package main;

import java.io.Serializable;

import KiemTra.KiemTra;

public class NguyenLieu implements Serializable{
    private String maNL;
    private String tenNL;
    private int soLuong;
    private int donGia;
    private String donViTinh;

    public NguyenLieu(){
        maNL = "";
        tenNL = "";
        soLuong = 0;
        donGia = 0;
        donViTinh = "";
    }
    public NguyenLieu(String maNL, String tenNL, int soLuong, int donGia, String donViTinh){
        this.maNL = maNL;
        this.tenNL = tenNL;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donViTinh = donViTinh;
    }
    public void setMaNL(String maNL) {
        this.maNL = maNL;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }
    private void setMaNL(){
        System.out.println("Nhập mã nguyên liệu: ");
        maNL = KiemTra.kiemTraNhapMaNL();
    }
    private void setTenNL(){
        System.out.println("Nhập tên nguyên liệu: ");
        tenNL = KiemTra.kiemTraNhapChuoi();
    }
    private void setSoLuong(){
        System.out.println("Nhập số lượng nguyên liệu: ");
        soLuong = KiemTra.kiemTraSoNguyenDuong();
    }
    private void setDonGia(){
        System.out.println("Nhập đơn giá nguyên liệu: ");
        donGia = KiemTra.kiemTraSoNguyenDuong();
    }
    private void setDonViTinh(){
        System.out.println("Nhập đơn vị tính nguyên liệu: ");
        donViTinh = KiemTra.kiemTraNhapChuoi();
    }
    public String getMaNL(){
        return maNL;
    }
    public String getTenNL(){
        return tenNL;
    }
    public int getSoLuong(){
        return soLuong;
    }
    public int getDonGia(){
        return donGia;
    }
    public String getDonViTinh(){
        return donViTinh;
    }
    public void nhapNguyenLieu(){
        setMaNL();
        setTenNL();
        setSoLuong();
        setDonGia();
        setDonViTinh();
    }

    public void suaNguyenLieu() {
        int opt;
        do {
            System.out.println("Các thao tác: ");
            System.out.println("0. Thoát.");
            System.out.println("1. Sửa mã nguyên liệu.");
            System.out.println("2. Sửa tên nguyên liệu.");
            System.out.println("3. Sửa số lượng của nguyên liệu.");
            System.out.println("4. Sửa đơn giá nguyên liệu.");
            System.out.println("5. Sửa đơn vị tính nguyên liệu.");
            System.out.print("Lựa chọn: ");
            opt = KiemTra.kiemTraNhapSoNguyen();
            switch (opt) {
                case 0:
                    break;
                case 1:
                    setMaNL();
                    break;
                case 2:
                    setTenNL();
                    break;
                case 3:
                    setSoLuong();
                    break;
                case 4:
                    setDonGia();
                    break;
                case 5:
                    setDonViTinh();
                    break;
                default:
                    break;
            }
        } while (opt != 0);
    }

    public void xuatNguyenLieu(){
        System.out.printf("%-10s%-15s%-10s%-10s%-10s\n", getMaNL(), getTenNL(), getSoLuong(), getDonGia(), getDonViTinh());
    }
}
