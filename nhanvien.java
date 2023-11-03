
import java.util.Scanner;

public class nhanvien {
    private String maNV;
    private String tenNV;
    private NgSinh ngsinh = new NgSinh();
    private String sdt;
    Scanner inp = new Scanner(System.in);

    public nhanvien()
    {
        maNV = "";
        tenNV = "";
        sdt = "";
    }

    public nhanvien(String maNV, String tenNV, NgSinh ngsinh, String sdt) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngsinh = ngsinh;
        this.sdt = sdt;
    }

    public nhanvien(nhanvien a)
    {
        this.maNV = a.maNV;
        this.tenNV = a.tenNV;
        this.ngsinh = a.ngsinh;
        this.sdt = a.sdt;
    }

    public void setMaNV()
    {
        System.out.print("Nhap ma nhan vien: ");
        maNV = inp.nextLine();
    }

    public void setTenNV()
    {
        System.out.print("Nhap ten nhan vien: ");
        tenNV = inp.nextLine();
    }

    public void setNgSinh()
    {
        ngsinh.nhapNgSinh();
    }

    public void setSDT()
    {
        System.out.print("Nhap so dien thoai nhan vien: ");
        sdt = inp.nextLine();
    }
}
