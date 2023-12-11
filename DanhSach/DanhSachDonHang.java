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
import java.sql.Date;

public class DanhSachDonHang {
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
            fis.close();
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
                    // ((DonHang) ois.readObject()).inThongTinDonHang();
                    themDonHang((DonHang) ois.readObject());
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

    // 1. Phương thức thêm đơn hàng
    public void them() {
        System.out.println("Nhập đơn hàng cần thêm: ");
        DonHang a = new DonHang();
        a.nhapThongTinDonHang();
        themDonHang(a);
        DanhSachChiTietDonHang.themNhieuChiTietDonHang(a.getMaDH());
    }

    private void themDonHang(DonHang tmp) {
        DS_DonHang = Arrays.copyOf(DS_DonHang, soDH + 1);
        DS_DonHang[soDH] = tmp;
        soDH++;
    }

    public DonHang themDHOnline(String maTK) {
        DonHang a = new DonHang();
        a.setMaKH(maTK);
        a.setMaNV("NV001");
        themDonHang(a);
        DanhSachChiTietDonHang.themNhieuChiTietDonHang(a.getMaDH(), maTK);

        return a;
    }

    // 2. Phương thức in danh sách đơn hàng

    private void inDanhSachDonHang() {
        if (DS_DonHang.length == 0) {
            System.out.println("Danh sách đơn hàng trống!");
            return;
        }
        System.out.println("-------------DANH SÁCH ĐON HÀNG-------------");
        System.out.printf("%-15s%-20s%-10s%-10s%-10s\n\n",
                "Mã đơn hàng", "Ngày lập đơn", "Mã NV", "Mã KH", "Tổng tiền");
        for (DonHang donHang : DS_DonHang) {
            if (donHang != null)
                donHang.inThongTinDonHang();
        }
    }

