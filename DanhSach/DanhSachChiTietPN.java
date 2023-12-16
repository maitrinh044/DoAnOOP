package DanhSach;

import KiemTra.KiemTra;
import main.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DanhSachChiTietPN {
    private static ArrayList<ChiTietPhieuNhap> arrCTPN;

    protected static int getSoLuong() {
        return arrCTPN.size();
    }

    public DanhSachChiTietPN() {
        arrCTPN = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("./input/ChiTietPhieuNhap.txt");
            if (fis.available() > 0) {
                docFile(fis);
            }
            else {
                auto();
                ghiFile();
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
                arrCTPN.add((ChiTietPhieuNhap) ois.readObject());
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
            FileOutputStream fos = new FileOutputStream("./input/ChiTietPhieuNhap.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (ChiTietPhieuNhap i : arrCTPN) {
                oos.writeObject(i);
            }
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static void themNhieuChiTietPN(String maPN) {
        System.out.print("Nhập số lượng chi tiết phiếu nhập cần nhập: ");
        int c = KiemTra.kiemTraSoNguyenDuong();
        for (int i = 0; i < c; i++) {
            System.out.println("Nhập phiếu nhập thứ " + c + ": ");
            themChiTietPN(maPN);
        }
    }

    protected void xuatDS() {
        if (arrCTPN.size()==0) {
            System.out.println("Danh sách chi tiết phiếu nhập trống!");
        }
        for (ChiTietPhieuNhap i : arrCTPN) {
            i.xuatChiTietPN();
        }
    }

    protected static void themChiTietPN(String maPN) {
        ChiTietPhieuNhap a = new ChiTietPhieuNhap();
        a.nhapChiTietPN(maPN);
        NguyenLieu nl = DanhSachNguyenLieu.timKiemNguyenLieu(a.getMaNL());
        nl.setSoLuong(nl.getSoLuong()+a.getSoLuong());
        nl.setDonGia(a.getDonGia());
        arrCTPN.add(a);
    }

    private void themChiTietPN(ChiTietPhieuNhap a) {
        arrCTPN.add(a);
    }

    protected static ArrayList<ChiTietPhieuNhap> timChiTietPhieuNhap(String maPN) {
        ArrayList<ChiTietPhieuNhap> arr = new ArrayList<>();
        for (int i = 0; i < getSoLuong(); i++) {
            if (arrCTPN.get(i).getMaPN().equals(maPN) == true)
                arr.add(arrCTPN.get(i));
        }
        if (arr.size() > 0) {
            return arr;
        } else
            return null;
    }

    protected static ChiTietPhieuNhap tim1ChiTietPhieuNhap(String nguyenLieu) {
        if (getSoLuong() == 0) {
            return null;
        } else if (DanhSachNguyenLieu.timKiemNguyenLieu(nguyenLieu) == null) {
            return null;
        } else {
            for (ChiTietPhieuNhap i : arrCTPN) {
                if (i.getMaNL().equals(DanhSachNguyenLieu.timKiemNguyenLieu(nguyenLieu).getMaNL()) == true) {
                    return i;
                }
            }
        }
        return null;
    }

    protected static void xuatChiTiet1PN(String maPN) {
        if (timChiTietPhieuNhap(maPN) == null) {
            System.out.println("Phiếu nhập không có chi tiết");
        } else {
            System.out.println("Chi tiết: ");
            System.out.printf("%-10s%-20s%-10s%-10s\n", "Mã NL", "Tên NL", "Số lượng", "Đơn giá");
            ArrayList<ChiTietPhieuNhap> arr = timChiTietPhieuNhap(maPN);
            for (ChiTietPhieuNhap i : arr) {
                i.xuatChiTietPN1();
            }
        }
    }

    public void auto() {
        ChiTietPhieuNhap a = new ChiTietPhieuNhap("PN001", "NL001", 100, 5000);
        arrCTPN.add(a);
         a = new ChiTietPhieuNhap("PN001", "NL002", 100, 5000);
        arrCTPN.add(a);
         a = new ChiTietPhieuNhap("PN001", "NL003", 10000, 200);
        arrCTPN.add(a);
         a = new ChiTietPhieuNhap("PN001", "NL004", 10000, 200);
        arrCTPN.add(a);
         a = new ChiTietPhieuNhap("PN002", "NL005", 10000, 400);
        arrCTPN.add(a);
         a = new ChiTietPhieuNhap("PN003", "NL006", 10000, 500);
        arrCTPN.add(a);
         a = new ChiTietPhieuNhap("PN003", "NL007", 100, 5000);
        arrCTPN.add(a);
         a = new ChiTietPhieuNhap("PN004", "NL008", 10000, 20000);
        arrCTPN.add(a);
         a = new ChiTietPhieuNhap("PN004", "NL009", 10000, 20000);
        arrCTPN.add(a);
         a = new ChiTietPhieuNhap("PN005", "NL010", 10000, 40);
        arrCTPN.add(a);
         a = new ChiTietPhieuNhap("PN005", "NL011", 100, 10000);
        arrCTPN.add(a);
    }

}