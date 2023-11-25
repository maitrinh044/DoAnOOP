
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;


public class DanhSachTaiKhoan {
    private int soluongTK = 0;
    private TaiKhoan arrTK[];

    public void ghiFile()
    {
        try {
            FileOutputStream fos = new FileOutputStream("input/TaiKhoan.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for (int i=0 ; i<soluongTK; i++)
            {
                oos.writeObject(arrTK[i]);
            }
            
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void docFile(FileInputStream fis)
    {
        try {
            arrTK = new TaiKhoan[0];            
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (fis.available() > 0)
            {
                TaiKhoan a = new TaiKhoan();
                a = (TaiKhoan) ois.readObject();
                themTaiKhoan(a);
            }
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DanhSachTaiKhoan()
    {
        try {
            FileInputStream fis = new FileInputStream("input/TaiKhoan.txt");
            if (fis.available() > 0) {
                docFile(fis);
            }
            else {  
                soluongTK = 1;
                arrTK = new TaiKhoan[1];
                arrTK[0] = new TaiKhoan("000", "000000", 1, 0);
                ghiFile();
            }
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getSoLuongTK()
    {
        return soluongTK;
    }
    
    public void xuatDSTK()
    {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", "Ma Tai Khoan", "Mat khau", "Ngay Tao TK", "Quyen Han", "Tinh Trang TK");
        for (int i=0; i<soluongTK; i++)
        {
            arrTK[i].xuatThongTinTaiKhoan();
        } 
    }

    public void themTaiKhoan(TaiKhoan a)
    {
        arrTK = Arrays.copyOf(arrTK, ++soluongTK);
        arrTK[soluongTK-1]=a;
    }

    public void xoaTaiKhoan(String maTK)
    {
        TaiKhoan[] tmp = Arrays.copyOf(arrTK, soluongTK);
        soluongTK--;
        arrTK = new TaiKhoan[soluongTK];
        for (int i=0, j=0; i<soluongTK; i++)
        {
            if (tmp[i].getMaTK().equals(maTK) == true) {}
            else 
            {
                arrTK[j++] = tmp[i];
            }
        }
    }


    public boolean ktraTaiKhoan(String maTK, String matKhau)
    {
        for (int i=0; i<soluongTK; i++)
        {
            if (((arrTK[i].getMaTK().equals(maTK)) == true) && (((arrTK[i].getMatKhau()).equals(matKhau)) == true))
            return true;
        }
        return false;
    }

}