    // 3. Phương thức tìm kiếm đơn hàng theo mã đơn hàng
    private DonHang timKiemDonHangTheoMaDH(String maDH) {
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
    private DonHang[] timKiemDonHangTheoMaNV(String manv) {
        DonHang[] arr = new DonHang[0];
        int c = 0;
        for (DonHang donHang : DS_DonHang) {
            if (donHang.getMaNV().equalsIgnoreCase(manv)) {
                c++;
                arr = Arrays.copyOf(arr, c);
                arr[c - 1] = donHang;
            }
        }
        if (arr.length > 0)
            return arr;
        return null;
    }

    // 5. Phương thức tìm kiếm (các) đơn hàng theo mã khách hàng
    private DonHang[] timKiemDonHangTheoMaKH(String makh) {
        DonHang[] arr = new DonHang[0];
        int c = 0;
        for (DonHang donHang : DS_DonHang) {
            if (donHang.getMaKH().equalsIgnoreCase(makh)) {
                c++;
                arr = new DonHang[c];
                arr[c - 1] = donHang;
            }
        }
        if (arr.length > 0)
            return arr;
        return null;
    }

    // // 6. Phương thức cập nhật thông tin đơn hàng
    // public void capNhatThongTinDonHang(String madh) {
    // for (DonHang tmp : DS_DonHang) {
    // if (tmp.getMaDH().equalsIgnoreCase(madh)) {
    // tmp.suaDonHang();
    // }
    // }
    // }

    // // 7. Phương thức xóa một đơn hàng khỏi danh sách
    // public void xoaMotDonHang(String madh) {
    // int newCount = soDH - 1;
    // DonHang[] newArr = new DonHang[newCount];
    // for (int i = 0, j = 0; i < soDH; i++) {
    // if (!DS_DonHang[i].getMaDH().equalsIgnoreCase(madh)) {
    // newArr[j] = DS_DonHang[i];
    // j++;
    // }
    // }
    // DS_DonHang = newArr;
    // soDH = newCount;
    // }

    // // 8. Phương thức xóa tất cả đơn hàng trong danh sách
    // public void xoaTatCaDonHang() {
    // DS_DonHang = Arrays.copyOf(DS_DonHang, 0);
    // soDH = 0;
    // }

    private long thongKeTongDoanhThu() {
        long s=0;
        for (DonHang donHang : DS_DonHang) {
            if (donHang!=null) s += donHang.tongTienHoaDon();
        }
        return s;
    }

    private long thongKeDoanhThuTheoNgay(Date ngay) {
        long s=0;
        for (DonHang donHang : DS_DonHang) {
            if (donHang != null) {
                if (donHang.getNgayLapDon().getDate() == ngay.getDate()) 
                    s += donHang.tongTienHoaDon();
            }
        }
        return s;
    }

    private long thongKeDoanhThuTheoThang(String thang, String nam) {
        long s=0;
        for (DonHang donHang : DS_DonHang) {
            if (donHang != null) {
                System.out.println(donHang.getNgayLapDon().getMonth()+1);
                if (((donHang.getNgayLapDon().getMonth()+1) == Integer.parseInt(thang)) && (donHang.getNgayLapDon().getYear()+1900 == Integer.parseInt(nam))) {
                    s += donHang.tongTienHoaDon();
                }
            }
        }
        return s;
    }

    private long thongKeDoanhThuTheoNam(String nam) {
        long s=0;
        for (DonHang donHang : DS_DonHang) {
            if (donHang != null) {
                if (donHang.getNgayLapDon().getYear()+1900 == Integer.parseInt(nam)) {
                    s += donHang.tongTienHoaDon();
                }
            }
        }
        return s;
    }

    private long thongKeDoanhThuTheoThucAn() {
        long s=0;
        for (DonHang donHang : DS_DonHang) {
            if (donHang!=null) {
                ArrayList<ChiTietDonHang> arr = DanhSachChiTietDonHang.timKiemCTDH(donHang.getMaDH());
                for (ChiTietDonHang chiTietDonHang : arr) {
                    SanPham a = DanhSachSanPham.timKiemSanPhamTheoMaSP(chiTietDonHang.getMaSP());
                    if (a != null) {
                        if (a instanceof ThucAn) {
                            s += chiTietDonHang.thanhTien();
                        }
                    }
                }
            }
        }
        return s;
    }

    private long thongKeDoanhThuTheoThucUong() {
        long s=0;
        for (DonHang donHang : DS_DonHang) {
            if (donHang!=null) {
                ArrayList<ChiTietDonHang> arr = DanhSachChiTietDonHang.timKiemCTDH(donHang.getMaDH());
                for (ChiTietDonHang chiTietDonHang : arr) {
                    SanPham a = DanhSachSanPham.timKiemSanPhamTheoMaSP(chiTietDonHang.getMaSP());
                    if (a != null) {
                        if (a instanceof ThucUong) {
                            s += chiTietDonHang.thanhTien();
                        }
                    }
                }
            }
        }
        return s;
    }

    private long thongKeDoanhThuTheoSanPham(SanPham a) {
        long s=0;
        for (DonHang donHang : DS_DonHang) {
            if (donHang!=null) {
                ArrayList<ChiTietDonHang> arr = DanhSachChiTietDonHang.timKiemCTDH(donHang.getMaDH());
                for (ChiTietDonHang chiTietDonHang : arr) {
                    if (chiTietDonHang.getMaSP().equals(a.getMaSP()) == true) {
                        s += chiTietDonHang.thanhTien();
                    }
                }
            }
        }
        return s;
    }

    public void thongKeDoanhThu() {
        int opt;
        String tiepTuc, input, input1;
        do {
            System.out.println("Các thao tác: ");
            System.out.println("1. Thống kê tổng doanh thu.");
            System.out.println("2. Thống kê tổng doanh thu theo ngày.");
            System.out.println("3. Thống kê tổng doanh thu theo tháng.");
            System.out.println("4. Thống kê tổng doanh thu theo năm.");
            System.out.println("5. Thống kê tổng doanh thu theo loại sản phẩm(thức ăn/thức uống).");
            System.out.println("6. Thống kê tổng doanh thu theo từng sản phẩm.");
            System.out.print("Lựa chọn: ");
            opt = KiemTra.kiemTraNhapSoNguyen();
            System.out.println();

            switch (opt) {
                case 1:
                    System.out.println("Tổng doanh thu: "+thongKeTongDoanhThu());
                    break;
                case 2: 
                    System.out.print("Nhập ngày muốn thống kê: (dd/mm/yyyy)");
                    Date ngay = KiemTra.sqlDate();
                    System.out.println("Tổng doanh thu trong ngày "+ngay+": "+thongKeDoanhThuTheoNgay(ngay));
                    break;
                case 3:
                    System.out.print("Nhập tháng muốn thống kê: ");
                    input = KiemTra.kiemTraNhapThang();
                    System.out.print("Nhập năm của tháng muốn thống kê: ");
                    input1 = KiemTra.kiemTraNhapNam();
                    System.out.println("Doanh thu theo tháng "+input+"-"+input1+": "+thongKeDoanhThuTheoThang(input, input1));
                    break;
                case 4:
                    System.out.print("Nhập năm: ");
                    input = KiemTra.kiemTraNhapChuoi();
                    System.out.println("Doanh thu theo năm "+input+": "+thongKeDoanhThuTheoNam(input));
                    break;
                case 5:
                    System.out.println("Chọn loại sản phẩm: (1. Thức ăn - 2. Thức uống)");
                    opt = KiemTra.kiemTraNhapSoNguyen();
                    if (opt == 1) {
                        System.out.println("Tổng doanh thu thức ăn: "+thongKeDoanhThuTheoThucAn());
                    }
                    else if (opt == 2) {
                        System.out.println("Tổng doanh thu thức uống: "+thongKeDoanhThuTheoThucUong());
                    }
                    else System.out.println("Lựa chọn không hợp lệ. Quay lại!");
                    break;
                case 6:
                    System.out.print("Nhập mã hoặc tên sản phẩm muốn thống kê: ");
                    input = KiemTra.kiemTraNhapChuoi();
                    SanPham sp = DanhSachSanPham.timKiemSanPhamTheoMaSP(input);
                    if (sp != null) {
                        System.out.println("Doanh thu theo sản phẩm "+sp.getTenSP()+": "+thongKeDoanhThuTheoSanPham(sp));
                    }
                    else {
                        if (DanhSachSanPham.timKiemSanPhamTheoTenSP(input) != null) {
                            sp = DanhSachSanPham.timKiemSanPhamTheoTenSP(input);
                            System.out.println("Doanh thu theo sản phẩm "+sp.getTenSP()+": "+thongKeDoanhThuTheoSanPham(sp));
                        }
                        else System.out.println("Sản phẩm không tồn tại!");
                    }
                    break;
                default:
                    break;
            }
            System.out.println("Bạn có muốn tiếp tục các thao tác trên? (y/n)");
            System.out.print("Lựa chọn: ");
            tiepTuc = KiemTra.tiepTuc();
        } while (tiepTuc.equals("y"));
    }


    // Start: Menu
    public void quanLiDS() {
        DonHang tmp;
        DonHang[] arr;
        String madh;
        while (true) {
            System.out.println("==================== QUẢN LÝ DANH SÁCH ĐƠN HÀNG ====================");
            System.out.println("\t\t\t1. Thêm đơn hàng.");
            System.out.println("\t\t\t2. Xem danh sách đơn hàng.");
            System.out.println("\t\t\t3. Tìm kiếm đơn hàng theo mã đơn hàng.");
            System.out.println("\t\t\t4. Tìm kiếm (các) đơn hàng theo mã nhân viên.");
            System.out.println("\t\t\t5. Tìm kiếm (các) đơn hàng theo mã khách hàng.");
            System.out.println("======================================================================");

            System.out.print("Nhập lựa chọn của bạn: ");
            int luaChon = KiemTra.kiemTraSoNguyenDuong();

            switch (luaChon) {
                case 1:
                    them();
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
                    } else {
                        System.out.println("Không có đơn hàng.");
                    }
                    break;
                case 5:
                    System.out.print("Nhập mã khách hàng: ");
                    String makh = KiemTra.kiemTraNhapMaKH();
                    arr = timKiemDonHangTheoMaKH(makh);
                    if (arr != null) {
                        for (DonHang donHang : arr) {
                            donHang.inThongTinDonHang();
                        }
                    } else {
                        System.out.println("Không có đơn hàng.");
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

}