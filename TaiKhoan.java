import java.sql.Date;
import java.util.Scanner;

public class TaiKhoan {
    private String maTK;
    private String matKhau;
    private Date ngayTao;
    private String tinhTrangTK;
    private int maQuyen;
    Scanner inp = new Scanner(System.in);

    public TaiKhoan()
    {
        maTK = "";
        matKhau = "";
        long millis = System.currentTimeMillis();
        ngayTao = new java.sql.Date(millis);
        tinhTrangTK = "";
        maQuyen = 2;
    }

    public TaiKhoan(String maTK, String matKhau, String tinhTrangTK, int maQuyen)
    {
        this.maTK = maTK;
        this.matKhau = matKhau;
        long millis = System.currentTimeMillis();
        ngayTao = new java.sql.Date(millis);
        this.tinhTrangTK = tinhTrangTK;
        this.maQuyen = maQuyen;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK() {
        System.out.print("Nhap ma tai khoan: ");
        maTK = inp.nextLine();
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau() {
        do {
            System.out.print("Nhap mat khau: ");
            matKhau = inp.nextLine();
            if (matKhau.length() < 6) 
                System.out.println("Mat khau it nhat 6 ki tu!");
        } while (matKhau.length() < 6);
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public String getTinhTrangTK() {
        return tinhTrangTK;
    }

    public void setTinhTrangTK() {
        this.tinhTrangTK = "Da Kich Hoat";
    }

    public int getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen() {
        maQuyen = 0;
    }

    public String toStringMaQuyen()
    {
        if (maQuyen == 0)
            return "Admin";
        else if (maQuyen == 1)
            return "Nhan vien";
        else 
            return "Khach Hang";
    }

    public void nhapTaiKhoan()
    {
        setMaTK();
        setMatKhau();
        setTinhTrangTK();
    }

    public void xuatThongTinTaiKhoan()
    {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", getMaTK(), getMatKhau(), getNgayTao(), toStringMaQuyen(), getTinhTrangTK());
    }


    
}  
