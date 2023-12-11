package DanhSach;

import main.*;
import DanhSach.*;
import KiemTra.KiemTra;

public class run {
    DanhSachTaiKhoan listTaiKhoan = new DanhSachTaiKhoan();
    DanhSachQuyen listQuyen = new DanhSachQuyen();
    DanhSachChiTietGioHang listCTietGioHang = new DanhSachChiTietGioHang();
    DanhSachGioHang listGioHang = new DanhSachGioHang();
    DanhSachChiTietDonHang listCTDonHang = new DanhSachChiTietDonHang();
    DanhSachDonHang listDonHang = new DanhSachDonHang();
    DanhSachNguyenLieu listNguyenLieu = new DanhSachNguyenLieu();
    DanhSachPhieuNhap listPhieuNhap = new DanhSachPhieuNhap();
    DanhSachChiTietPN listCTPhieuNhap = new DanhSachChiTietPN();
    DanhSachSanPham listSanPham = new DanhSachSanPham();
    DanhSachCongThuc listCongThuc = new DanhSachCongThuc();
    DanhSachChiTietCongThuc listChiTietCongThuc = new DanhSachChiTietCongThuc();
    DanhSachNhaCungCap listNhaCungCap = new DanhSachNhaCungCap();
    DanhSachNhanVien listNhanVien = new DanhSachNhanVien();
    DanhSachKhachHang listKhachHang = new DanhSachKhachHang();
    DanhSachKhuyenMai listKhuyenMai = new DanhSachKhuyenMai();
    DanhSachGiaoHang listGiaoHang = new DanhSachGiaoHang();

    public void batDau() {
        System.out.println("Chào mừng đến với...");
        System.out.println("Bạn đã có tài khoản? (1. Đăng nhập)");
        System.out.println("Bạn chưa có tài khoản? (2. Đăng kí tài khoản)");
        System.out.print("Lựa chọn: ");
        int opt = KiemTra.kiemTraNhapSoNguyen();
        switch (opt) {
            case 1:
                dangNhap();
                break;
            case 2:
                dangKy();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Thoát!");
                break;
        }
        ghiFile();
    }

    private void dangNhap() {
        TaiKhoan a;
        String maTk, matKhau;
        do {
            System.out.print("Nhập mã tài khoản: ");
            maTk = KiemTra.kiemTraNhapChuoi();
            System.out.print("Nhập mật khẩu: ");
            matKhau = KiemTra.kiemTraNhapChuoi();
            a = listTaiKhoan.timTaiKhoan(maTk);

            if ((a == null) || (matKhau.equals(a.getMatKhau()) == false)) {
                System.out.println("Mã tài khoản hoặc mật khẩu không chính xác.");
                System.out.println("1. Nhập lại.");
                System.out.println("2. Thoát.");
                System.out.print("Nhập lựa chọn: ");
                int choice = KiemTra.kiemTraNhapSoNguyen();

                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                        return;
                }

            }
        } while (listTaiKhoan.ktraTaiKhoan(maTk, matKhau) == false);
        if (a.getTinhTrangTK() == 0) {
            System.out.println("Tài khoản của bạn đã bị khóa. Không thể đăng nhập bằng tài khoản này.");
            System.out.println(
                    "Nếu bạn muốn mở khóa tài khoản, vui lòng liên hệ mai trinh ngu để thực hiện mở khóa. Xin cảm ơn!");
            return;
        }
        System.out.println();
        System.out
                .println("===================================Đăng nhập thành công===================================");
        System.out.println();

