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

    public static int getSoLuong(){
        return arrCTPN.size();
    }
    
    public DanhSachChiTietPN() {
        arrCTPN = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("./input/ChiTietPhieuNhap.txt");
            if (fis.available() > 0) {
                docFile(fis);
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
                arrCTPN.add((ChiTietPhieuNhap) ois.readObject());
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

    public static void themNhieuChiTietPN(String maPN) {
        System.out.print("Nhập số lượng chi tiết phiếu nhập cần nhập: ");
        int c = KiemTra.kiemTraSoNguyenDuong();
        for (int i=0; i<c; i++) {
            System.out.println("Nhập phiếu nhập thứ "+c+": ");
            themChiTietPN(maPN);
        }
    }

    public void xuatDS() {
        for (ChiTietPhieuNhap i : arrCTPN) {
            i.xuatChiTietPN();
        }
    }
   
    public static void themChiTietPN(String maPN) {
        ChiTietPhieuNhap a = new ChiTietPhieuNhap();
        a.nhapChiTietPN(maPN);
        arrCTPN.add(a);
    }

    public void themChiTietPN(ChiTietPhieuNhap a){
        arrCTPN.add(a);
    }

    
    public static ArrayList<ChiTietPhieuNhap> timChiTietPhieuNhap(String maPN) {
        ArrayList<ChiTietPhieuNhap> arr = new ArrayList<>();
        for (int i = 0; i < getSoLuong(); i++) {
            if (arrCTPN.get(i).getMaPN().equals(maPN) == true)
                arr.add(arrCTPN.get(i));
        }
        if (arr.size() > 0) {
            return arr;
        }
        else return null;
    }

    public static ChiTietPhieuNhap tim1ChiTietPhieuNhap(String nguyenLieu) {
        if (getSoLuong() == 0) {
            return null;
        }
        else if (DanhSachNguyenLieu.timKiemNguyenLieu(nguyenLieu) == null){
            return null;
        }
        else {
            for (ChiTietPhieuNhap i : arrCTPN) {
                if (i.getMaNL().equals(DanhSachNguyenLieu.timKiemNguyenLieu(nguyenLieu).getMaNL()) == true) {
                    return i;
                }
            }
        }
        return null;
    }


    public static void xuatChiTiet1PN(String maPN) {
        if (timChiTietPhieuNhap(maPN) == null) {
            System.out.println("Phiếu nhập không có chi tiết");
        }
        else {
            System.out.println("Chi tiết: ");
            ArrayList<ChiTietPhieuNhap> arr = timChiTietPhieuNhap(maPN);
            for (ChiTietPhieuNhap i : arr) {
                i.xuatChiTietPN1();
            }
        }
    }

}