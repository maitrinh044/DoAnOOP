package main;

import java.io.Serializable;

import KiemTra.KiemTra;

public class ThucAn extends SanPham implements Serializable{
    private String loai;


    public ThucAn() {
        super();
        loai = "";
    }

    public ThucAn(String MaSP, String TenSP, int DonGia, String MoTa, int SoLuong, String Loai) {
        super(MaSP, TenSP, DonGia, MoTa, SoLuong);
        this.loai = Loai;
    }

    public ThucAn(ThucAn a) {
        super(a);
        this.loai = a.loai;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai() {
        int opt;
        do {        
            System.out.print("Chọn loại sản phẩm(1. Món Chính - 2. Món Ăn Kèm): ");
            opt = KiemTra.kiemTraNhapSoNguyen();
            if (opt!=1 && opt!=2) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại!");
            }
            else break;
        } while (true);
        if (opt == 1) {
            loai = "Món Chính";
        }
        else {
            loai = "Món Ăn Kèm";
        }
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    @Override
    public void nhapSanPham() {
        super.nhapSanPham();
        setLoai();
    }

    @Override
    public void suaSanPham() {
        int opt;
        do {
            System.out.println("Các thao tác");
            System.out.println("0. Thoát.");
            System.out.println("1. Sửa mã sản phẩm.");
            System.out.println("2. Sửa tên sản phẩm.");
            System.out.println("3. Sửa đơn giá sản phẩm.");
            System.out.println("4. Sửa mô tả sản phẩm.");
            System.out.println("5. Sửa loại sản phẩm.");
            System.out.println("6. Sửa số lượng sản phẩm.");
            System.out.print("Lựa chọn: ");
            opt = KiemTra.kiemTraNhapSoNguyen();
            switch (opt) {
                case 0:
                    break;
                case 1:
                    setMaSP();
                    break;
                case 2:
                    setTenSP();
                    break;
                case 3:
                    setDonGia();
                    break;
                case 4:
                    setMoTa();
                    break;
                case 5:
                    setLoai();
                    break;
                case 6:
                    setSoLuong();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Thoát!");
                    break;
            }
        } while (opt!=0);
    }

    @Override
    public void xuatSanPham() {
        System.out.printf("%-13s%-25s%-9s%-40s%-15s%-6s\n", getMaSP(), getTenSP(), getDonGia(), getMoTa(), getLoai(), getSoLuong());
    }

}
