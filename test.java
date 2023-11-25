
import java.util.Scanner;

public class test {
    DanhSachTaiKhoan listTaiKhoan = new DanhSachTaiKhoan();
    DanhSachQuyen listQuyen = new DanhSachQuyen();

    Scanner inp = new Scanner(System.in);

    public boolean DangNhap()
    {
        String maTk, matKhau;
        do {
            System.out.print("Nhập mã tài khoản: ");
            maTk = inp.nextLine();
            System.out.print("Nhập mật khẩu: ");
            matKhau = inp.nextLine();
            if (listTaiKhoan.ktraTaiKhoan(maTk,matKhau) == false)
            {
                System.out.println("Mã tài khoản hoặc mật khẩu không chính xác!");
                System.out.println("1. Nhập lại.");
                System.out.println("2. Thoát.");
                System.out.print("Nhập lựa chọn: ");
                int choice = inp.nextInt();
                switch (choice) {
                    case 1: 
                        break;
                    case 2:
                        return false;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                        return false;
                }
                    
            } 
        } while (listTaiKhoan.ktraTaiKhoan(maTk, matKhau) == false);
        return true;
    }

    public void DangKy()
    {
        TaiKhoan a = new TaiKhoan();
        a.nhapTaiKhoan();
        listTaiKhoan.themTaiKhoan(a);
    }

    public void menuKhachHang()
    {
        int opt;

        System.out.println("Cac lua chon: ");
        System.out.println("0. Thoat!");
        System.out.println("1. Tim kiem san pham!");
        System.out.println("2. Xem san pham!");
        System.out.println("3. Dat hang!");
        System.out.println("4. Xem gio hang!");
        System.out.println("5. Cap nhat thong tin!");
        System.out.println("6. Xoa tai khoan!");
        System.out.print("Lua chon cua ban: ");
        opt = inp.nextInt();
        switch (opt) {
            case 0:
                break;
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            case 6:
                
                break;
            default:
                System.out.println("Lua chon khong hop le!");
                break;
        }
    }

    public void menuNhanVien()
    {
        int opt;

        System.out.println("Cac lua chon: ");
        System.out.println("0. Thoat!");
        System.out.println("1. Tim kiem san pham!");
        System.out.println("2. Xem san pham!");
        System.out.println("3. Lap hoa don!");
        System.out.println("4. Xoa hoa don!");
        System.out.println("5. Them san pham!");
        System.out.println("6. Xoa san pham!");
        System.out.println("7. Thay doi thong tin san pham!");
        System.out.println("8. Lap phieu nhap!");
        System.out.println("9. Cap nhat thong tin!");
        System.out.println("10. Xoa tai khoan!");

        System.out.print("Lua chon cua ban: ");
        opt = inp.nextInt();
        switch (opt) {
            case 0:
                break;
            case 1:
                //tim kiem sp theo tên và mã
                break;
            case 2:
                //xem tat ca sp
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            case 6:
                
                break;
            case 7:
                
                break;
            case 8:
                
                break;
            case 9:
                
                break;
            case 10:
                
                break;
            default:
                System.out.println("Lua chon khong hop le!");
                break;
        }
    }

    public void menuAdmin()
    {
        int opt;

        System.out.println("Cac lua chon: ");
        System.out.println("0. Thoat!");
        System.out.println("1. Tim kiem san pham!");
        System.out.println("2. Xem san pham!");
        System.out.println("3. Lap hoa don!");
        System.out.println("4. Xoa hoa don!");
        System.out.println("5. Them san pham!");
        System.out.println("6. Xoa san pham!");
        System.out.println("7. Thay doi thong tin san pham!");
        System.out.println("8. Lap phieu nhap!");
        System.out.println("9. Quan li tai khoan!");
        System.out.println("10. Quan li nhan vien!");
        System.out.println("11. Cap nhat thong tin!");
        System.out.println("12. Xoa tai khoan!");

        System.out.print("Lua chon cua ban: ");
        opt = inp.nextInt();
        switch (opt) {
            case 0:  
                break;
            case 1:  
                
                break;
            case 2:  
                
                break;
            case 3:  
                
                break;
            case 4:  
                
                break;
            case 5:  
                
                break;
            case 6:  
                
                break;
            case 7:  
                
                break;
            case 8:  
                
                break;
            case 9:  
                
                break;
            case 10:  
                
                break;
            case 11:  
                
                break;
            case 12:  
                
                break;
            default:
                break;
        }
    }
    public static void main(String[] args) {
        test abc = new test();
        

        abc.listTaiKhoan.xuatDSTK();
    }
}
