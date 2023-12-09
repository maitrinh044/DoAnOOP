package main;

import KiemTra.KiemTra;

import java.io.Serializable;

public class KhuyenMai implements Serializable {
    private String maKM;
    private String maSP;
    private double giaTri;
    private String ngayBatDau;
    private String ngayKetThuc;
    private String moTa;

    public KhuyenMai() {
        maKM = "";
        maSP = "";
        giaTri = 0;
        ngayBatDau = null;
        ngayKetThuc = null;
        moTa = "";
    }

    public KhuyenMai(String maKM, String maSP, double giaTri, String ngayBatDau, String ngayKetThuc, String moTa) {
        this.maKM = maKM;
        this.maSP = maSP;
        this.giaTri = giaTri;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.moTa = moTa;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public double getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(double giaTri) {
        this.giaTri = giaTri;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void nhapThongTinKhuyenMai() {
        System.out.print("Nhập mã khuyến mãi: ");
        maKM = KiemTra.kiemTraNhapMaKM();
        System.out.print("Nhập mã sản phẩm: ");
        maSP = KiemTra.kiemTraNhapMaSP();
        System.out.print("Nhập giá trị của mã khuyến mãi: ");
        giaTri = KiemTra.kiemTraNhapSoThuc();
        System.out.print("Nhập ngày mà mã khuyến mãi có hiệu lực: ");
        ngayBatDau = KiemTra.kiemTraNgayThangNam();
        System.out.print("Nhập ngày mà mã khuyến mãi hết hiệu lực: ");
        ngayKetThuc = KiemTra.kiemTraNgayThangNam();

        System.out.print("Nhập mô tả của mã khuyến mãi: ");
        moTa = KiemTra.kiemTraNhapChuoi();
        System.out.println();
    }

    public void xuatKhuyenMai() {
        System.out.printf("|%-15s|%-15s|%-10s|%-20s|%-20s|%-40s|\n", getMaKM(), getMaSP(), getGiaTri(),
                getNgayBatDau(), getNgayKetThuc(), getMoTa());
        System.out.println();
    }

    public void suaMaKM() {

    }

    public static void main(String[] args) {
        // KhuyenMai km = new KhuyenMai();
        // km.nhapThongTinKhuyenMai();
        // km.xuatKhuyenMai();
        KhuyenMai[] list = new KhuyenMai[2];
        list[0] = new KhuyenMai("KM001", "SP001", 100000, "01/11/2923", "20/11/2023",
                "Giảm 100.000VND cho đơn 500.000VND.");
        list[1] = new KhuyenMai("KM002", "SP002", 200000, "2/12/2023", "4/12/2023",
                "SDGFSDFGSDF");
        for (int i = 0; i < 2; i++) {
            list[i].xuatKhuyenMai();
        }
    }

}
