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

public class DanhSachChiTietGioHang {
    private static ArrayList<ChiTietGioHang> arrCTGioHang;

    public static int getSoLuong() {
        return arrCTGioHang.size();
    }

    public DanhSachChiTietGioHang() {
        // soluongChiTietGioHang = 0;
        arrCTGioHang = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("./input/ChiTietGioHang.txt");
            if (fis.available() > 0) {
                docFile(fis);
                fis.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public void docFile(FileInputStream fis)
    {
        try {
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                ChiTietGioHang obj = (ChiTietGioHang) ois.readObject();
                arrCTGioHang.add(obj);
            }
            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public void ghiFile()
    {
        try {
            FileOutputStream fos = new FileOutputStream("./input/ChiTietGioHang.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (ChiTietGioHang i: arrCTGioHang) {
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

    public static ArrayList<ChiTietGioHang> timKiemCTGioHang(String maGioHang)
    {
        if (arrCTGioHang != null) {
            ArrayList<ChiTietGioHang> arr = new ArrayList<>();
            for (ChiTietGioHang i : arrCTGioHang) {
                if ((i.getMaGioHang()).equalsIgnoreCase(maGioHang) == true)
                    arr.add(i);
            }
            if (arr.size() > 0) {
                return arr;
            }
            else return null;
        }
        else return null;
    }

    public ChiTietGioHang timKiemChiTietGioHangTheoMaSPMaGH(String maGH, String maSP) {
        for (ChiTietGioHang i : arrCTGioHang) {
                if ((i.getMaGioHang()).equalsIgnoreCase(maGH) == true && i.getMaSP().equals(maSP) == true)
                    return i;
            }
        return null;
    }

    public void themCTGioHang(ChiTietGioHang ct)
    {
        arrCTGioHang.add(ct);
    }

    public void themCTGioHang(String maGH, String maSP)
    {
        if (timKiemChiTietGioHangTheoMaSPMaGH(maGH, maSP)!=null) {
            System.out.print("Nhập số lượng: ");
            int c = KiemTra.kiemTraSoNguyenDuong();
            timKiemChiTietGioHangTheoMaSPMaGH(maGH, maSP).setSoLuong(timKiemChiTietGioHangTheoMaSPMaGH(maGH, maSP).getSoLuong()+c);
        }
        else {
        ChiTietGioHang ct = new ChiTietGioHang(maGH, maSP, 0, DanhSachSanPham.timKiemSanPhamTheoMaSP(maSP).getDonGia());
        ct.setSoLuong();

        arrCTGioHang.add(ct);
        }
    }

    public static void xoaCTGioHang(ChiTietGioHang ct)
    {
        arrCTGioHang.remove(ct);
    }

    public void xuatDSCTGioHang() 
    {
        for (ChiTietGioHang i : arrCTGioHang) {
            i.xuatCTGioHang();
        }
    }

}
