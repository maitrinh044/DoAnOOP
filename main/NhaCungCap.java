package main;

import java.io.Serializable;

import DanhSach.DanhSachNhaCungCap;
import KiemTra.KiemTra;

public class NhaCungCap implements Serializable{
    private String MaNCC;
    private String TenNCC;
    private String DiaChi;

    public NhaCungCap(){
        MaNCC = "";
        TenNCC = "";
        DiaChi = "";
    }
    public NhaCungCap(String MaNCC, String TenNCC, String DiaChi){
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.DiaChi = DiaChi;
    }
    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    private void setMaNCC() {
        do {
            System.out.println("Nhập mã nhà cung cấp: ");
            MaNCC = KiemTra.kiemTraNhapMaNhaCC();
            if (DanhSachNhaCungCap.timKiemNhaCungCap(MaNCC) != null) {
                System.out.println("Mã nhà cung cấp đã tồn tại. Vui lòng nhập lại!");
            }
            else break;
        } while (true);
    }
    private void setTenNCC(){
        System.out.println("Nhập tên nhà cung cấp: ");
        TenNCC = KiemTra.kiemTraNhapChuoi();
    }
    private void setDiaChi(){
        System.out.println("Nhập địa chỉ nhà cung cấp: ");
        DiaChi = KiemTra.kiemTraNhapChuoi();
    }
    public String getMaNCC(){
        return MaNCC;
    }
    public String getTenNCC(){
        return TenNCC;
    }
    public String getDiaChi(){
        return DiaChi;
    }
    public void nhapNhaCungCap(){
        setMaNCC();
        setTenNCC();
        setDiaChi();
    }

    public void suaNhaCungCap() {
        int opt;
        do {
            System.out.println("Các thao tác: ");
            System.out.println("0. Thoát.");
            System.out.println("1. Sửa mã nhà cung cấp.");
            System.out.println("2. Sửa tên nhà cung cấp.");
            System.out.println("3. Sửa địa chỉ nhà cung cấp.");
            opt = KiemTra.kiemTraNhapSoNguyen();
            switch (opt) {
                case 0:
                    break;
                case 1:
                    setMaNCC();
                    break;
                case 2:
                    setTenNCC();
                    break;
                case 3:
                    setDiaChi();
                default:
                    System.out.println("Lựa chọn không hợp lệ. Thoát!");
                    break;
            }
        } while (opt != 0);
    }

    public void xuatNhaCungCap(){
        System.out.printf("%-10s%-50s%-50s\n", getMaNCC(), getTenNCC(), getDiaChi());
    }
}
