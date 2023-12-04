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
import java.util.ArrayList;
import java.util.Arrays;

public class DanhSachDonHang implements QuanLiDS {
    public static int soDH;
    private DonHang[] DS_DonHang;

    public DanhSachDonHang() {
        soDH = 0;
        DS_DonHang = new DonHang[soDH];
        try {
            FileInputStream fis = new FileInputStream("./input/DonHang.txt");
            if (fis.available() > 0) {
                docFile(fis);
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

            while (true) {
                try {
                    themDonHang((DonHang) ois.readObject());
                    ghiFile();
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

    public void ghiFile() {
        try {
            FileOutputStream fos = new FileOutputStream("./input/DonHang.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < soDH; i++) {
                oos.writeObject(DS_DonHang[i]);
            }
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Phương thức trả về số lượng đơn hàng

    // Phương thức trả về danh sách đơn hàng
    // private List<DonHang> getDS_DonHang() {
    // return DS_DonHang;
    // }

    // Start: Menu
    @Override
    public void quanLiDS() {
        DonHang tmp;
        DonHang[] arr;
        String madh;
        while (true) {
            System.out.println("==================== QUẢN LÝ DANH SÁCH ĐƠN HÀNG ====================");
            System.out.println("\t\t\t1. Thêm đơn hàng vào danh sách.");
            System.out.println("\t\t\t2. Xem danh sách đơn hàng.");
            System.out.println("\t\t\t3. Tìm kiếm đơn hàng theo mã đơn hàng.");
            System.out.println("\t\t\t4. Tìm kiếm (các) đơn hàng theo mã nhân viên.");
            System.out.println("\t\t\t5. Tìm kiếm (các) đơn hàng theo mã khách hàng.");
            System.out.println("======================================================================");

            System.out.print("Nhập lựa chọn của bạn: ");
            int luaChon = KiemTra.kiemTraSoNguyenDuong();

            switch (luaChon) {
                case 1:
                    themDonHang();
                    ghiFile();
                    break;
                case 2:
                    inDanhSachDonHang();
                    break;
                case 3:
                    System.out.print("Nhập mã đơn hàng: ");
                    madh = KiemTra.kiemTraNhapMaDH();
                    tmp = timKiemDonHangTheoMaDH(madh);
                    if (tmp != null) {
                        tmp.inThongTinDonHang();
                    } else {
                        System.out.println("Không tìm thấy sản phẩm.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã nhân viên: ");
                    String manv = KiemTra.kiemTraNhapMaNV();
                    arr = timKiemDonHangTheoMaNV(manv);
                    if (arr != null) {
                        for (DonHang donHang : arr) {
                            donHang.inThongTinDonHang();
                        }
                    } 
                    else {
                        System.out.println("Không có đơn hàng.");
                    }
                    break;
                case 5:
                    System.out.print("Nhập mã khách hàng: ");
                    String makh = KiemTra.kiemTraNhapMaKH();
                    tmp = timKiemDonHangTheoMaKH(makh);
                    if (tmp != null) {
                        tmp.inThongTinDonHang();
                    } else {
                        System.out.println("Không tìm thấy sản phẩm.");
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
                    break;
            }

            // * Tiếp tục menu?
            System.out.print("\nBạn có muốn tiếp tục với Quản lý Danh sách Đơn hàng không? (y/n): ");
            String tiepTuc = KiemTra.tiepTuc();
            if (tiepTuc.equalsIgnoreCase("n")) {
                System.out.println("Thoát khỏi Quản lý Danh sách Đơn hàng.");
                break;
            }
        }
    }
    // End: Menu

    // 1. Phương thức thêm đơn hàng vào danh sách
    public void themDonHang() {
       DonHang a = new DonHang();
       a.nhapThongTinDonHang();
       DS_DonHang = Arrays.copyOf(DS_DonHang, ++soDH);
       DS_DonHang[soDH-1] = a;
       DanhSachCTDonHang.themNhieuChiTietDonHang(a.getMaDH());
    }

    public void themDonHang(DonHang tmp) {
        DS_DonHang = Arrays.copyOf(DS_DonHang, soDH + 1);
        DS_DonHang[soDH] = tmp;
        soDH++;
    }

    public void themDHOnline(String maTK, String maGH) {
        DonHang a = new DonHang();
        a.setMaKH(maTK);
        a.setMaNV("NV001");
        themDonHang(a);
        ArrayList<ChiTietGioHang> arrGH = DanhSachChiTietGioHang.timKiemCTGioHang(maGH);
        for (ChiTietGioHang i : arrGH) {
            ChiTietDonHang ctdh = new ChiTietDonHang(a.getMaDH(), i.getMaSP(), i.getSoLuong(), "");
            DanhSachCTDonHang.themChiTietDonHang(ctdh);
        }
    }

    // 2. Phương thức in danh sách đơn hàng
    public void inDanhSachDonHang() {
        System.out.println("-------------DANH SÁCH ĐON HÀNG-------------");
        System.out.printf("|%-10s|%-20s|%-10s|%-10s|%-10s|\n",
                "Mã đơn hàng", "Ngày lập đơn", "Mã NV", "Mã KH", "Tổng tiền");
        for (DonHang donHang : DS_DonHang) {
            donHang.inThongTinDonHang();
        }
    }

    // 3. Phương thức tìm kiếm đơn hàng theo mã đơn hàng
    public DonHang timKiemDonHangTheoMaDH(String maDH) {
        for (DonHang donHang : DS_DonHang) {
            if (donHang.getMaDH().equalsIgnoreCase(maDH)) {
                return donHang;
            }
        }
        return null;
    }

    // public DonHang timKiemDonHangTheoMaDH(String madh) {
    // return null;
    // }

    // 4. Phương thức tìm kiếm (các) đơn hàng theo mã nhân viên
    public DonHang[] timKiemDonHangTheoMaNV(String manv) {
        DonHang[] arr = new DonHang[0];
        int c=0;
        for (DonHang donHang : DS_DonHang) {
            if (donHang.getMaNV().equalsIgnoreCase(manv)) {
                c++;
                arr = Arrays.copyOf(arr, c);
                arr[c-1] = donHang;
            }
        }
        if (arr.length > 0) return arr;
        return null;
    }

    // 5. Phương thức tìm kiếm (các) đơn hàng theo mã khách hàng
    public DonHang timKiemDonHangTheoMaKH(String makh) {
        for (DonHang donHang : DS_DonHang) {
            if (donHang.getMaKH().equalsIgnoreCase(makh)) {
                return donHang;
            }
        }
        return null;
    }

    // 6. Phương thức cập nhật thông tin đơn hàng
    public void capNhatThongTinDonHang(String madh) {
        for (DonHang tmp : DS_DonHang) {
            if (tmp.getMaDH().equalsIgnoreCase(madh)) {
                tmp.suaDonHang();
            }
        }
    }

    // 7. Phương thức xóa một đơn hàng khỏi danh sách
    public void xoaMotDonHang(String madh) {
        int newCount = soDH - 1;
        DonHang[] newArr = new DonHang[newCount];
        for (int i = 0, j = 0; i < soDH; i++) {
            if (!DS_DonHang[i].getMaDH().equalsIgnoreCase(madh)) {
                newArr[j] = DS_DonHang[i];
                j++;
            }
        }
        DS_DonHang = newArr;
        soDH = newCount;
    }

    // 8. Phương thức xóa tất cả đơn hàng trong danh sách
    public void xoaTatCaDonHang() {
        DS_DonHang = Arrays.copyOf(DS_DonHang, 0);
        soDH = 0;
    }

    public void tongTien(String madh) {
        for (DonHang tmp : DS_DonHang) {
            if (tmp.getMaDH().equalsIgnoreCase(madh)) {
                System.out.println("Tổng tiền của đơn hàng: " + tmp.tongTienHoaDon());
            }
        }
    }

}