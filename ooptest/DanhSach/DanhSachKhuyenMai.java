package DanhSach;

import main.*;
import KiemTra.KiemTra;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachKhuyenMai implements QuanLiDS{
    private int soKM;
    private KhuyenMai DS_KhuyenMai[];
    transient Scanner inp = new Scanner(System.in);

    public void ghiFile() {
        try {
            FileOutputStream fos = new FileOutputStream("input/KhuyenMai.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (int i = 0; i < soKM; i++) {
                oos.writeObject(DS_KhuyenMai[i]);
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
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    KhuyenMai a = (KhuyenMai) ois.readObject();
                    themKhuyenMai(a);
                } catch (EOFException e) {
                    // Đã đọc hết file
                    break;
                }
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

    public DanhSachKhuyenMai() {
        soKM = 0;
        DS_KhuyenMai = new KhuyenMai[soKM];
        try {
            FileInputStream fis = new FileInputStream("input/KhuyenMai.txt");
            if (fis.available() > 0) {
                docFile(fis);
            } else {
                soKM = 1;
                DS_KhuyenMai = new KhuyenMai[soKM];
                DS_KhuyenMai[0] = new KhuyenMai("KM001", "SP001", 100000, "2023-12-01", "2023-12-05",
                        "Giảm 100.000VND cho đơn 500.000VND.");
                ghiFile();
            }
            // fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void themKhuyenMai(KhuyenMai tmp) {
        DS_KhuyenMai = Arrays.copyOf(DS_KhuyenMai, soKM + 1);
        DS_KhuyenMai[soKM] = tmp;
        soKM++;
    }

    public void xoaMaKM(String maKM) {
        int newCount = soKM - 1;
        KhuyenMai[] newArr = new KhuyenMai[newCount];
        for (int i = 0, j = 0; i < soKM; i++) {
            if (!maKM.equalsIgnoreCase(DS_KhuyenMai[i].getMaKM())) {
                newArr[j] = DS_KhuyenMai[i];
                j++;
            }
        }
        DS_KhuyenMai = newArr;
        soKM = newCount;
    }

    public void xoaMaKMTheoMASP(String masp) {
        int newCount = soKM - 1;
        KhuyenMai[] newArr = new KhuyenMai[newCount];
        for (int i = 0, j = 0; i < soKM; i++) {
            if (!masp.equalsIgnoreCase(DS_KhuyenMai[i].getMaSP())) {
                newArr[j] = DS_KhuyenMai[i];
                j++;
            }
        }
        DS_KhuyenMai = newArr;
        soKM = newCount;
    }

    public void xoaDanhSachKhuyenMai() {
        int newCount = 0;
        KhuyenMai[] newArr = new KhuyenMai[newCount];
        DS_KhuyenMai = newArr;
        soKM = newCount;
    }

    public void suaMaKM(String makm) {
        String maKM, maSP;
        for (int i = 0; i < soKM; i++) {
            if (DS_KhuyenMai[i].getMaKM().equalsIgnoreCase(makm)) {
                System.out.println("\t\t=====Cập nhật thông tin mã khuyến mãi=====");
                System.out.println("\t\t\t0.Thoát.");
                System.out.println("\t\t\t1.Mã khuyến mãi.");
                System.out.println("\t\t\t2.Mã sản phẩm");
                System.out.println("\t\t\t3.Giá trị mã khuyến mãi.");
                System.out.println("\t\t\t4.Ngày mã khuyến mãi bắt đầu có hiệu lực.");
                System.out.println("\t\t\t5.Ngày mã khuyến mãi hết hiệu lực.");
                System.out.println("\t\t\t6.Mô tả của mã khuyến mãi.");
                int choice;
                do {
                    System.out.print("Nhập lựa chọn của bạn: ");
                    choice = KiemTra.kiemTraNhapSoNguyen();
                    switch (choice) {
                        case 0:
                            System.out.println("Thoát.");
                            break;
                        case 1:
                            System.out.print("Nhập mã khuyến mãi muốn cập nhật: ");
                            maKM = KiemTra.kiemTraNhapMaKM();
                            DS_KhuyenMai[i].setMaKM(maKM);
                            break;
                        case 2:
                            System.out.print("Nhập mã sản phẩm muốn cập nhật: ");
                            maSP = KiemTra.kiemTraNhapMaSP();
                            DS_KhuyenMai[i].setMaSP(maSP);
                            break;
                        case 3:
                            System.out.print("Nhập giá trị mã khuyến mãi muốn cập nhật lại: ");
                            double giatri = KiemTra.kiemTraNhapSoThuc();
                            DS_KhuyenMai[i].setGiaTri(giatri);
                            break;
                        case 4:
                            System.out.print("Nhập ngày mã khuyến mãi có hiệu lực: ");
                            String ngayBatDau = KiemTra.kiemTraNgayThangNam();
                            DS_KhuyenMai[i].setNgayBatDau(ngayBatDau);
                            break;
                        case 5:
                            System.out.print("Nhập ngày mã khuyến mãi hết hiệu lực: ");
                            String ngayketthuc = KiemTra.kiemTraNgayThangNam();
                            DS_KhuyenMai[i].setNgayKetThuc(ngayketthuc);
                            break;
                        case 6:
                            System.out.print("Nhập mô tả muốn cập nhập của mã khuyến mãi: ");
                            String mota = KiemTra.kiemTraNhapChuoi();
                            DS_KhuyenMai[i].setMoTa(mota);
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ. Vui lòng hãy nhập lại lựa chọn.");
                            break;
                    }
                } while (choice != 0);
            } else {
                System.out.println("Không tìm thấy mã khuyến mãi!");
            }
        }
    }

    public void inDanhSach() {
        System.out.println("Danh sách khuyến mãi: ");
        System.out.printf("|%-15s|%-15s|%-10s|%-20s|%-20s|%-40s|\n", "Mã khuyến mãi", "Mã sản phẩm", "Giá trị",
                "Ngày bắt đầu", "Ngày kết thúc", "Mô tả");
        for (int i = 0; i < soKM; i++) {
            DS_KhuyenMai[i].xuatKhuyenMai();
        }
        System.out.println();
    }

    public KhuyenMai timMaKM(String makm) {
        for (int i = 0; i < soKM; i++) {
            if (DS_KhuyenMai[i].getMaKM().equalsIgnoreCase(makm)) {
                return DS_KhuyenMai[i];
            }
        }
        return null;
    }

    // 8.Tìm mã khuyến mãi theo mã sản phẩm.
    public void timMaKMTheoMaSP(String masp) {
        for (int i = 0; i < soKM; i++) {
            if (DS_KhuyenMai[i].getMaSP().equalsIgnoreCase(masp)) {
                DS_KhuyenMai[i].xuatKhuyenMai();
            }
        }
    }

    @Override
    public void quanLiDS() {
        String maKM, maSP;
        System.out.println("\t=====Quản lí danh sách khuyến mãi:=====");
        System.out.println("\t\t0.Thoát.");
        System.out.println("\t\t1.Thêm mã khuyến mãi vào danh sách.");
        System.out.println("\t\t2.Xóa mã khuyến mãi khỏi danh sách.");
        System.out.println("\t\t3.Xóa mã khuyến mãi theo mã sản phẩm.");
        System.out.println("\t\t4.Xóa danh sách khuyến mãi.");
        System.out.println("\t\t5.Sửa thông tin của mã khuyến mãi.");
        System.out.println("\t\t6.In danh sách mã khuyến mãi.");
        System.out.println("\t\t7.Tìm mã khuyến mãi.");
        System.out.println("\t\t8.Tìm mã khuyến mãi theo mã sản phẩm.");
        int choice;
        do {
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = KiemTra.kiemTraNhapSoNguyen();
            switch (choice) {
                case 0:
                    System.out.println("Thoát.");
                    break;
                case 1:
                    KhuyenMai a = new KhuyenMai();
                    a.nhapThongTinKhuyenMai();
                    themKhuyenMai(a);
                    System.out.println("Đã thêm!");
                    ghiFile();
                    break;
                case 2:
                    System.out.print("Nhập mã khuyến mãi cần xóa: ");
                    maKM = KiemTra.kiemTraNhapMaKM();
                    xoaMaKM(maKM);
                    ghiFile();
                    System.out.println("Đã xóa!");
                    break;
                case 3:
                    System.out.print("Nhập mã sản phẩm có trong mã khuyến mãi cần xóa: ");
                    maSP = KiemTra.kiemTraNhapMaSP();
                    xoaMaKMTheoMASP(maSP);
                    System.out.println("Đã xóa!");
                    break;
                case 4:
                    xoaDanhSachKhuyenMai();
                    ghiFile();
                    System.out.println("Đã xóa danh sách mã khuyến mãi.");
                    break;
                case 5:
                    System.out.print("Nhập mã khuyến mãi cần sửa lại thông tin: ");
                    maKM = KiemTra.kiemTraNhapMaKM();
                    suaMaKM(maKM);
                    ghiFile();
                    System.out.println("Đã cập nhật!");
                    break;
                case 6:
                    inDanhSach();
                    break;
                case 7:
                    System.out.print("Nhập mã khuyến mãi cần tìm: ");
                    maKM = KiemTra.kiemTraNhapMaKM();
                    if (timMaKM(maKM) == null) {
                        System.out.println("Không có mã khuyến mãi này!");
                    } else {
                        timMaKM(maKM).xuatKhuyenMai();
                    }
                    break;
                case 8:
                    System.out.print("Nhập mã sản phẩm có trong mã khuyến mãi cần xóa: ");
                    maSP = KiemTra.kiemTraNhapMaSP();
                    timMaKMTheoMaSP(maSP);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại lựa chọn!!!");
                    break;
            }

        } while (choice != 0);
    }
}
