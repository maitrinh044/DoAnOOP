import java.util.Arrays;
import java.util.Scanner;

public class DanhSachTaiKhoan {
    private int soluongTK;
    private TaiKhoan arrTK[];
    Scanner inp = new Scanner(System.in);

    public DanhSachTaiKhoan()
    {
        soluongTK = 0;
    }

    public void nhapDSTK()
    {
        System.out.print("Nhap so luong tai khoan: ");
        soluongTK = inp.nextInt();
        arrTK = new TaiKhoan[soluongTK];
        for (int i=0; i<soluongTK; i++)
        {
            arrTK[i] = new TaiKhoan();
            arrTK[i].nhapTaiKhoan();
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
        soluongTK++;
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

    public static void main(String[] args) {
        DanhSachTaiKhoan a = new DanhSachTaiKhoan();
        a.nhapDSTK();
        if (a.ktraTaiKhoan("1", "111111") == true)
            System.out.println("ok");
    }
}
