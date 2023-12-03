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

public class DanhSachChiTietCongThuc {
    private static ArrayList<ChiTietCongThuc> arrCTCT;

    public static int getSoLuong() {
        return arrCTCT.size();
    }
    
    public DanhSachChiTietCongThuc() {
        arrCTCT = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("./input/ChiTietCongThuc.txt");
            if (fis.available() > 0) {
                docFile(fis);
                fis.close();
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

    public void docFile(FileInputStream fis) {
        try {
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                arrCTCT.add((ChiTietCongThuc) ois.readObject());
            }
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void ghiFile() {
        try {
            FileOutputStream fos = new FileOutputStream("./input/ChiTietCongThuc.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (ChiTietCongThuc i : arrCTCT) {
                oos.writeObject(i);
            }
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void themNhieuCTCT() {
        System.out.print("Nhập số lượng chi tiết công thức muốn thêm: ");
        int c = KiemTra.kiemTraSoNguyenDuong();
        for (int i=0; i<c; i++) {
            themCTCT();
        }
        System.out.println("Đã thêm toàn bộ chi tiết công thức.\n");
    }

    public static void themCTCT() {
        ChiTietCongThuc a = new ChiTietCongThuc();
        a.nhapCTCT();
        arrCTCT.add(a);
    }

    public void themCTCT(ChiTietCongThuc a) {
        arrCTCT.add(a);
    }

    public void xoaCTCT(String nguyenLieu) {
        if (getSoLuong() == 0) {
            System.out.println("Không tồn tại chi tiết công thức.");
            return;
        }
        else {
            for (ChiTietCongThuc i : arrCTCT) {
                if (i.getMaNL().equals(nguyenLieu) == true || i.toStringMaNL().equals(nguyenLieu) == true)
                    break;
            }
        }
        for (ChiTietCongThuc i : arrCTCT) {
            if (i.getMaNL().equals(nguyenLieu) == true || i.toStringMaNL().equals(nguyenLieu) == true) {
                arrCTCT.remove(i);
                System.out.println("Đã xóa chi tiết công thức.\n");
                return;
            }
        }
        System.out.println("Không tồn tại công thức.\n");
    }

    public static ArrayList<ChiTietCongThuc> timKiemCTCT(String maCT) {
        if (getSoLuong() == 0) {
            return null;
        }
        else {
            ArrayList<ChiTietCongThuc> arr = new ArrayList<>();
            for (ChiTietCongThuc i : arrCTCT) {
                if (i.getMaCT().equals(maCT) == true) {
                    arr.add(i);
                }
            }
            if (arr.size() == 0) return null;
            return arr;
        }
    }

    public static ChiTietCongThuc timkiemCTCT(String nguyenLieu) {
        if (getSoLuong() == 0) {
            return null;
        }
        else {
            for (ChiTietCongThuc i : arrCTCT) {
                if (i.getMaNL().equals(nguyenLieu) == true || i.toStringMaNL().equals(nguyenLieu) == true)
                    return i;
            }
        }
        return null;
    }

    public static void xuatChiTiet1CT(String maCT) {
        if (timKiemCTCT(maCT) == null) {
            System.out.println("Công thức không có chi tiết");
        }
        else {
            ArrayList<ChiTietCongThuc> arr = timKiemCTCT(maCT);
            for (ChiTietCongThuc i : arr) {
                i.xuatCTCT1();
            }
        }
    }

    public void auto() {
        ChiTietCongThuc a = new ChiTietCongThuc("CT001", "NL001", 2);
        arrCTCT.add(a);
        a = new ChiTietCongThuc("CT001", "NL002", 20);
        arrCTCT.add(a);
        a = new ChiTietCongThuc("CT001", "NL002", 20);
        arrCTCT.add(a);
        a = new ChiTietCongThuc("CT001", "NL002", 20);
        arrCTCT.add(a);
        a = new ChiTietCongThuc("CT002", "NL002", 20);
        arrCTCT.add(a);a = new ChiTietCongThuc("CT001", "NL002", 20);
        arrCTCT.add(a);
        a = new ChiTietCongThuc("CT003", "NL001", 3);
        arrCTCT.add(a);
        a = new ChiTietCongThuc("CT004", "NL002", 40);
        arrCTCT.add(a);
        a = new ChiTietCongThuc("CT004", "NL001", 2);
        arrCTCT.add(a);
        a = new ChiTietCongThuc("CT004", "NL004", 20);
        arrCTCT.add(a);
        a = new ChiTietCongThuc("CT005", "NL008", 20);
        arrCTCT.add(a);
    }
}
