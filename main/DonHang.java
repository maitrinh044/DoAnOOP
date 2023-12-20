package main;

import KiemTra.KiemTra;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import DanhSach.DanhSachChiTietDonHang;
import DanhSach.DanhSachChiTietGioHang;
import DanhSach.DanhSachDonHang;
import DanhSach.DanhSachSanPham;

public class DonHang implements Serializable {
    private String maDH;
    private Date ngayLapDon;
    private String maNV;
    private String maKH;

    // Constructor
    public DonHang() {
        maDH = String.format("DH%03d", DanhSachDonHang.soDH + 1);
        long millis = System.currentTimeMillis();
        ngayLapDon = new Date(millis);
        maNV = "";
        maKH = "";
    }

    public DonHang(String maNV, String maKH) {
        maDH = String.format("DH%03d", DanhSachDonHang.soDH+1);
        long millis = System.currentTimeMillis();
        ngayLapDon = new Date(millis);
        this.maNV = maNV;
        this.maKH = maKH;
    }

    // Getter - Setter
    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public Date getNgayLapDon() {
        return ngayLapDon;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setMaNV() {
        System.out.print("Nhập mã nhân viên: ");
        maNV = KiemTra.kiemTraNhapMaNV();
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setMaKH() {
        System.out.print("Nhập mã khách hàng: ");
        maKH = KiemTra.kiemTraNhapMaKH();
    }

    // Phương thức tính tổng tiền của 1 đơn hàng
    public int tongTienHoaDon() {
        ArrayList<ChiTietDonHang> dsCTDH = DanhSachChiTietDonHang.timKiemCTDH(maDH);
        int tongTien = 0;
        if (dsCTDH == null) return tongTien;
        for (ChiTietDonHang ctDH : dsCTDH) {
            if (ctDH != null) {
                if (ctDH.getMaDH().equals(maDH)) {
                    tongTien += ctDH.thanhTien();
                }
            }
        }
        return tongTien;
    }

    public int tongTienHoaDon(String maTK) {
        ArrayList<ChiTietGioHang> arrGH = DanhSachChiTietGioHang.timKiemCTGioHang(maTK);
        int tongTien = 0;
        for (ChiTietGioHang ctDH : arrGH) {
            tongTien += ctDH.getDonGia() * ctDH.getSoLuong();
        }
        return tongTien;
    }

    // Phương thức in thông tin đơn hàng
    public void inThongTinDonHang() {
        ArrayList<ChiTietDonHang> arr = DanhSachChiTietDonHang.timKiemCTDH(maDH);
        
        System.out.printf("%-15s%-20s%-10s%-10s%-10s\n",
                maDH, ngayLapDon, maNV, maKH, tongTienHoaDon());
        System.out.println();
        if (arr != null) {
            for (ChiTietDonHang chiTietDonHang : arr) {
                chiTietDonHang.inCTDonHang();
            }
        }
        System.out.println("----------------------------------------------------------------------------------");
    }

    public void inThongTinDonHang(String maTK) {
        ArrayList<ChiTietGioHang> arrGH = DanhSachChiTietGioHang.timKiemCTGioHang(maTK);

        System.out.printf("|%-5s|%-20s|%-5s|%-5s|%-10s\n",
                maDH, ngayLapDon, maNV, maKH, tongTienHoaDon(maTK));
        for (ChiTietGioHang i : arrGH) {
            if (i.getSoLuong()>DanhSachSanPham.timKiemSanPhamTheoMaSP(i.getMaSP()).ktraSoLuong()) {
                System.out.println("Số lượng sản phẩm đặt mua lớn hơn số lượng sản phẩm còn lại. Vui lòng thay đổi số lượng sản phẩm!");
                return;
            }
                ChiTietDonHang ctdh = new ChiTietDonHang(maDH, i.getMaSP(), i.getSoLuong(), "");
                ctdh.inCTDonHang();
        }
    }

    public void nhapThongTinDonHang() {
        setMaNV();
        setMaKH();
        System.out.println();
    }

    public void suaDonHang() {
        int opt;
        do {
            System.out.println("Các thao tác: ");
            System.out.println("0.Thoát.");
            System.out.println("1.Mã nhân viên.");
            System.out.println("2.Mã khách hàng.");
            System.out.print("Lựa chọn: ");
            opt = KiemTra.kiemTraNhapSoNguyen();
            switch (opt) {
                case 0:
                    break;
                case 1:
                    setMaNV();
                    break;
                case 2:
                    setMaKH();
                default:
                    System.out.println("Lựa chọn không hợp lệ. Thoát!");
                    break;
            }
        } while (opt != 0);
    }
}
