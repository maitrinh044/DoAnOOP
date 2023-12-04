package DanhSach;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import main.*;

public class DanhSachGioHang {
    private static int soLuongGioHang = 0;
    private static GioHang[] arrGioHang;

    public DanhSachGioHang() {

        try {
            FileInputStream fis = new FileInputStream("./input/GioHang.txt");
            if (fis.available() > 0) {
                docFile("./input/GioHang.txt");
                fis.close();
            } else {
                arrGioHang = null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void docFile(String name) {
        try {
            FileInputStream fis = new FileInputStream(name);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                GioHang obj = (GioHang) ois.readObject();
                themGioHang(obj);
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
            FileOutputStream fos = new FileOutputStream("./input/GioHang.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < soLuongGioHang; i++) {
                oos.writeObject(arrGioHang[i]);
            }
            oos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void themGioHang(GioHang a) {
        if (arrGioHang == null) {
            arrGioHang = new GioHang[++soLuongGioHang];
            arrGioHang[0] = a;
        } else {
            arrGioHang = Arrays.copyOf(arrGioHang, ++soLuongGioHang);
            arrGioHang[soLuongGioHang - 1] = a;
        }
    }

    public static GioHang timKiemGioHang(String maGioHang) {
        for (int i = 0; i < soLuongGioHang; i++) {
            if (arrGioHang[i].getMaGioHang().equals(maGioHang) == true) {
                return arrGioHang[i];
            }
        }
        return null;
    }

}
