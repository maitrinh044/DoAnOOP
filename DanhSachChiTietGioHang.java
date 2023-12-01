
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DanhSachChiTietGioHang {
    private static int soluongChiTietGioHang = 0;
    private static ArrayList<ChiTietGioHang> arrCTGioHang;

    public DanhSachChiTietGioHang() {
        soluongChiTietGioHang = 0;
        arrCTGioHang = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("./input/ChiTietGioHang.txt");
            if (fis.available() > 0) {
                docFile(fis);
                fis.close();
            }
            else {
                ChiTietGioHang ct = new ChiTietGioHang("001", "Ga ngu", 2, 50000);
                arrCTGioHang.add(ct);
                ghiFile();
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
                soluongChiTietGioHang++;
            }
            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public static void ghiFile()
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
                if ((i.getMaGioHang()).equals(maGioHang) == true)
                    arr.add(i);
            }
            return arr; 
        }
        else return null;
    }

    public void themCTGioHang(ChiTietGioHang ct)
    {
        arrCTGioHang.add(ct);
        soluongChiTietGioHang++;
    }

    public static void xoaCTGioHang(ChiTietGioHang ct)
    {
        arrCTGioHang.remove(ct);
        soluongChiTietGioHang--;
    }

    public void xuatDSCTGioHang() 
    {
        for (ChiTietGioHang i : arrCTGioHang) {
            i.xuatCTGioHang();
        }
    }

}
