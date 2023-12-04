package DanhSach;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import main.*;
import KiemTra.KiemTra;

public class DanhSachPhieuNhap implements QuanLiDS, File {
    private static int soluongPN;
    private static PhieuNhap[] arrPN;

    public DanhSachPhieuNhap() {
        soluongPN = 0;
        arrPN = new PhieuNhap[soluongPN];
        try {
            FileInputStream fis = new FileInputStream("./input/PhieuNhap.txt");
            if (fis.available() > 0) {
                docFile("./input/PhieuNhap.txt");
                fis.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void docFile(String name) {
        try {
            FileInputStream fis = new FileInputStream("./input/PhieuNhap.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                themPhieuNhap((PhieuNhap) ois.readObject());
            }
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ghiFile() {
        try {
            FileOutputStream fos = new FileOutputStream("./input/PhieuNhap.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < soluongPN; i++) {
                oos.writeObject(arrPN[i]);
            }
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void themPhieuNhap(PhieuNhap a) {
        arrPN = Arrays.copyOf(arrPN, ++soluongPN);
        arrPN[soluongPN - 1] = a;
    }

    public PhieuNhap themPhieuNhap() {
        PhieuNhap a = new PhieuNhap();
        a.nhapPhieuNhap();
        arrPN = Arrays.copyOf(arrPN, ++soluongPN);
        arrPN[soluongPN - 1] = a;
        return a;
    }

    public void xoaPhieuNhap(String maPN) {
        PhieuNhap[] arr = Arrays.copyOf(arrPN, soluongPN);
        arrPN = new PhieuNhap[soluongPN - 1];
        for (int i = 0, j = 0; i < soluongPN; i++) {
            if (arrPN[i].getMaPN().equals(maPN) == false) {
                arrPN[j++] = arr[i];
            }
        }
        soluongPN--;
    }

    public void xuatDSPN() {
        if (soluongPN == 0) {
            System.out.println("Danh sách phiếu nhập trống!");
            return;
        }
        System.out.println("DANH SÁCH PHIẾU NHẬP");
        for (int i = 0; i < soluongPN; i++) {
            arrPN[i].xuatPhieuNhap();
        }
    }

    public static PhieuNhap timPhieuNhap(String maPN) {
        for (int i = 0; i < soluongPN; i++) {
            if (arrPN[i].getMaPN().equals(maPN) == true)
                return arrPN[i];
        }
        return null;
    }

    @Override
    public void quanLiDS() {
        String tiepTuc;
        String maPN;
        do {
            System.out.println("Các thao tác: ");
            System.out.println("1. Xuất danh sách phiếu nhập.");
            System.out.println("2. Thêm phiếu nhập.");
            System.out.println("3. Tìm kiếm phiếu nhập.");
            System.out.println("4. Chỉnh sửa phiếu nhập.");
            System.out.print("Lựa chọn: ");
            int opt = KiemTra.kiemTraNhapSoNguyen();
            switch (opt) {
                case 0:
                    break;
                case 1:
                    xuatDSPN();
                    break;
                case 2:

                    DanhSachChiTietPN.themNhieuChiTietPN(themPhieuNhap().getMaPN());
                    break;
                case 3:
                    System.out.print("Nhập mã phiếu nhập muốn tìm kiếm: ");
                    maPN = KiemTra.kiemTraNhapMaPN();
                    if (timPhieuNhap(maPN) == null) {
                        System.out.println("Không tồn tại phiếu nhập!");
                    } else {
                        timPhieuNhap(maPN).xuatPhieuNhap();
                        DanhSachChiTietPN.xuatChiTiet1PN(maPN);
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã phiếu nhập muốn sửa: ");
                    maPN = KiemTra.kiemTraNhapMaPN();
                    if (timPhieuNhap(maPN) == null) {
                        System.out.println("Không tồn tại phiếu nhập!");
                    } else {
                        timPhieuNhap(maPN).suaPhieuNhap();
                    }
                    break;
                default:
                    break;
            }
            ghiFile();
            DanhSachChiTietPN.ghiFile();
            System.out.println("Bạn có muốn tiếp tục các thao tác trên? (y/n)");
            System.out.print("Lựa chọn: ");
            tiepTuc = KiemTra.tiepTuc();
        } while (tiepTuc.equals("y"));
    }

}
