package DanhSach;

import KiemTra.KiemTra;
import main.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DanhSachCTDonHang implements QuanLiDS {
    private static int soLuong;
    private static ChiTietDonHang[] DS_CTDH;

    public DanhSachCTDonHang(int soLuong, ChiTietDonHang[] dS_CTDH) {
        this.soLuong = soLuong;
        DS_CTDH = dS_CTDH;
    }

    public static int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public static ChiTietDonHang[] getDS_CTDH() {
        return DS_CTDH;
    }

    public void setDS_CTDH(ChiTietDonHang[] dS_CTDH) {
        DS_CTDH = dS_CTDH;
    }

    public DanhSachCTDonHang() {
        soLuong = 0;
        DS_CTDH = new ChiTietDonHang[soLuong];
        try {
            FileInputStream fis = new FileInputStream("./input/ChiTietDonHang.txt");
            if (fis.available() > 0) {
                docFile(fis);
            } else {
                soLuong = 1;
                DS_CTDH = new ChiTietDonHang[soLuong];
                DS_CTDH[0] = new ChiTietDonHang("DH001_1", "SP001", 10, "KM001");
                ghiFile();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void docFile(FileInputStream fis) {
        try {
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                try {
                    themDonHang((ChiTietDonHang) ois.readObject());
                    ghiFile();
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void themDonHang(ChiTietDonHang tmp) {
        DS_CTDH = Arrays.copyOf(DS_CTDH, soLuong + 1);
        DS_CTDH[soLuong - 1] = tmp;
        soLuong++;
    }

    public void ghiFile() {
        try {
            FileOutputStream fos = new FileOutputStream("./input/ChiTietDonHang.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < soLuong; i++) {
                oos.writeObject(DS_CTDH[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void quanLiDS() {
        while (true) {
            System.out.println("=============== QUẢN LÝ DANH SÁCH CHI TIẾT ĐƠN HÀNG ===============");
            System.out.println("1. Thêm chi tiết đơn hàng");
            System.out.println("2. In danh sách chi tiết đơn hàng");
            System.out.println("3. Tìm kiếm chi tiết đơn hàng");
            System.out.println("4. Xóa một chi tiết đơn hàng");
            System.out.println("5.In thành tiền của chi tiết đơn hàng");
            System.out.println("===================================================================");
            System.out.print("Nhập lựa chọn của bạn: ");
            int luaChon = KiemTra.kiemTraSoNguyenDuong();

            switch (luaChon) {
                case 1:
                    themDonHang();
                    break;
                case 2:
                    inDanhSachCTDH();
                    break;
                case 3:
                    timKiemCTDH();
                    break;
                case 4:
                    xoaMotCTDH();
                    break;
                case 5:
                    thanhTien();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại!");
            }

            System.out.print("Bạn có muốn tiếp tục Quản lý danh sách chi tiết đơn hàng không? (y/n): ");
            String tiepTuc = KiemTra.tiepTuc();
            if (tiepTuc.equalsIgnoreCase("n")) {
                System.out.println("Thoát khỏi Quản lý danh sách chi tiết đơn hàng...");
                break;
            }
        }
    }

    public static void themDonHang() {
        System.out.print("Nhập số lượng chi tiết đơn hàng cần nhập:");
        int n = KiemTra.kiemTraNhapSoNguyen();
        for (int i = 0; i < n; i++) {
            System.out.println("Chi tiết đơn hàng thứ " + (i + 1));
            ChiTietDonHang tmp = new ChiTietDonHang();
            tmp.nhapThongTinCTDH();
            themDonHang(tmp);
        }
    }

    public void inDanhSachCTDH() {
        for (int i = 0; i < soLuong; i++) {
            DS_CTDH[i].inCTDonHang();
        }
    }

    public static void timKiemCTDH() {
        System.out.print("Nhập mã chi tiết đơn hàng cần tìm: ");
        String madh = KiemTra.kiemTraNhapMaCTDH();
        int check = 0;
        for (ChiTietDonHang tmp : DS_CTDH) {
            if (tmp.getMaCTDH().equalsIgnoreCase(madh)) {
                check = 1;
                tmp.inCTDonHang();
            }
        }
        if (check == 0) {
            System.out.println("Không tìm thấy đơn hàng này.");
        }
    }

    public static void xoaMotCTDH() {
        System.out.print("Nhập mã chi tiết đơn hàng cần xóa: ");
        String madh = KiemTra.kiemTraNhapMaCTDH();
        int newCount = soLuong - 1;
        ChiTietDonHang[] newArr = new ChiTietDonHang[newCount];
        for (int i = 0, j = 0; i < soLuong; i++) {
            if (DS_CTDH[i].getMaCTDH().equals(madh)) {
                newArr[j++] = DS_CTDH[i];
            }
        }
        DS_CTDH = newArr;
        soLuong = newCount;
    }

    public void thanhTien() {
        System.out.print("Nhập mã chi tiết đơn hàng: ");
        String mactdh = KiemTra.kiemTraNhapMaCTDH();
        int i = 0;
        for (ChiTietDonHang tmp : DS_CTDH) {
            if (tmp.getMaCTDH().equals(mactdh)) {
                System.out.println("Tổng tiền của chi tiết đơn hàng này là " + (i + 1));
                i++;
            }
        }
    }
}
