package DanhSach;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import KiemTra.KiemTra;
import main.*;

public class DanhSachCongThuc implements DanhSach {
    private static int soLuong;
    private static CongThuc[] arrCT;

    public DanhSachCongThuc() {

        try {
            FileInputStream fis = new FileInputStream("./input/CongThuc.txt");
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

    private void docFile(FileInputStream fis) {
        try {
            soLuong = 0;
            arrCT = new CongThuc[0];
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                themCongThuc((CongThuc) ois.readObject());
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
            FileOutputStream fos = new FileOutputStream("./input/CongThuc.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < soLuong; i++) {
                oos.writeObject(arrCT[i]);
            }
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void them() {
        // CongThuc a = new CongThuc();
        // a.nhapCongThuc();
        // arrCT = Arrays.copyOf(arrCT, soLuong++);
        // arrCT[soLuong-1] = a;
        System.out.print("Nhập số công thức cần thêm vào: ");
        int n = KiemTra.kiemTraNhapSoNguyen();
        for (int i = 0; i < n; i++) {
            CongThuc a = new CongThuc();
            a.nhapCongThuc();
            themCongThuc(a);
            DanhSachChiTietCongThuc.themNhieuCTCT();
        }
    }

    private void themCongThuc(CongThuc a) {
        arrCT = Arrays.copyOf(arrCT, ++soLuong);
        arrCT[soLuong - 1] = a;
    }

    private void xoaCongThuc(String maCT) {
        if (DanhSachSanPham.timKiemSanPhamTheoMaSP(timKiemCongThuc(maCT).getMaSP()) != null) {
            System.out.println("Sản phẩm đang tồn tại. Không thể xóa công thức.");
            return;
        } else {
            CongThuc[] arr = Arrays.copyOf(arrCT, soLuong);
            arrCT = new CongThuc[soLuong - 1];
            for (int i = 0, j = 0; i < soLuong; i++) {
                if (arrCT[i].getMaCT().equals(maCT) == true) {
                    arrCT[j++] = arr[i];
                }
            }
            System.out.println("Đã xóa công thức.\n");
        }
    }

    @Override
    public void xoa() {
        System.out.print("Nhập mã công thức cần xóa: ");
        String mact = KiemTra.kiemTraNhapChuoi();
        if (DanhSachSanPham.timKiemSanPhamTheoMaSP(timKiemCongThuc(mact).getMaSP()) != null) {
            System.out.println("Sản phẩm đang tồn tại. Không thể xóa công thức.");
            return;
        } else {
            CongThuc[] arr = Arrays.copyOf(arrCT, soLuong);
            arrCT = new CongThuc[soLuong - 1];
            for (int i = 0, j = 0; i < soLuong; i++) {
                if (arrCT[i].getMaCT().equals(mact) == true) {
                    arrCT[j++] = arr[i];
                }
            }
            System.out.println("Đã xóa công thức.\n");
        }
    }

    @Override
    public void sua() {
        System.out.print("Nhập mã công thức hoặc mã sản phẩm muốn sửa: ");
        String input = KiemTra.kiemTraNhapChuoi();
        if (timKiemCongThuc(input) == null) {
            System.out.println("Không tồn tại công thức.");
        } else {
            timKiemCongThuc(input).suaCongThuc();
        }
    }

    private void xuatDSCT() {
        if (soLuong == 0) {
            System.out.println("Danh sách công thức trống!\n");
            return;
        }
        for (int i = 0; i < soLuong; i++) {
            arrCT[i].xuatCongThuc();
        }
    }

    public static CongThuc timKiemCongThuc(String ma) {
        if (soLuong == 0) {
            System.out.println("Không tồn tại công thức.");
        } else {
            for (int i = 0; i < soLuong; i++) {
                if (arrCT[i].getMaCT().equals(ma) == true || arrCT[i].getMaSP().equals(ma) == true) {
                    return arrCT[i];
                }
            }
        }
        return null;
    }

    public void quanLiDS() {
        int opt;
        String input;
        String tieptuc;
        do {
            System.out.println("Các thao tác: ");
            System.out.println("1. Hiển thị danh sách công thức.");
            System.out.println("2. Thêm 1 công thức.");
            System.out.println("3. Xóa 1 công thức. ");
            System.out.println("4. Tìm kiếm công thức.");
            System.out.println("5. Chỉnh sửa công thức.");
            System.out.print("Lựa chọn: ");
            opt = KiemTra.kiemTraNhapSoNguyen();
            switch (opt) {
                case 1:
                    xuatDSCT();
                    break;
                case 2:
                    them();
                    DanhSachChiTietCongThuc.themNhieuCTCT();
                    break;
                case 3:
                    xoa();
                    break;
                case 4:
                    System.out.print("Nhập mã công thức hoặc mã sản phẩm muốn tìm kiếm: ");
                    input = KiemTra.kiemTraNhapChuoi();
                    if (timKiemCongThuc(input) == null) {
                        System.out.println("Không tồn tại công thức.");
                    } else {
                        timKiemCongThuc(input).xuatCongThuc();
                        DanhSachChiTietCongThuc.xuatChiTiet1CT(timKiemCongThuc(input).getMaCT());
                    }
                    break;
                case 5:
                    sua();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Thoát!");
                    break;
            }

            System.out.println("Bạn có muốn tiếp tục các thao tác trên? (y/n)");
            System.out.print("Lựa chọn: ");
            tieptuc = KiemTra.tiepTuc();
        } while (tieptuc.equals("y"));
    }

    private void auto() {
        soLuong = 5;
        arrCT = new CongThuc[soLuong];
        arrCT[0] = new CongThuc("SP001", "CT001");
        arrCT[1] = new CongThuc("SP002", "CT002");
        arrCT[2] = new CongThuc("SP003", "CT003");
        arrCT[3] = new CongThuc("SP004", "CT004");
        arrCT[4] = new CongThuc("SP005", "CT005");
        arrCT[4] = new CongThuc("SP006", "CT006");
        arrCT[4] = new CongThuc("SP007", "CT007");
        arrCT[4] = new CongThuc("SP008", "CT008");
        arrCT[4] = new CongThuc("SP009", "CT009");
        arrCT[4] = new CongThuc("SP010", "CT010");
    }
}
