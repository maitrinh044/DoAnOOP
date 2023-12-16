package DanhSach;

import KiemTra.KiemTra;
import main.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DanhSachGiaoHang {
    public static List<GiaoHang> DS_GiaoHang;

    // Constructor
    public DanhSachGiaoHang() {
        DS_GiaoHang = new ArrayList<>();
        String tenFile = "./input/GiaoHang.txt";
        try {
            FileReader fr = new FileReader(tenFile);
            BufferedReader br = new BufferedReader(fr);

            if (br.readLine() != null) {
                docFile();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getSoLuong() {
        return DS_GiaoHang.size();
    }

    // Start: Menu quản lý danh sách giao hàng
    public void quanLiDS() {
        while (true) {
            System.out.println("==================== QUẢN LÝ DANH SÁCH ĐƠN GIAO HÀNG ====================");
            System.out.println("\t\t\t1. Thêm (các) đơn giao hàng mới vào danh sách.");
            System.out.println("\t\t\t2. Xem danh sách đơn giao hàng.");
            System.out.println("\t\t\t3. Tìm kiếm đơn giao hàng theo mã đơn giao hàng.");
            System.out.println("\t\t\t4. Tìm kiếm đơn giao hàng theo mã đơn hàng.");
            System.out.println("======================================================================");

            System.out.print("Nhập lựa chọn của bạn: ");
            int luaChon = KiemTra.kiemTraSoNguyenDuong();

            switch (luaChon) {
                case 1:
                    themGiaoHang();
                    break;
                case 2:
                    inDanhSachDonGH();
                    break;
                case 3:
                    timKiemGiaoHangTheoMaDGH();
                    break;
                case 4:
                    timKiemGiaoHangTheoMaDH();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
            }

            // Hỏi người dùng có muốn tiếp tục9 chọn hay không?
            System.out.print("\nBạn có muốn tiếp tục với Danh sách Đơn giao hàng không? (y/n): ");
            String tiepTuc = KiemTra.tiepTuc();
            if (tiepTuc.equals("n")) {
                System.out.println("\nThoát khỏi Quản lý Danh sách Đơn giao hàng...");
                break;
            }
        }
    }
    // End: Menu quản lý danh sách giao hàng

    // 1. Thêm (các) đơn giao hàng mới vào danh sách.
    private void themGiaoHang() {
        System.out.print("Nhập số lượng đơn giao hàng muốn thêm: ");
        int soLuong = KiemTra.kiemTraSoNguyenDuong();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin đơn giao hàng thứ #" + (i + 1) + ": ");
            System.out.print("Nhập mã đơn hàng: ");
            String maDH = KiemTra.kiemTraNhapMaDH();
            System.out.print("Nhập địa chỉ giao hàng: ");
            String diaChiGH = KiemTra.kiemTraNhapChuoi();
            System.out.print("Nhập phí giao hàng: ");
            int phiGiaoHang = KiemTra.kiemTraNhapSoNguyen();
            System.out.print("Nhập phương thức giao hàng: ");
            String phuongThucGH = KiemTra.kiemTraNhapChuoi();

            GiaoHang GiaoHang = new GiaoHang(maDH, diaChiGH, phiGiaoHang, phuongThucGH);
            DS_GiaoHang.add(GiaoHang);
        }
        System.out.println("Đã thêm thành công " + soLuong + " đơn giao hàng vào danh sách.");
    }

    public void themGiaoHang(GiaoHang a) {
        DS_GiaoHang.add(a);
    }

    // 2. Xem danh sách đơn giao hàng.
    private void inDanhSachDonGH() {
        System.out.println("-------------------- DANH SÁCH ĐƠN GIAO HÀNG -------------------");
        System.out.printf("|%-6s|%-5s|%-10s|%-30s|%-10s|%-15s\n",
                "Mã ĐGH", "Mã ĐH", "Ngày GH", "Địa chỉ GH", "Phí GH", "Phương thức GH");
        for (GiaoHang GiaoHang : DS_GiaoHang) {
            GiaoHang.inThongTinGiaoHang();
        }
        System.out.println("------------------------------------------------------------------");
    }

    // 3. Tìm kiếm đơn giao hàng theo mã đơn giao hàng.
    private GiaoHang timKiemGiaoHangTheoMaDGH(String maDonGH) {
        for (GiaoHang GiaoHang : DS_GiaoHang) {
            if (GiaoHang.getMaGiaoHang().equals(maDonGH)) {
                return GiaoHang;
            }
        }
        return null;
    }

    private void timKiemGiaoHangTheoMaDGH() {
        System.out.print("Nhập mã đơn giao hàng cần tìm kiếm: ");
        String maDonGH = KiemTra.kiemTraNhapMaDonGH();
        GiaoHang GiaoHang = timKiemGiaoHangTheoMaDGH(maDonGH);
        if (GiaoHang != null) {
            System.out.println("Đã tìm thấy đơn giao hàng có mã " + maDonGH + " trong danh sách.");
            System.out.println("-------------------- THÔNG TIN ĐƠN GIAO HÀNG -------------------");
            System.out.printf("|%-6s|%-5s|%-10s|%-30s|%-10s|%-15s\n",
                    "Mã ĐGH", "Mã ĐH", "Ngày GH", "Địa chỉ GH", "Phí GH", "Phương thức GH");
            GiaoHang.inThongTinGiaoHang();
            System.out.println("----------------------------------------------------------------");
        } else {
            System.out.println("Không tìm thấy đơn giao hàng có mã " + maDonGH + " trong danh sách.");
        }
    }

    // 4. Tìm kiếm đơn giao hàng theo mã đơn hàng.

    private void timKiemGiaoHangTheoMaDH() {
        System.out.print("Nhập mã đơn hàng cần tìm kiếm: ");
        String maDH = KiemTra.kiemTraNhapMaDH();
        // while(true) {
        // maDH = KiemTra.kiemTraNhapMaDH();
        // //Kiểm tra xem mã đơn hàng có tồn tại trong danh sách đơn hàng hay không?
        // //Nếu không tồn tại thì yêu cầu nhập lại
        // if(!KiemTra.KiemTraMaDHTrongDS(maDH)) {
        // System.out.print("Mã đơn hàng không tồn tại trong danh sách đơn hàng, vui
        // lòng nhập lại: ");
        // } else {
        // break;
        // }
        // }

        boolean timThay = false;

        for (GiaoHang GiaoHang : DS_GiaoHang) {
            if (GiaoHang.getMaDH().equals(maDH)) {
                System.out.println("-------------------- THÔNG TIN ĐƠN GIAO HÀNG -------------------");
                System.out.printf("|%-6s|%-5s|%-10s|%-30s|%-10s|%-15s\n",
                        "Mã ĐGH", "Mã ĐH", "Ngày GH", "Địa chỉ GH", "Phí GH", "Phương thức GH");
                GiaoHang.inThongTinGiaoHang();
                System.out.println("----------------------------------------------------------------");
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy (các) đơn giao hàng có mã đơn hàng " + maDH + " trong danh sách.");
        }
    }

    // 5. Cập nhật đơn giao hàng.
    public void capNhatThongTinDonGH() {
        System.out.print("Nhập mã đơn giao hàng cần cập nhật: ");
        String maDonGH = KiemTra.kiemTraNhapMaDonGH();

        GiaoHang GiaoHang = timKiemGiaoHangTheoMaDGH(maDonGH);

        if (GiaoHang != null) {
            while (true) {
                System.out.println("---------- Cập nhật đơn giao hàng ----------");
                System.out.println("\t\t1. Cập nhật mã đơn giao hàng.");
                System.out.println("\t\t2. Cập nhật mã đơn hàng.");
                System.out.println("\t\t3. Cập nhật ngày giao hàng.");
                System.out.println("\t\t4. Cập nhật địa chỉ giao hàng.");
                System.out.println("\t\t5. Cập nhật phí giao hàng.");
                System.out.println("\t\t6. Cập nhật phương thức giao hàng.");
                System.out.println("--------------------------------------------");

                System.out.print("Nhập lựa chọn của bạn: ");
                int luaChon = KiemTra.kiemTraSoNguyenDuong();

                switch (luaChon) {
                    case 1:
                        System.out.print("Nhập mã đơn giao hàng mới: ");
                        String maDonGHMoi = KiemTra.kiemTraNhapMaDonGH();
                        GiaoHang.setMaGiaoHang(maDonGHMoi);
                        break;
                    case 2:
                        System.out.print("Nhập mã đơn hàng mới: ");
                        String maDHMoi = KiemTra.kiemTraNhapMaDH();
                        // while(true) {
                        // maDHMoi = KiemTra.kiemTraNhapMaDH();
                        // if(!KiemTra.KiemTraMaDHTrongDS(maDHMoi)) {
                        // System.out.print("Mã đơn hàng không tồn tại trong danh sách đơn hàng, vui
                        // lòng nhập lại: ");
                        // } else {
                        // break;
                        // }
                        // }
                        GiaoHang.setMaDH(maDHMoi);
                        break;
                    case 3:
                        System.out.print("Nhập ngày giao hàng mới: ");
                        Date ngayGiaoHangMoi = KiemTra.chuyenChuoiThanhDate();
                        GiaoHang.setNgayGiaoHang(ngayGiaoHangMoi);
                        break;
                    case 4:
                        System.out.print("Nhập địa chỉ giao hàng mới: ");
                        String diaChiGHMoi = KiemTra.kiemTraNhapChuoi();
                        GiaoHang.setDiaChiGiaoHang(diaChiGHMoi);
                        break;
                    case 5:
                        System.out.print("Nhập phí giao hàng mới: ");
                        int phiGiaoHangMoi = KiemTra.kiemTraNhapSoNguyen();
                        GiaoHang.setPhiGiaoHang(phiGiaoHangMoi);
                        break;
                    case 6:
                        System.out.print("Nhập phương thức giao hàng mới: ");
                        String phuongThucGHMoi = KiemTra.kiemTraNhapChuoi();
                        GiaoHang.setPhuongThucGiaoHang(phuongThucGHMoi);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
                }

                // Hỏi người dùng có muốn tiếp tục chọn hay không?
                System.out.print("\nBạn có muốn tiếp tục với Cập nhật đơn giao hàng không? (y/n): ");
                String tiepTuc = KiemTra.tiepTuc();
                if (tiepTuc.equals("n")) {
                    System.out.println("\nHoàn tất cập nhật đơn giao hàng!");
                    break;
                }
            }

            System.out.println("---------- THÔNG TIN ĐƠN GIAO HÀNG SAU CẬP NHẬT ----------");
            System.out.printf("|%-6s|%-5s|%-10s|%-30s|%-10s|%-15s\n",
                    "Mã ĐGH", "Mã ĐH", "Ngày GH", "Địa chỉ GH", "Phí GH", "Phương thức GH");
            GiaoHang.inThongTinGiaoHang();
            System.out.println("----------------------------------------------------------");
        } else {
            System.out.println("Không tìm thấy đơn giao hàng có mã " + maDonGH + " trong danh sách.");
        }
    }

    // 6. Xóa một đơn giao hàng khỏi danh sách.
    private void xoaMotDonGH() {
        System.out.print("Nhập mã đơn giao hàng cần xóa: ");
        String maDonGH = KiemTra.kiemTraNhapMaDonGH();

        GiaoHang GiaoHang = timKiemGiaoHangTheoMaDGH(maDonGH);

        if (GiaoHang != null) {
            DS_GiaoHang.remove(GiaoHang);
            System.out.println("Đã xóa đơn giao hàng có mã " + maDonGH + " khỏi danh sách.");
        } else {
            System.out.println("Không tìm thấy đơn giao hàng có mã " + maDonGH + " trong danh sách.");
        }
    }

    // 7. Xóa tất cả đơn giao hàng có trong danh sách.
    private void xoaTatCaDonGH() {
        System.out.print("Bạn có chắc chắn muốn xóa tất cả đơn giao hàng khỏi danh sách? (y/n): ");
        String luaChon = KiemTra.tiepTuc();

        if (luaChon.equals("y")) {
            DS_GiaoHang.clear();
            System.out.println("Đã xóa tất cả đơn giao hàng khỏi danh sách.");
        } else {
            System.out.println("Hủy xóa tất cả đơn giao hàng.");
        }
    }

    // 8. Ghi danh sách đơn giao hàng vào file.
    public void ghiFile() {
        String tenFile = "./input/GiaoHang.txt";
        try {
            FileWriter fw = new FileWriter(tenFile);
            BufferedWriter bw = new BufferedWriter(fw);

            for (GiaoHang GiaoHang : DS_GiaoHang) {
                bw.write(GiaoHang.getMaGiaoHang() + "#" + GiaoHang.getMaDH() + "#"
                        + KiemTra.chuyenDateThanhChuoi(GiaoHang.getNgayGiaoHang()) + "#" + GiaoHang.getDiaChiGiaoHang()
                        + "#" + GiaoHang.getPhiGiaoHang() + "#" + GiaoHang.getPhuongThucGiaoHang());
                bw.newLine();
            }

            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 9. Đọc danh sách đơn giao hàng từ file.
    private void docFile() {
        String tenFile = "./input/GiaoHang.txt";
        try {
            FileReader fr = new FileReader(tenFile);
            BufferedReader br = new BufferedReader(fr);

            String lines;

            while ((lines = br.readLine()) != null) {
                String[] thongTinDonGH = lines.split("#");
                String maDonGH = thongTinDonGH[0];
                String maDH = thongTinDonGH[1];
                Date ngayGiaoHang = KiemTra.chuyenChuoiThanhDate(thongTinDonGH[2]);
                String diaChiGH = thongTinDonGH[3];
                int phiGiaoHang = Integer.parseInt(thongTinDonGH[4]);
                String phuongThucGH = thongTinDonGH[5];

                GiaoHang GiaoHang = new GiaoHang(maDonGH, maDH, ngayGiaoHang, diaChiGH, phiGiaoHang, phuongThucGH);
                DS_GiaoHang.add(GiaoHang);
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
