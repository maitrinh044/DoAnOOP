package DanhSach;

import KiemTra.KiemTra;
import main.NVBanHang;
import main.NVQuanLy;
import main.NhanVien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhSachNhanVien implements File {
    Scanner sc = new Scanner(System.in);
    private List<NhanVien> DS_NhanVien;
    KiemTra kiemTra = new KiemTra();

    public DanhSachNhanVien() {
        DS_NhanVien = new ArrayList<NhanVien>();
    }

    public List<NhanVien> getDS_NhanVien() {
        return this.DS_NhanVien;
    }

    // Phương thức trả về số lượng nhân viên trong danh sách
    private int soLuongNhanVien() {
        return this.DS_NhanVien.size();
    }

    // Start: Menu
    public void quanLyNhanVien() {
        String tiepTuc;
        do {
            System.out.println("==================== QUẢN LÝ DANH SÁCH NHÂN VIÊN ====================");
            System.out.println("\t\t\t1. Thêm (các) nhân viên mới vào danh sách.");
            System.out.println("\t\t\t2. Xem danh sách nhân viên.");
            System.out.println("\t\t\t3. Tìm kiếm nhân viên theo mã NV.");
            System.out.println("\t\t\t4. Tìm kiếm nhân viên theo tên NV.");
            System.out.println("\t\t\t5. Cập nhật thông tin nhân viên.");
            System.out.println("\t\t\t6. Xóa một nhân viên khỏi danh sách.");
            System.out.println("\t\t\t7. Xóa tất cả nhân viên có trong danh sách.");
            System.out.println("======================================================================");

            System.out.print("Nhập lựa chọn của bạn: ");
            int luaChon = KiemTra.kiemTraSoNguyenDuong();

            switch (luaChon) {
                case 1:
                    themNhanVien();
                    break;
                case 2:
                    inDanhSachNhanVien();
                    break;
                case 3:
                    timKiemNhanVienTheoMaNV();
                    break;
                case 4:
                    timKiemNhanVienTheoTenNV();
                    break;
                case 5:
                    capNhatThongTinNhanVien();
                    break;
                case 6:
                    xoaNhanVien();
                    break;
                case 7:
                    xoaTatCaNhanVien();

                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
            }

            // * Hỏi người dùng có muốn tiếp tục chọn hay không?
            System.out.println("Bạn có muốn tiếp tục các thao tác trên? (y/n)");
            System.out.print("Lựa chọn: ");
            tiepTuc = KiemTra.tiepTuc();
        } while (tiepTuc.equals("y"));
    }
    // End: Menu

    // 1. Phương thức thêm (các) nhân viên mới vào danh sách
    private void themNhanVien() {
        System.out.print("\nNhập số lượng nhân viên cần thêm: ");
        int soLuong = KiemTra.kiemTraSoNguyenDuong();

        int soNhanVienDaNhap = 0;

        while (soNhanVienDaNhap < soLuong) {
            System.out.println("\nThêm nhân viên thứ " + (soNhanVienDaNhap + 1) + "/" + soLuong);

            // khởi tạo một đối tượng nhân viên mới
            NhanVien nv;

            // Hiện menu
            System.out.println("--------------- Thêm Nhân Viên ---------------");
            System.out.println("\t\t1. Nhân viên quản lý.");
            System.out.println("\t\t2. Nhân viên bán hàng.");
            System.out.println("----------------------------------------------");
            System.out.print("Chọn chức vụ nhân viên muốn thêm: ");
            int luaChon = KiemTra.kiemTraSoNguyenDuong();

            switch (luaChon) {
                case 1:
                    nv = new NVQuanLy();
                    nv.nhapHoSoNhanVien();
                    DS_NhanVien.add(nv);
                    break;
                case 2:
                    nv = new NVBanHang();
                    nv.nhapHoSoNhanVien();
                    DS_NhanVien.add(nv);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
            }
            soNhanVienDaNhap++;
        }
    }

    // Phương thức kiểm tra chức vụ và in nhân viên
    private void inNhanVien(NhanVien nhanVien) {
        if (nhanVien instanceof NVQuanLy) {
            NVQuanLy ql = (NVQuanLy) nhanVien;
            ql.inHoSoNhanVien();
        } else if (nhanVien instanceof NVBanHang) {
            NVBanHang bh = (NVBanHang) nhanVien;
            bh.inHoSoNhanVien();
        }
    }

    // 2. Phương thức in danh sách nhân viên
    public void inDanhSachNhanVien() {
        if (DS_NhanVien.isEmpty()) {
            System.out.println("Hiện không có nhân viên nào trong danh sách!");
        } else {
            System.out.println("DANH SÁCH NHÂN VIÊN: (" + soLuongNhanVien() + " nhân viên)");
            System.out.printf("|%-5s|%-30s|%-10s|%-10s|%-10s|Lương\n",
                    "Mã NV", "Tên nhân viên", "Chức vụ", "Ngày sinh", "Điện thoại");
            for (NhanVien nhanVien : DS_NhanVien) {
                inNhanVien(nhanVien);
            }
        }
    }

    // 3a. Phương thức tìm kiếm nhân viên theo mã NV được truyền qua tham số đầu vào
    private NhanVien timKiemNhanVienTheoMaNV(String maNVCanTim) {
        for (NhanVien nhanVien : DS_NhanVien) {
            if (nhanVien.getMaNV().equalsIgnoreCase(maNVCanTim)) {
                return nhanVien;
            }
        }
        return null;
    }

    // 3b. Phương thức tìm kiếm nhân viên theo mã NV được nhập vào từ bàn phím
    private void timKiemNhanVienTheoMaNV() {
        System.out.print("Nhập mã nhân viên cần tìm: ");
        String maNVCanTim = KiemTra.kiemTraNhapMaNV();

        for (NhanVien nhanVien : DS_NhanVien) {
            if (nhanVien.getMaNV().equalsIgnoreCase(maNVCanTim)) {
                System.out.println("------------------------------");
                System.out.println("Thông tin nhân viên cần tìm:");
                System.out.printf("|%-5s|%-30s|%-10s|%-10s|%-10s|Lương\n",
                        "Mã NV", "Tên nhân viên", "Chức vụ", "Ngày sinh", "Điện thoại");
                inNhanVien(nhanVien);
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên có mã " + maNVCanTim + " trong danh sách!");
    }

    // 4. Phương thức tìm kiếm nhân viên theo tên NV
    private void timKiemNhanVienTheoTenNV() {
        System.out.print("Nhập tên nhân viên cần tìm: ");
        String tenNVCanTim = KiemTra.kiemTraNhapTen();

        boolean timThay = false;

        for (NhanVien nhanVien : DS_NhanVien) {
            if (nhanVien.getTenNV().contains(tenNVCanTim)) {
                System.out.println("------------------------------");
                System.out.println("Thông tin (các) nhân viên cần tìm:");
                System.out.printf("|%-5s|%-30s|%-10s|%-10s|%-10s|Lương\n",
                        "Mã NV", "Tên nhân viên", "Chức vụ", "Ngày sinh", "Điện thoại");
                inNhanVien(nhanVien);
                timThay = true;
            }
        }
        if (!timThay)
            System.out.println("Không tìm thấy nhân viên có tên \"" + tenNVCanTim + "\" trong danh sách!");
    }

    // 5. Phương thức cập nhật thông tin nhân viên
    private void capNhatThongTinNhanVien() {
        System.out.print("Nhập mã nhân viên cần cập nhật: ");
        String maNVCanCapNhat = KiemTra.kiemTraNhapMaNV();

        NhanVien nhanVien = timKiemNhanVienTheoMaNV(maNVCanCapNhat);

        if (nhanVien != null) {
            while (true) {
                System.out.println("--------------- CẬP NHẬT THÔNG TIN NHÂN VIÊN ---------------");
                System.out.println("\t\t1. Mã nhân viên.");
                System.out.println("\t\t2. Họ và tên nhân viên.");
                System.out.println("\t\t3. Ngày tháng năm sinh.");
                System.out.println("\t\t4. Số điện thoại.");
                System.out.println("\t\t5. Tiền thưởng.");
                System.out.println("----------------------------------------------");
                System.out.print("Chọn thông tin cần sửa: ");
                int luaChon = KiemTra.kiemTraSoNguyenDuong();

                switch (luaChon) {
                    case 1:
                        System.out.print("Nhập mã nhân viên mới: ");
                        String maNV = KiemTra.kiemTraNhapMaNV();
                        nhanVien.setMaNV(maNV);
                        break;
                    case 2:
                        System.out.print("Nhập họ và tên mới: ");
                        String tenNV = KiemTra.kiemTraNhapTen();
                        nhanVien.setTenNV(tenNV);
                        break;
                    case 3:
                        System.out.print("Nhập ngày sinh mới: ");
                        String ngaySinh = KiemTra.kiemTraNgayThangNam();
                        nhanVien.setNgaySinh(ngaySinh);
                        break;
                    case 4:
                        System.out.print("Nhập số điện thoại mới: ");
                        String dienThoai = KiemTra.kiemTraNhapSDT();
                        nhanVien.setDienThoai(dienThoai);
                        break;
                    case 5:
                        if (nhanVien instanceof NVBanHang) {
                            NVBanHang bh = (NVBanHang) nhanVien;
                            System.out.print("Nhập tiền thưởng mới: ");
                            double tienThuong = KiemTra.kiemTraTienThuong();
                            bh.setTienThuong(tienThuong);
                        } else if (nhanVien instanceof NVQuanLy) {
                            NVQuanLy ql = (NVQuanLy) nhanVien;
                            System.out.print("Nhập tiền thưởng mới: ");
                            double tienThuong = KiemTra.kiemTraTienThuong();
                            ql.setTienThuong(tienThuong);
                        }
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
                }

                // * Hỏi người dùng có muốn tiếp tục chọn hay không?
                System.out.print("\nBạn có muốn tiếp tục cập nhật thông tin nhân viên không? (y/n): ");
                String tiepTuc = KiemTra.tiepTuc();
                if (tiepTuc.equals("n")) {
                    System.out.println("\nHoàn tất cập nhật thông tin nhân viên!");
                    break;
                }
            }

            // * In ra thông tin nhân viên sau khi cập nhật
            System.out.println("------------------------------");
            System.out.println("Thông tin nhân viên sau khi cập nhật:");
            System.out.printf("|%-5s|%-30s|%-10s|%-10s|%-10s|Lương\n",
                    "Mã NV", "Tên nhân viên", "Chức vụ", "Ngày sinh", "Điện thoại");
            inNhanVien(nhanVien);
        } else {
            System.out.println("Không tìm thấy nhân viên có mã " + maNVCanCapNhat + " trong danh sách!");
        }
    }

    // 6. Phương thức xóa một nhân viên khỏi danh sách
    private void xoaNhanVien() {
        System.out.print("Nhập mã nhân viên cần xóa: ");
        String maNVCanXoa = KiemTra.kiemTraNhapMaNV();

        NhanVien nhanVien = timKiemNhanVienTheoMaNV(maNVCanXoa);

        if (nhanVien != null) {
            System.out.println("------------------------------");
            System.out.println("Thông tin nhân viên cần xóa:");
            System.out.printf("|%-5s|%-30s|%-10s|%-10s|%-10s|Lương\n",
                    "Mã NV", "Tên nhân viên", "Chức vụ", "Ngày sinh", "Điện thoại");
            inNhanVien(nhanVien);

            System.out.print("Bạn có chắc chắn muốn xóa nhân viên này khỏi danh sách? (y/n): ");
            String luaChon = KiemTra.tiepTuc();

            if (luaChon.equals("y")) {
                DS_NhanVien.remove(nhanVien);
                System.out.println("Đã xóa nhân viên có mã " + maNVCanXoa + " khỏi danh sách!");
            } else {
                System.out.println("Đã hủy xóa nhân viên có mã " + maNVCanXoa + " khỏi danh sách!");
            }
        } else {
            System.out.println("Không tìm thấy nhân viên có mã " + maNVCanXoa + " trong danh sách!");
        }
    }

    // 7. Phương thức xóa tất cả nhân viên khỏi danh sách
    private void xoaTatCaNhanVien() {
        System.out.print("Bạn có chắc chắn muốn xóa tất cả nhân viên khỏi danh sách? (y/n): ");
        String luaChon = KiemTra.tiepTuc();

        if (luaChon.equals("y")) {
            DS_NhanVien.clear();
            System.out.println("Đã xóa tất cả nhân viên khỏi danh sách!");
        } else {
            System.out.println("Đã hủy xóa tất cả nhân viên khỏi danh sách!");
        }
    }

    // 8. Phương thức ghi danh sách nhân viên vào file
    @Override
    public void ghiFile() {
        if (DS_NhanVien.isEmpty()) {
            System.out.println("Hiện không có nhân viên nào trong danh sách!");
            return;
        }
        try {
            FileWriter fw = new FileWriter("./input/NhanVien.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (NhanVien nhanVien : DS_NhanVien) {
                if (nhanVien instanceof NVBanHang) {
                    NVBanHang bh = (NVBanHang) nhanVien;
                    bw.write(bh.toString());
                } else if (nhanVien instanceof NVQuanLy) {
                    NVQuanLy ql = (NVQuanLy) nhanVien;
                    bw.write(ql.toString());
                }
                bw.newLine();
            }

            bw.close();
            fw.close();

            System.out.println("Đã ghi danh sách nhân viên vào file thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 9. Phương thức đọc danh sách nhân viên từ file
    @Override
    public void docFile(String tenFile) {
        DS_NhanVien.clear();
        try {
            FileReader fr = new FileReader(tenFile);
            BufferedReader br = new BufferedReader(fr);

            String lines;

            while ((lines = br.readLine()) != null) {
                String[] thongTinNV = lines.split("#");

                NhanVien nv;
                if ("Quản lý".equals(thongTinNV[4])) {
                    nv = new NVQuanLy(thongTinNV[0], thongTinNV[1], thongTinNV[2], thongTinNV[3],
                            Double.parseDouble(thongTinNV[5]));
                    DS_NhanVien.add(nv);
                } else if ("Bán hàng".equals(thongTinNV[4])) {
                    nv = new NVBanHang(thongTinNV[0], thongTinNV[1], thongTinNV[2], thongTinNV[3],
                            Double.parseDouble(thongTinNV[5]));
                    DS_NhanVien.add(nv);
                }
            }

            br.close();
            fr.close();

            System.out.println("Đã đọc danh sách nhân viên từ file thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
