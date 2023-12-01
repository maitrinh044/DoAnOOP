import java.io.Serializable;
import java.sql.Date;
import java.util.Scanner;

public class TaiKhoan implements Serializable {
    private static final long serialVersionUID = -8300082938577114147L;
    private String maTK;
    private String matKhau;
    private Date ngayTao;
    private int tinhTrangTK;
    private int maQuyen;
    // private KiemTra kiemTra = new KiemTra();
    // transient Scanner inp = new Scanner(System.in);

    public TaiKhoan()
    {
        maTK = "";
        matKhau = "";
        long millis = System.currentTimeMillis();
        ngayTao = new java.sql.Date(millis);
        tinhTrangTK = 1;
        maQuyen = 2;
    }

    public TaiKhoan(String maTK, String matKhau, int tinhTrangTK, int maQuyen)
    {
        this.maTK = maTK;
        this.matKhau = matKhau;
        long millis = System.currentTimeMillis();
        ngayTao = new java.sql.Date(millis);
        this.tinhTrangTK = 1;
        this.maQuyen = maQuyen;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK() {
        DanhSachTaiKhoan a = new DanhSachTaiKhoan();
        do {
            System.out.print("Nhập mã tài khoản: ");
            maTK = KiemTra.kiemTraNhapChuoi();
            if (a.timTaiKhoan(maTK) != null)
            {
                System.out.println("Mã tài khoản đã tồn tại. Vui lòng nhập lại!");
            }
            else break;
        } while (true);
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau() 
    {
        do {
            System.out.print("Nhập mật khẩu: ");
            matKhau = KiemTra.kiemTraNhapChuoi();
            if (matKhau.length() < 6) 
                System.out.println("Mật khẩu ít nhất 6 kí tự!");
        } while (matKhau.length() < 6);
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public int getTinhTrangTK() {
        return tinhTrangTK;
    }

    public void setTinhTrangTK(int st) {
        this.tinhTrangTK = st;
    }

    public String toStringTinhTrangTK()
    {
        if (tinhTrangTK == 0)
            return "Không hoạt động";
        else
            return "Hoạt động";
    }

    public int getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen() {
        do {
            System.out.print("Nhập mã quyền: ");
            maQuyen = KiemTra.kiemTraNhapSoNguyen();
            if (maQuyen == 0 || maQuyen == 1 || maQuyen == 2)
                break;
            else 
                System.out.println("Mã quyền gồm 0, 1 và 2");
        } while (true);
    }

    public void setMaQuyen(int q) {
        maQuyen = q;
    }

    public String toStringMaQuyen()
    {
        if (maQuyen == 0)
            return "Admin";
        else if (maQuyen == 1)
            return "Nhân viên";
        else 
            return "Khách Hàng";
    }

    public void nhapTaiKhoanKH()
    {
        setMaTK();
        setMatKhau();
        setTinhTrangTK(1);
        setMaQuyen(2);
    }

    public void nhapTaiKhoanAd()
    {
        setMaTK();
        setMatKhau();
        setTinhTrangTK(1);
        setMaQuyen();
    }

    public void xuatThongTinTaiKhoan()
    {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", getMaTK(), getMatKhau(), getNgayTao(), toStringMaQuyen(), toStringTinhTrangTK());
    }

    
    
}  
