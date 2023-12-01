import java.util.Scanner;

public class Quyen {
    private int maQuyen;
    private String tenQuyen;
    Scanner inp = new Scanner(System.in);

    // 0 - Admin
    // 1 - Nhan vien
    // 2 - Khach hang

    public Quyen()
    {
        maQuyen = 2;
        tenQuyen = "";
    }

    public Quyen(int maQuyen, String tenQuyen)
    {
        this.maQuyen = maQuyen;
        this.tenQuyen = tenQuyen;
    }

    public Quyen(Quyen a)
    {
        this.maQuyen = a.maQuyen;
        this.tenQuyen = a.tenQuyen;
    }

    public int getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen()
    {
        System.out.print("Nhap ma quyen: ");
        maQuyen = inp.nextInt();
    }

    public void setMaQuyen(int maQuyen) {
        this.maQuyen = maQuyen;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen()
    {
        System.out.print("Nhap ten quyen: ");
        tenQuyen = inp.nextLine();
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }

    
}