        switch (a.getMaQuyen()) {
            case 0:
                menuAdmin(a);
                break;
            case 1:
                menuNhanVien(a);
                break;
            case 2:
                menuKhachHang(a);
                break;
            default:
                break;
        }

    }

    public void dangKy() {
        TaiKhoan a = new TaiKhoan();
        a.nhapTaiKhoanKH();
        listTaiKhoan.themTaiKhoan(a);
        GioHang gioHang = new GioHang(a.getMaTK());
        DanhSachGioHang.themGioHang(gioHang);
        listGioHang.ghiFile();
        listTaiKhoan.ghiFile();
        System.out.println("Đăng kí tài khoản thành công. Vui lòng đăng nhập!\n");
        dangNhap();
    }

    private void datHangOnline(String maTK) {
        String ten, sdt, diachi;

        int opt;
        if (DanhSachChiTietGioHang.timKiemCTGioHang(maTK) == null) {
            System.out.println("Giỏ hàng của bạn đang trống. Vui lòng mua thêm sản phẩm để có thể đặt hàng.");
        } else {
            System.out.println("Vui lòng nhập thông tin của bạn: ");
            System.out.print("Nhập họ tên: ");
            ten = KiemTra.kiemTraNhapChuoi();
            System.out.print("Nhập số điện thoại: ");
            sdt = KiemTra.kiemTraNhapSDT();
            System.out.print("Nhập địa chỉ: ");
            diachi = KiemTra.kiemTraNhapChuoi();

            DonHang donHang = new DonHang("NV001", maTK);
            System.out.println("Thông tin đơn hàng: ");
            donHang.inThongTinDonHang(maTK);
            GiaoHang giaoHang = new GiaoHang(donHang.getMaDH(), diachi, 30000, "Nhanh");
            giaoHang.inThongTinGiaoHang();

            System.out.print("Bạn có muốn xác nhận đặt hàng? (1.Có - 2.Không)");
            opt = KiemTra.kiemTraNhapSoNguyen();
            System.out.println();
            if (opt != 1 && opt != 2) {
                System.out.println("Lựa chọn không hợp lệ. Trở về!");
            } else if (opt == 1) {
                listDonHang.themDHOnline(maTK);
                listGiaoHang.themGiaoHang(giaoHang);
                DanhSachGioHang.timKiemGioHang(maTK).xoaToanBoSP(maTK);
                System.out.println("Đặt hàng thành công. Cảm ơn bạn đã mua hàng của cửa hàng!");
            } else if (opt == 2) {

            }
        }
    }

    private void menuKhachHang(TaiKhoan a) {
        int opt;
        String tieptuc, input, tieptuc1;
        SanPham[] sp;
        do {
            System.out.println();
            System.out.println("Các thao tác: ");
            System.out.println("1. Tìm kiếm sản phẩm.");
            System.out.println("2. Xem tất cả sản phẩm.");
            System.out.println("3. Đặt hàng.");
            System.out.println("4. Xem giỏ hàng.");
            System.out.println("5. Thêm sản phẩm vào giỏ hàng.");
            System.out.println("6. Xóa toàn bộ sản phẩm trong giỏ hàng.");
            System.out.println("7. Thay đổi số lượng sản phẩm trong giỏ hàng.");
            System.out.println("8. Cập nhật mật khẩu.");
            System.out.println("9. Khóa tài khoản.");
            System.out.print("Lựa chọn: ");
            opt = KiemTra.kiemTraNhapSoNguyen();
            System.out.println();

            switch (opt) {
                case 1:
                    System.out.print("Nhập tên hoặc mã sản phẩm muốn tìm kiếm: ");
                    input = KiemTra.kiemTraNhapChuoi();
                    if (DanhSachSanPham.timKiemSanPhamTheoMaSP(input) != null) {
                        DanhSachSanPham.timKiemSanPhamTheoMaSP(input).xuatSanPham();
                        break;
                    } else {
                        sp = DanhSachSanPham.timKiemSanPhamTheoPham(input);
                        if (sp != null) {
                            for (int i = 0; i < sp.length; i++) {
                                sp[i].xuatSanPham();
                            }
                            break;
                        } else {
                            System.out.println("Không có sản phẩm.");
                        }
                    }
                    break;
                case 2:
                    listSanPham.xuatDSSP();
                    break;
                case 3:
                    datHangOnline(a.getMaTK());
                    break;
                case 4:
                    DanhSachGioHang.timKiemGioHang(a.getMaTK()).xuatGioHang();
                    break;
                case 5:
                    listSanPham.xuatDSSP();
                    do {
                        System.out.print("Nhập mã sản phẩm bạn muốn thêm: ");
                        input = KiemTra.kiemTraNhapMaSP();
                        if (DanhSachSanPham.timKiemSanPhamTheoMaSP(input) == null) {
                            System.out.println("Không tồn tại sản phẩm.");
                        } else {
                            listCTietGioHang.themCTGioHang(a.getMaTK(), input);
                        }
                        System.out.print("Bạn có muốn tiếp tục mua hàng?(y/n): ");
                        tieptuc1 = KiemTra.tiepTuc();
                    } while (tieptuc1.equals("y"));
                    break;
                case 6:
                    DanhSachGioHang.timKiemGioHang(a.getMaTK()).xoaToanBoSP();
                    break;
                case 7:
                    DanhSachGioHang.timKiemGioHang(a.getMaTK()).thayDoiSoLuongSanPham();
                    break;
                case 8:
                    listTaiKhoan.timTaiKhoan(a.getMaTK()).setMatKhau();
                    System.out.println("Đã cập nhật mật khẩu!");
                    break;
                case 9:
                    a.setTinhTrangTK(0);
                    listTaiKhoan.ghiFile();
                    System.out.println("Đã khóa tài khoản.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
            System.out.println("Bạn có muốn tiếp tục các thao tác trên khách hàng? (y/n)");
            System.out.print("Lựa chọn: ");
            tieptuc = KiemTra.tiepTuc();
        } while (tieptuc.equals("y"));
        System.out.println("Cảm ơn Khách Hàng đã sử dụng dịch vụ của cửa hàng. Xin chào và hẹn gặp lại!");
    }

    private void menuNhanVien(TaiKhoan a) {
        String input, tiepTuc;
        SanPham[] sp;
        int opt;
        do {
            System.out.println();
            System.out.println("Các thao tác: ");
            System.out.println("1. Tìm kiếm sản phẩm.");
            System.out.println("2. Xem tất cả sản phẩm.");
            System.out.println("3. Quản lí đơn hàng.");
            System.out.println("4. Quản lí phiểu nhập.");
            System.out.println("5. Cập nhật mật khẩu.");
            System.out.println("6. Khóa tài khoản.");

            System.out.print("Lựa chọn: ");
            opt = KiemTra.kiemTraNhapSoNguyen();
            System.out.println();

            switch (opt) {
                case 0:
                    break;
                case 1:
                    System.out.print("Nhập tên hoặc mã sản phẩm muốn tìm kiếm: ");
                    input = KiemTra.kiemTraNhapChuoi();
                    if (DanhSachSanPham.timKiemSanPhamTheoMaSP(input) != null) {
                        DanhSachSanPham.timKiemSanPhamTheoMaSP(input).xuatSanPham();
                        break;
                    } else {
                        sp = DanhSachSanPham.timKiemSanPhamTheoPham(input);
                        if (sp != null) {
                            for (int i = 0; i < sp.length; i++) {
                                sp[i].xuatSanPham();
                            }
                            break;
                        } else {
                            System.out.println("Không có sản phẩm.");
                        }
                    }

                    break;
                case 2:
                    listSanPham.xuatDSSP();
                    break;
                case 3:
                    listDonHang.quanLiDS();
                    break;
                case 4:
                    listPhieuNhap.quanLiDS();
                    break;
                case 5:
                    listTaiKhoan.timTaiKhoan(a.getMaTK()).setMatKhau();
                    System.out.println("Đã cập nhật mật khẩu!");
                    break;
                case 6:
                    a.setTinhTrangTK(0);
                    listTaiKhoan.ghiFile();
                    System.out.println("Đã khóa tài khoản.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
            System.out.println("Bạn có muốn tiếp tục các thao tác trên nhân viên? (y/n)");
            System.out.print("Lựa chọn: ");
            tiepTuc = KiemTra.tiepTuc();
        } while (tiepTuc.equals("y"));
    }

    private void menuAdmin(TaiKhoan a) {
        String tiepTuc;
        int opt;
        do {
            System.out.println();
            System.out.println("Các thao tác: ");
            System.out.println("1. Quản lí sản phẩm.");
            System.out.println("2. Quản lí nguyên liệu.");
            System.out.println("3. Quản lí phiếu nhập.");
            System.out.println("4. Quản lí khuyến mãi.");
            System.out.println("5. Quản lí đơn hàng.");
            System.out.println("6. Quản lí công thức.");
            System.out.println("7. Quản lí khách hàng.");
            System.out.println("8. Quản lí phiếu nhập.");
            System.out.println("9. Quản lí tài khoản.");
            System.out.println("10. Quản lí nhân viên.");
            System.out.println("11. Quản lí nhà cung cấp");

            System.out.print("Lựa chọn: ");
            opt = KiemTra.kiemTraNhapSoNguyen();
            System.out.println();

            switch (opt) {
                case 0:
                    break;
                case 1:
                    listSanPham.quanLiDS();
                    break;
                case 2:
                    listNguyenLieu.quanLiDS();
                    break;
                case 3:
                    listPhieuNhap.quanLiDS();
                    break;
                case 4:
                    listKhuyenMai.quanLiDS();
                    break;
                case 5:
                    listDonHang.quanLiDS();
                    break;
                case 6:
                    listCongThuc.quanLiDS();
                    break;
                case 7:
                    listKhachHang.quanLyKhachHang();
                    break;
                case 8:
                    listPhieuNhap.quanLiDS();
                    break;
                case 9:
                    listTaiKhoan.quanLiDS();
                    break;
                case 10:
                    listNhanVien.quanLyNhanVien();
                    break;
                case 11:
                    listNhaCungCap.quanLiDS();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
            System.out.println("Bạn có muốn tiếp tục các thao tác trên admin? (y/n)");
            System.out.print("Lựa chọn: ");
            tiepTuc = KiemTra.tiepTuc();
        } while (tiepTuc.equals("y"));
    }

    private void ghiFile() {
        listCTDonHang.ghiFile();
        listCTPhieuNhap.ghiFile();
        listCTietGioHang.ghiFile();
        listCongThuc.ghiFile();
        listDonHang.ghiFile();
        listGioHang.ghiFile();
        listKhachHang.ghiFile();
        listKhuyenMai.ghiFile();
        listNguyenLieu.ghiFile();
        listNhaCungCap.ghiFile();
        listNhanVien.ghiFile();
        listPhieuNhap.ghiFile();
        listSanPham.ghiFile();
        listTaiKhoan.ghiFile();
        listGiaoHang.ghiFile();
    }
}
