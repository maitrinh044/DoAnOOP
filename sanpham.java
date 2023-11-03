
import java.util.Scanner;

public class sanpham {
    private String maSP;
    private String tenSP;
    private int donGiaSP;
    private static int soluong = 0;
    Scanner inp = new Scanner(System.in);


    public sanpham()
    {
        maSP = "";
        tenSP = "";
        donGiaSP = 0;
        soluong++;
    }

    public sanpham(String maSP, String tenSP, int donGiaSP)
    {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGiaSP = donGiaSP;
        soluong++;
    }

    public sanpham(sanpham a)
    {
        this.maSP = a.maSP;
        this.tenSP = a.tenSP;
        this.donGiaSP = a.donGiaSP;
        soluong++;
    }

    public void setMaSP()
    {
        System.out.print("Nhap ma san pham: ");
        maSP = inp.nextLine();
    }

    public void setTenSP()
    {
        System.out.print("Nhap ma san pham: ");
        tenSP = inp.nextLine();
    }

    public void setDonGiaSP()
    {
        System.out.print("Nhap ma san pham: ");
        donGiaSP = inp.nextInt();
    }

    public void nhapSP()
    {
        setMaSP();
        setTenSP();
        setDonGiaSP();
    }

    
}
