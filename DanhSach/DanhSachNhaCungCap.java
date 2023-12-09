package DanhSach;

import KiemTra.KiemTra;
import main.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class DanhSachNhaCungCap implements QuanLiDS {
    private static int soLuongNCC;
    private static NhaCungCap[] arrNCC;

    public DanhSachNhaCungCap() {
        soLuongNCC = 0;
        arrNCC = new NhaCungCap[soLuongNCC];
        try {
            FileInputStream fis = new FileInputStream("./input/NhaCungCap.txt");
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
                themNhaCungCap((NhaCungCap) ois.readObject());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void ghiFile() {
        try {
            FileOutputStream fos = new FileOutputStream("./input/NhaCungCap.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < soLuongNCC; i++) {
                oos.writeObject(arrNCC[i]);
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
        System.out.print("Nhập số lượng nhà cung cấp cần thêm: ");
        int c = KiemTra.kiemTraSoNguyenDuong();
        for (int i = 0; i < c; i++) {
            themNhaCungCap();
        }
    }

    @Override
    public void xoa() {
        System.out.print("Nhập mã nhà cung cấp cần xóa: ");
        String maNCC = KiemTra.kiemTraNhapMaNhaCC();
        if (soLuongNCC == 0) {
            System.out.println("Danh sách nhà cung cấp rỗng!");
        } else if (timKiemNhaCungCap(maNCC) == null) {
            System.out.println("Không tìm thấy nhà cung cấp.");
        } else {
            NhaCungCap[] arr = Arrays.copyOf(arrNCC, soLuongNCC);
            arrNCC = new NhaCungCap[soLuongNCC - 1];
            for (int i = 0, j = 0; i < soLuongNCC; i++) {
                if (arrNCC[i].getMaNCC().equals(maNCC) == false) {
                    arrNCC[j] = arr[i];
                    j++;
                }
            }
            soLuongNCC--;
            System.out.println("Đã xóa nhà cung cấp!");

        }
    }

    @Override
    public void sua() {
        System.out.print("Nhập mã hoặc tên nhà cung cấp muốn chỉnh sửa: ");
        String maNCC = KiemTra.kiemTraNhapChuoi();
        if (timKiemNhaCungCap(maNCC) == null) {
            System.out.println("Không tồn tại nhà cung cấp!");
        } else {
            timKiemNhaCungCap(maNCC).suaNhaCungCap();
        }
    }

    public void xuatDSNCC() {
        if (soLuongNCC == 0) {
            System.out.println("Danh sách nhà cung cấp trống!");
            return;
        }
        System.out.println("DANH SÁCH NHÀ CUNG CẤP");
        System.out.printf("%-10s%-50s%-50s\n", "Mã NCC", "Tên NCC", "Địa Chỉ");
        for (int i = 0; i < soLuongNCC; i++) {
            arrNCC[i].xuatNhaCungCap();
        }
    }

    public void themNhaCungCap() {
        NhaCungCap a = new NhaCungCap();
        a.nhapNhaCungCap();
        arrNCC = Arrays.copyOf(arrNCC, ++soLuongNCC);
        arrNCC[soLuongNCC - 1] = a;
    }

    public void themNhaCungCap(NhaCungCap a) {
        arrNCC = Arrays.copyOf(arrNCC, ++soLuongNCC);
        arrNCC[soLuongNCC - 1] = a;
    }

    // public void xoaNhaCungCap(String maNCC) {
    // if (soLuongNCC == 0) {
    // System.out.println("Nhà cung cấp không tồn tại!");
    // return;
    // } else {
    // NhaCungCap[] arr = Arrays.copyOf(arrNCC, soLuongNCC);
    // arrNCC = new NhaCungCap[soLuongNCC - 1];
    // for (int i = 0, j = 0; i < soLuongNCC; i++) {
    // if (arrNCC[i].getMaNCC().equals(maNCC) == false) {
    // arrNCC[j] = arr[i];
    // }
    // }
    // soLuongNCC--;
    // }
    // }

    public static NhaCungCap timKiemNhaCungCap(String maNCC) {
        if (soLuongNCC == 0)
            return null;
        for (int i = 0; i < soLuongNCC; i++) {
            if (arrNCC[i].getMaNCC().equals(maNCC) == true || arrNCC[i].getTenNCC().equals(maNCC)) {
                return arrNCC[i];
            }
        }
        return null;
    }

    public void quanLiDS() {
        int opt;
        String tiepTuc;
        String maNCC;
        do {
            System.out.println("Các thao tác: ");
            System.out.println("0.Thoát.");
            System.out.println("1. Xuất danh sách nhà cung cấp.");
            System.out.println("2. Thêm nhiều nhà cung cấp.");
            System.out.println("3. Thêm một nhà cung cấp.");
            System.out.println("4. Xóa một nhà cung cấp.");
            System.out.println("5. Tìm kiếm nhà cung cấp.");
            System.out.println("6. Chỉnh sửa nhà cung cấp.");
            System.out.print("Lựa chọn: ");
            opt = KiemTra.kiemTraNhapSoNguyen();

            switch (opt) {
                case 1:
                    xuatDSNCC();
                    break;
                case 2:
                    them();
                    break;
                case 3:
                    themNhaCungCap();
                    break;
                case 4:
                    xoa();
                    break;
                case 5:
                    System.out.print("Nhập mã hoặc tên nhà cung cấp muốn tìm kiếm: ");
                    maNCC = KiemTra.kiemTraNhapChuoi();
                    if (timKiemNhaCungCap(maNCC) == null) {
                        System.out.println("Không tồn tại nhà cung cấp!");
                    } else {
                        timKiemNhaCungCap(maNCC).xuatNhaCungCap();
                    }
                    break;
                case 6:
                    sua();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại!");
                    break;
            }
            System.out.println("Bạn có muốn tiếp tục các thao tác trên? (y/n)");
            System.out.print("Lựa chọn: ");
            tiepTuc = KiemTra.tiepTuc();
        } while (tiepTuc.equals("y"));

    }

    public void auto() {
        soLuongNCC = 10;
        arrNCC = new NhaCungCap[soLuongNCC];
        arrNCC[0] = new NhaCungCap("NCC001", "Nhà cung cấp thịt gà tươi", "292, QL50, Phường 6, Quận 8, TPHCM");
        arrNCC[1] = new NhaCungCap("NCC002", "Nhà cung cấp thịt bò tươi", "133, Số 30, Phường 6, Gò Vấp, TPHCM");
        arrNCC[2] = new NhaCungCap("NCC003", "Nhà cung cấp bánh mì", "6, Lê Văn Lương, Tân Phong, Quận 7, TPHCM");
        arrNCC[3] = new NhaCungCap("NCC004", "Nhà cung cấp sợi mì Spaghetti", "42 Vĩnh Hội, Phường 4, Quận 4, TPHCM");
        arrNCC[4] = new NhaCungCap("NCC005", "Nhà cung cấp rau củ", "Số 93 Trần Não, Phường Bình An, Quận 2, TPHCM");
        arrNCC[5] = new NhaCungCap("NCC006", "Nhà cung cấp hải sản", "268 Đỗ Xuân Hợp, Quận 9, TPHCM");
        arrNCC[6] = new NhaCungCap("NCC007", "Nhà cung cấp bách hóa xanh (cung cấp gia vị)",
                "286 Trần Hưng Đạo, Phường 11, Quận 5, TPHCM");
        arrNCC[7] = new NhaCungCap("NCC008", "Nhà cung cấp phô mai", "620 Sư Vạn Hạnh, Phường 10, Quận 10, TPHCM");
        arrNCC[8] = new NhaCungCap("NCC009", "Nhà cung cấp nước tinh khiết",
                "Số 48 Nguyễn Thị Huỳnh, P. 11, Q. Phú Nhuận, TPHCM");
        arrNCC[9] = new NhaCungCap("NCC010", "Nhà cung cấp nước giải khát",
                "Số 48 Nguyễn Thị Huỳnh, P. 11, Q. Phú Nhuận, TPHCM");
    }
}