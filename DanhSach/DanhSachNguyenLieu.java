package DanhSach;

import KiemTra.KiemTra;
import main.NguyenLieu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class DanhSachNguyenLieu implements QuanLiDS, ThongKeSoLuong {
    private static int soLuongNL;
    private static NguyenLieu[] arrNL;

    public int getN() {
        return soLuongNL;
    }

    public DanhSachNguyenLieu() {
        soLuongNL = 0;
        arrNL = new NguyenLieu[0];
        try {
            FileInputStream fis = new FileInputStream("./input/NguyenLieu.txt");
            if (fis.available() > 0) {
                docFile(fis);
                fis.close();
            } else {
                auto();
                ghiFile();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void docFile(FileInputStream fis) {
        try {
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                themNguyenLieu((NguyenLieu) ois.readObject());
            }
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void ghiFile() {
        try {
            FileOutputStream fos = new FileOutputStream("./input/NguyenLieu.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < soLuongNL; i++) {
                oos.writeObject(arrNL[i]);
            }
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void auto() {
        soLuongNL = 10;
        arrNL = new NguyenLieu[soLuongNL];
        arrNL[0] = new NguyenLieu("NL001", "Bánh Mì", 100, 5000, "Cái");
        arrNL[1] = new NguyenLieu("NL002", "Mì Ý", 100, 50000, "Hộp");
        arrNL[2] = new NguyenLieu("NL003", "Bột Mì", 10000, 200, "Gram");
        arrNL[3] = new NguyenLieu("NL004", "Bột Năng", 10000, 200, "Gram");
        arrNL[4] = new NguyenLieu("NL005", "Tôm", 10000, 300, "Gram");
        arrNL[5] = new NguyenLieu("NL006", "Mực", 10000, 400, "Gram");
        arrNL[6] = new NguyenLieu("NL007", "Phô Mai", 10000, 20000, "Gram");
        arrNL[7] = new NguyenLieu("NL008", "Sữa Tươi", 10000, 20000, "ML");
        arrNL[8] = new NguyenLieu("NL009", "Cà Chua", 10000, 40, "Gram");
        arrNL[9] = new NguyenLieu("NL010", "Xúc Xích", 100, 10000, "Cái");
    }

    public void themNhieuNguyenLieu() {
        System.out.print("Nhập số lượng nguyên liệu cần nhập: ");
        int c = KiemTra.kiemTraSoNguyenDuong();
        for (int i = 0; i < c; i++) {
            themNguyenLieu();
        }
    }

    public void xuatDSNL() {
        if (soLuongNL == 0) {
            System.out.println("Danh sách nguyên liệu trống!");
            return;
        }
        System.out.println("DANH SÁCH NGUYÊN LIỆU");
        System.out.printf("%-10s%-15s%-10s%-10s%-10s\n", "Mã NL", "Tên NL", "Số lượng", "Đơn giá", "ĐVT");
        for (int i = 0; i < soLuongNL; i++) {
            arrNL[i].xuatNguyenLieu();
        }
    }

    // thêm 1 nguyên liệu
    public void themNguyenLieu() {
        NguyenLieu a = new NguyenLieu();
        a.nhapNguyenLieu();
        arrNL = Arrays.copyOf(arrNL, ++soLuongNL);
        arrNL[soLuongNL - 1] = a;
    }

    public void themNguyenLieu(NguyenLieu a) {
        arrNL = Arrays.copyOf(arrNL, ++soLuongNL);
        arrNL[soLuongNL - 1] = a;
    }

    // xóa 1 nguyên liệu theo mã nguyên liệu
    public void xoaNguyenLieu(String maNL) {
        NguyenLieu[] arr = Arrays.copyOf(arrNL, soLuongNL);
        arrNL = new NguyenLieu[soLuongNL - 1];
        for (int i = 0, j = 0; i < soLuongNL; i++) {
            if (arr[i].getMaNL().equals(maNL) == false) {
                arrNL[j++] = arr[i];
            }
        }
        soLuongNL--;
    }

    // tìm kiếm 1 nguyên liệu
    public static NguyenLieu timKiemNguyenLieu(String nguyenLieu) {
        if (soLuongNL != 0) {
            for (int i = 0; i < soLuongNL; i++) {
                if (arrNL[i].getMaNL().equals(nguyenLieu) || arrNL[i].getTenNL().equals(nguyenLieu)) {
                    return arrNL[i];
                }
            }
        }
        return null;
    }

    // sửa 1 nguyên liệu theo mã nguyên liệu

    @Override
    public void quanLiDS() {
        int opt;
        String maNL;
        do {
            System.out.println("Các thao tác: ");
            System.out.println("0. Thoát.");
            System.out.println("1. Xem danh sách nguyên liệu.");
            System.out.println("2. Thêm nhiều nguyên liệu.");
            System.out.println("3. Thêm một nguyên liệu.");
            System.out.println("4. Xóa một nguyên liệu.");
            System.out.println("5. Tìm kiếm nguyên liệu.");
            System.out.println("6. Sửa thông tin nguyên liệu.");

            System.out.print("Lựa chọn: ");
            opt = KiemTra.kiemTraNhapSoNguyen();
            switch (opt) {
                case 0:
                    break;
                case 1:
                    xuatDSNL();
                    break;
                case 2:
                    themNhieuNguyenLieu();
                    break;
                case 3:
                    themNguyenLieu();
                    break;
                case 4:
                    System.out.print("Nhập mã nguyên liệu muốn xóa: ");
                    maNL = KiemTra.kiemTraNhapMaNL();
                    if (timKiemNguyenLieu(maNL) == null) {
                        System.out.println("Không tồn tại nguyên liệu. Thoát!");
                        break;
                    }
                    xoaNguyenLieu(maNL);
                    System.out.println("Đã xóa nguyên liệu!");
                    break;
                case 5:
                    System.out.print("Nhập mã nguyên liệu hoặc tên nguyên liệu muốn tìm kiếm");
                    maNL = KiemTra.kiemTraNhapChuoi();
                    if (timKiemNguyenLieu(maNL) == null) {
                        System.out.println("Không tồn tại nguyên liệu.");
                    } else {
                        timKiemNguyenLieu(maNL).xuatNguyenLieu();
                    }
                    break;
                case 6:

                default:
                    break;
            }

        } while (opt != 0);

    }

    @Override
    public long thongKeSoLuong(int opt) {
        long tmp = 0;
        if (opt == 0) {
            tmp = soLuongNL;
        }
        return tmp;
    }
}
