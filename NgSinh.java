import java.util.Scanner;

public class NgSinh {
    private String NgaySinh;
    private String ThangSinh;
    private String NamSinh;
    Scanner inp = new Scanner(System.in);

    public NgSinh()
    {
        this.NgaySinh = "";
        this.ThangSinh = "";
        this.NamSinh = "";
    }

    public NgSinh(String ngaySinh, String thangSinh, String namSinh) {
        NgaySinh = ngaySinh;
        ThangSinh = thangSinh;
        NamSinh = namSinh;
    }

    public NgSinh(NgSinh a)
    {
        this.NgaySinh = a.NgaySinh;
        this.ThangSinh = a.ThangSinh;
        this.NamSinh = a.NamSinh;
    }

    public void setNgaySinh()
    {
        System.out.print("Nhap ngay sinh: ");
        NgaySinh = inp.nextLine();
    }

    public void setThangSinh()
    {
        System.out.print("Nhap thang sinh: ");
        ThangSinh = inp.nextLine();
    }

    public void setNamSinh()
    {
        System.out.print("Nhap nam sinh: ");
        NamSinh = inp.nextLine();
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public String getThangSinh() {
        return ThangSinh;
    }

    public String getNamSinh() {
        return NamSinh;
    }

    public void nhapNgSinh()
    {
        setNgaySinh();
        setThangSinh();
        setNamSinh();
    }

    public String toString()
    {
        return getNgaySinh()+"-"+getThangSinh()+"-"+getNamSinh();
    }
}
