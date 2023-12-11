package DanhSach;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import KiemTra.KiemTra;
import main.*;

public class DanhSachChiTietDonHang {
    private static ArrayList<ChiTietDonHang> arrCTDH;

    public int getSoLuong() {
        return arrCTDH.size();
    }

    public DanhSachChiTietDonHang() {
        arrCTDH = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("./input/ChiTietDonHang.txt");
            if (fis.available() > 0) {
                docFile(fis);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void docFile(FileInputStream fis) {
        try {
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                arrCTDH.add((ChiTietDonHang) ois.readObject());
            }
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void ghiFile() {
        try {
            FileOutputStream fos = new FileOutputStream("./input/ChiTietDonHang.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (ChiTietDonHang chiTietDonHang : arrCTDH) {
                oos.writeObject(chiTietDonHang);
            }
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static void themChiTietDonHang(String maDH) {
        ChiTietDonHang a = new ChiTietDonHang();
        a.setMaDH(maDH);
        a.nhapThongTinCTDH();
        if (arrCTDH == null)
            arrCTDH = new ArrayList<>();
        arrCTDH.add(a);
    }

    protected static void themChiTietDonHang(ChiTietDonHang a) {
        arrCTDH.add(a);
    }

    protected static void themNhieuChiTietDonHang(String maDH) {
        System.out.print("Nhập số lượng chi tiết đơn hàng: ");
        int c = KiemTra.kiemTraSoNguyenDuong();
        for (int i = 0; i < c; i++) {
            ChiTietDonHang ctdh = new ChiTietDonHang();
            ctdh.nhapThongTinCTDH();
            ctdh.setMaDH(maDH);
            themChiTietDonHang(ctdh);
            SanPham a = DanhSachSanPham.timKiemSanPhamTheoMaSP(ctdh.getMaSP());
            if (a != null)
                a.setSoLuong(a.getSoLuong() - ctdh.getSoLuong());
        }
    }

    protected static void themNhieuChiTietDonHang(String maDH, String maTK) {
        ArrayList<ChiTietGioHang> arrGH = DanhSachChiTietGioHang.timKiemCTGioHang(maTK);
        for (ChiTietGioHang i : arrGH) {
            ChiTietDonHang ctdh = new ChiTietDonHang(maDH, i.getMaSP(), i.getSoLuong(), maTK);
            themChiTietDonHang(ctdh);
        }
        for (ChiTietGioHang chiTietGioHang : arrGH) {
            SanPham a = DanhSachSanPham.timKiemSanPhamTheoMaSP(chiTietGioHang.getMaSP());
            if (a != null)
                a.setSoLuong(a.getSoLuong() - chiTietGioHang.getSoLuong());
        }
    }

    public static ArrayList<ChiTietDonHang> timKiemCTDH(String maDH) {
        ArrayList<ChiTietDonHang> arr = new ArrayList<>();
        for (ChiTietDonHang i : arrCTDH) {
            if (i.getMaDH().equalsIgnoreCase(maDH) == true) {
                arr.add(i);
            }
        }
        if (arr.size() > 0)
            return arr;
        return null;
    }

}