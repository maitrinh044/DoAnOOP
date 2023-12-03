package main;

import java.io.Serializable;

import KiemTra.KiemTra;

public class ThucUong extends SanPham implements Serializable {
    private String kichCo;
    // private static final long serialVersionUID = 8209856435715024643L;
    public ThucUong() {
        super();
        kichCo = "";
    }

    public ThucUong(String MaSP, String TenSP, int DonGia, String MoTa, int SoLuong, String KichCo) {
        super(MaSP, TenSP, DonGia, MoTa, SoLuong);
        kichCo = KichCo;
    }

    public ThucUong(ThucUong a) {
        super(a);
        this.kichCo = a.kichCo;
    }
    
    public String getKichCo() {
        return kichCo;
    }

    public void setKichCo() {
        int opt;
        do {
            System.out.print("Nhập kích cỡ của sản phẩm(1. Nhỏ - 2. Lớn): ");
            opt = KiemTra.kiemTraNhapSoNguyen();
            if (opt !=1 && opt!=2) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại!");
            }
            else break;
        } while (true);
        if (opt == 1) {
            kichCo = "Nhỏ";
        }
        else {
            kichCo = "Lớn";

        }
    }
    @Override
    public void nhapSanPham() {
        super.nhapSanPham();
        setKichCo();
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
            System.out.println("5. Sửa kích cỡ sản phẩm.");
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
                    setKichCo();
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
        System.out.printf("%-13s%-25s%-9s%-40s%-15s%-6s\n", getMaSP(), getTenSP(), getDonGia(), getMoTa(),getKichCo(), getSoLuong());
    }

}
