package DanhSach;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

import KiemTra.KiemTra;
import main.*;


public class DanhSachTaiKhoan implements QuanLiDS{
    private int soluongTK = 0;
    private TaiKhoan arrTK[];
    transient Scanner inp = new Scanner(System.in);

    public void ghiFile() {
        try {
            FileOutputStream fos = new FileOutputStream("input/TaiKhoan.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (int i = 0; i < soluongTK; i++) {
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

    public void docFile(FileInputStream fis) {
        try {
            arrTK = new TaiKhoan[0];
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (fis.available() > 0) {
                TaiKhoan a = (TaiKhoan) ois.readObject();
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

    public DanhSachTaiKhoan() {
        try {
            FileInputStream fis = new FileInputStream("input/TaiKhoan.txt");
            if (fis.available() > 0) {
                docFile(fis);
            } else {
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

    public int getSoLuongTK() {
        return soluongTK;
    }

    public void xuatDSTK() {
        System.out.println("Danh sách tài khoản");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", "Ma Tai Khoan", "Mat khau", "Ngay Tao TK", "Quyen Han", "Tinh Trang TK");
        for (int i = 0; i < soluongTK; i++) {
            arrTK[i].xuatThongTinTaiKhoan();
        }
        System.out.println();
    }

    public void themTaiKhoan(TaiKhoan a) {
        arrTK = Arrays.copyOf(arrTK, ++soluongTK);
        arrTK[soluongTK - 1] = a;
        GioHang gioHang = new GioHang(a.getMaTK());
        DanhSachGioHang.themGioHang(gioHang);
        DanhSachGioHang.ghiFile();
    }

    public void xoaTaiKhoan(String maTK) {
        TaiKhoan[] tmp = Arrays.copyOf(arrTK, soluongTK);
        arrTK = new TaiKhoan[soluongTK-1];
        for (int i = 0, j = 0; i < soluongTK; i++) {
            if (tmp[i].getMaTK().equals(maTK) == true) {
            } else {
                arrTK[j++] = tmp[i];
            }
        }
        soluongTK--;

    }

    public TaiKhoan timTaiKhoan(String maTK) {
        for (int i = 0; i < soluongTK; i++) {
            if (maTK.equals(arrTK[i].getMaTK()) == true)
                return arrTK[i];
        }
        return null;
    }

    public boolean ktraTaiKhoan(String maTK, String matKhau) {
        for (int i = 0; i < soluongTK; i++) {
            if (((arrTK[i].getMaTK().equals(maTK)) == true) && (((arrTK[i].getMatKhau()).equals(matKhau)) == true))
                return true;
        }
        return false;
    }

    @Override
    public void quanLiDS() {
        String tiepTuc;
        System.out.println("\n");
        do {
            System.out.println("Các thao tác: ");
            System.out.println("0. Thoát.");
            System.out.println("1. Xem danh sách tài khoản.");
            System.out.println("2. Tìm kiếm tài khoản.");
            System.out.println("3. Thêm tài khoản.");
            System.out.println("4. Xóa tài khoản.");
            System.out.println("5. Khóa tài khoản.");
            System.out.println("6. Mở khóa tài khoản.");
            System.out.print("Lựa chọn: ");
            int opt = KiemTra.kiemTraNhapSoNguyen();
            String maTK;

            switch (opt) {
                case 0:
                    break;
                case 1:
                    xuatDSTK();
                    break;
                case 2:
                    System.out.print("Nhập mã tài khoản muốn tìm kiếm: ");
                    maTK = KiemTra.kiemTraNhapChuoi();
                    if (timTaiKhoan(maTK) == null) {
                        System.out.println("Tài khoản không tồn tại.\n");
                        break;
                    } 
                    else 
                        timTaiKhoan(maTK).xuatThongTinTaiKhoan();
                        System.out.println();
                    break;
                case 3:
                    TaiKhoan a = new TaiKhoan();
                    a.nhapTaiKhoanAd();
                    themTaiKhoan(a);
                    System.out.println("Đã thêm tài khoản.\n");
                    ghiFile();
                    
                    break;
                case 4:
                    System.out.print("Nhập mã tài khoản muốn xóa: ");
                    maTK = KiemTra.kiemTraNhapChuoi();
                    if (timTaiKhoan(maTK) == null) {
                        System.out.println("Tài khoản không tồn tại.\n");
                    } 
                    else {
                        System.out.println("Bạn có muốn xóa tài khoản?(1.Có\t2.Không)");
                        int choice;
                        choice = KiemTra.kiemTraNhapSoNguyen();
                        if (choice == 1) {
                            xoaTaiKhoan(maTK);
                            System.out.println("Đã xóa tài khoản.\n");
                            
                        }
                        else if (choice == 2)
                            break;
                        else {
                            System.out.println("Lựa chọn không hợp lệ.");
                            break;
                        }
                    }
                    ghiFile();
                    break;
                case 5:
                    System.out.print("Nhập mã tài khoản muốn khóa: ");
                    maTK = KiemTra.kiemTraNhapChuoi();
                    if (timTaiKhoan(maTK) == null) {
                        System.out.println("Tài khoản không tồn tại.\n");
                    } 
                    else {
                        timTaiKhoan(maTK).setTinhTrangTK(0);
                        System.out.println("Đã khóa tài khoản.\n");
                        ghiFile();
                    }
                    break;
                case 6:
                    System.out.print("Nhập mã tài khoản muốn mở khóa: ");
                    maTK = KiemTra.kiemTraNhapChuoi();
                    if (timTaiKhoan(maTK) == null) {
                        System.out.println("Tài khoản không tồn tại.\n");
                    }
                    else if (timTaiKhoan(maTK).getTinhTrangTK() == 1) {
                        System.out.println("Tài khoản không bị khóa.");
                    }
                    else {
                        timTaiKhoan(maTK).setTinhTrangTK(1);
                        System.out.println("Đã mở khóa tài khoản.\n");
                        ghiFile();
                    }
                default:
                    System.out.println("Lựa chọn không hợp lệ.\n");
                    break;
            }

            System.out.println("Bạn có muốn tiếp tục các thao tác trên? (y/n)");
            System.out.print("Lựa chọn: ");
            tiepTuc = KiemTra.tiepTuc();
        } while (tiepTuc.equals("y"));
    }
}
