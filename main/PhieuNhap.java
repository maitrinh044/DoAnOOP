package main;

import java.io.Serializable;

import DanhSach.DanhSachNhaCungCap;
import DanhSach.DanhSachPhieuNhap;
import KiemTra.KiemTra;

public class PhieuNhap implements Serializable{
    private String maPN;
    private String maNV;
    private String ngay;
    private String maNCC;

    public PhieuNhap(){
        maPN = "";
        maNV = "";
        ngay = "";
        maNCC = "";
    }
    public PhieuNhap(String maPN, String maNV, String Ngay, String maNCC){
        this.maPN = maPN;
        this.maNV = maNV;
        this.ngay = Ngay;
        this.maNCC = maNCC;
    }
    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setNgay(String Ngay) {
        this.ngay = Ngay;
    }


    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    private void setMaPN(){
        do {
            System.out.print("Nhập mã phiếu nhập: ");
            maPN = KiemTra.kiemTraNhapMaPN();
            if (DanhSachPhieuNhap.timPhieuNhap(maPN) != null) {
                System.out.println("Mã phiếu nhập đã tồn tại. Vui lòng nhập lại!");
            }
            else break;
        } while (true);
    }
    private void setMaNV(){
        System.out.print("Nhập mã nhân viên: ");
        maNV = KiemTra.kiemTraNhapMaNV();
    }
    private void setNgay(){
        System.out.print("Nhập ngày (dd/MM/yyyy): ");
        ngay = KiemTra.kiemTraNgayThangNam();
    }
    private void setMaNCC(){
        do {
            System.out.print("Nhập mã nhà cung cấp: ");
            maNCC = KiemTra.kiemTraNhapMaNhaCC();
            if (DanhSachNhaCungCap.timKiemNhaCungCap(maNCC) == null) {
                System.out.println("Mã nhà cung cấp không tồn tại. Vui lòng nhập lại!");
            }
            else break;
        } while (true);
    }
    public String getMaPN(){
        return maPN;
    }
    public String getMaNV(){
        return maNV;
    }
    public String getNgay(){
        return ngay;
    }
    public String getMaNCC(){
        return maNCC;
    }

    
    public void nhapPhieuNhap(){
        setMaPN();
        setMaNV();
        setNgay();
        setMaNCC();
    }

    public void suaPhieuNhap() {
        int opt;
        do {
            System.out.println("Các thao tác: ");
            System.out.println("0. Thoát.");
            System.out.println("1. Sửa mã phiếu nhập.");
            System.out.println("2 Sửa mã nhân viên.");
            System.out.println("3. Sửa ngày nhập.");
            System.out.println("4. Sửa mã nhà cung cấp.");
            System.out.println("5. Sửa chi tiết các phiếu nhập");
            System.out.print("Lựa chọn: ");
            opt = KiemTra.kiemTraNhapSoNguyen();
            switch (opt) {
                case 0:
                    break;
                case 1:
                    setMaPN();
                    break;
                case 2:
                    setMaNV();
                    break;
                case 3:
                    setNgay();
                    break;
                case 4:
                    setMaNCC();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Thoát!");
                    break;
            }

        } while (opt != 0);
    }
    public void xuatPhieuNhap(){
        System.out.printf("%-10s%-10s%-15s%-10s\n", getMaPN(), getMaNV(), getNgay(), getMaNCC());
    }

    
}
