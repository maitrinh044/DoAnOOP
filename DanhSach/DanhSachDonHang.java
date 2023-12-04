package DanhSach;

import KiemTra.KiemTra;
import main.DonHang;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
    TODO: 1. Thêm (các) đơn hàng vào danh sách.
          2. Xem danh sách đơn hàng.
          3. Tìm kiếm đơn hàng theo mã đơn hàng.
          4. Tìm kiếm (các) đơn hàng theo mã nhân viên.
          5. Tìm kiếm (các) đơn hàng theo mã khách hàng.
          6. Cập nhật thông tin đơn hàng.
          7. Xóa một đơn hàng khỏi danh sách.
          8. Xóa đơn hàng nhân viên có trong danh sách.
          9. Ghi danh sách đơn hàng vào file.
          10. Đọc danh sách đơn hàng từ file.
 */

public class DanhSachDonHang {
    private List<DonHang> DS_DonHang;
    KiemTra kiemTra = new KiemTra();

    //Constructor
    public DanhSachDonHang() {
        this.DS_DonHang = new ArrayList<>();
    }

    //Phương thức trả về số lượng đơn hàng
    private int soLuongDonHang() {
        return DS_DonHang.size();
    }

    //Phương thức trả về danh sách đơn hàng
    private List<DonHang> getDS_DonHang() {
        return DS_DonHang;
    }

    //Start: Menu
    public void quanLyDonHang() {
        while(true) {
            System.out.println("==================== QUẢN LÝ DANH SÁCH ĐƠN HÀNG ====================");
            System.out.println("\t\t\t1. Thêm đơn hàng vào danh sách.");
            System.out.println("\t\t\t2. Xem danh sách đơn hàng.");
            System.out.println("\t\t\t3. Tìm kiếm đơn hàng theo mã đơn hàng.");
            System.out.println("\t\t\t4. Tìm kiếm (các) đơn hàng theo mã nhân viên.");
            System.out.println("\t\t\t5. Tìm kiếm (các) đơn hàng theo mã khách hàng.");
            System.out.println("\t\t\t6. Cập nhật thông tin đơn hàng.");
            System.out.println("\t\t\t7. Xóa một đơn hàng khỏi danh sách.");
            System.out.println("\t\t\t8. Xóa tất cả đơn hàng trong danh sách.");
            System.out.println("\t\t\t9. Ghi danh sách đơn hàng vào file.");
            System.out.println("\t\t\t8. Đọc danh sách đơn hàng từ file.");
            System.out.println("======================================================================");

            System.out.print("Nhập lựa chọn của bạn: ");
            int luaChon = KiemTra.kiemTraSoNguyenDuong();

            switch(luaChon) {
                case 1:
                    themDonHang();
                    break;
                case 2:
                    inDanhSachDonHang();
                    break;
                case 3:
                    timKiemDonHangTheoMaDH();
                    break;
                case 4:
                    timKiemDonHangTheoMaNV();
                    break;
                case 5:
                    timKiemDonHangTheoMaKH();
                    break;
                case 6:
                    capNhatThongTinDonHang();
                    break;
                case 7:
                    xoaMotDonHang();
                    break;
                case 8:
                    xoaTatCaDonHang();
                    break;
                case 9:
                    ghiDanhSachDonHangVaoFile("DanhSachDonHang.txt");
                    break;
                case 10:
                    docDanhSachDonHangTuFile("DanhSachDonHang.txt");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }

            // * Tiếp tục menu?
            System.out.print("\nBạn có muốn tiếp tục với Quản lý Danh sách Đơn hàng không? (y/n): ");
            String tiepTuc = KiemTra.tiepTuc();
            if(tiepTuc.equalsIgnoreCase("n")) {
                System.out.println("Thoát khỏi Quản lý Danh sách Đơn hàng.");
                break;
            }
        }
    }
    //End: Menu

    //1. Phương thức thêm đơn hàng vào danh sách
    public void themDonHang() {
        System.out.print("Nhập số lượng đơn hàng muốn thêm: ");
        int soLuong = KiemTra.kiemTraSoNguyenDuong();

        for(int i = 0; i < soLuong; i++) {
            System.out.println("Đơn hàng thứ " + (i + 1) + ":");
            System.out.print("Nhập mã nhân viên: ");
            String maNV = KiemTra.kiemTraNhapMaNV();
            System.out.print("Nhập mã khách hàng: ");
            String maKH = KiemTra.kiemTraNhapMaKH();
            DonHang donHang = new DonHang(maNV, maKH);
        }
    }

    //2. Phương thức in danh sách đơn hàng
    public void inDanhSachDonHang() {
        System.out.println("-------------DANH SÁCH ĐON HÀNG-------------");
        System.out.printf("|%-10s|%-20s|%-10s|%-10s|%-10s|\n",
                           "Mã đơn hàng", "Ngày lập đơn", "Mã NV", "Mã KH", "Tổng tiền");
        for(DonHang donHang : DS_DonHang) {
            donHang.inThongTinDonHang();
        }
    }

    //3. Phương thức tìm kiếm đơn hàng theo mã đơn hàng
    public DonHang timKiemDonHangTheoMaDH(String maDH) {
        for(DonHang donHang : DS_DonHang) {
            if(donHang.getMaDH().equalsIgnoreCase(maDH)) {
                return donHang;
            }
        }
        return null;
    }

    public void timKiemDonHangTheoMaDH() {
        System.out.print("Nhập mã đơn hàng cần tìm kiếm: ");
        String maDH = KiemTra.kiemTraNhapMaDH();
        for(DonHang donHang : DS_DonHang) {
            if(donHang.getMaDH().equalsIgnoreCase(maDH)) {
                System.out.println("Đơn hàng cần tìm kiếm là: ");
                System.out.printf("|%-5s|%-20s|%-5s|%-5s|%-10s|\n",
                                   "Mã ĐH", "Ngày lập đơn", "Mã NV", "Mã KH", "Tổng tiền");
                donHang.inThongTinDonHang();
                return;
            }
        }
    }

    //4. Phương thức tìm kiếm (các) đơn hàng theo mã nhân viên
    public void timKiemDonHangTheoMaNV() {
        System.out.print("Nhập mã nhân viên cần tìm kiếm: ");
        String maNV = KiemTra.kiemTraNhapMaNV();

        boolean timThay = false;

        for (DonHang donHang : DS_DonHang) {
            if(donHang.getMaNV().equalsIgnoreCase(maNV)) {
                System.out.println("Các đơn hàng cần tìm kiếm là: ");
                System.out.printf("|%-5s|%-20s|%-5s|%-5s|%-10s|\n",
                                   "Mã ĐH", "Ngày lập đơn", "Mã NV", "Mã KH", "Tổng tiền");
                donHang.inThongTinDonHang();
                timThay = true;
            }
        }

        if(!timThay) {
            System.out.println("Không tìm thấy đơn hàng nào có mã nhân viên là " + maNV);
        }
    }

    //5. Phương thức tìm kiếm (các) đơn hàng theo mã khách hàng
    public void timKiemDonHangTheoMaKH() {
        System.out.print("Nhập mã khách hàng cần tìm kiếm: ");
        String maKH = KiemTra.kiemTraNhapMaKH();

        boolean timThay = false;

        for (DonHang donHang : DS_DonHang) {
            if(donHang.getMaKH().equalsIgnoreCase(maKH)) {
                System.out.println("Các đơn hàng cần tìm kiếm là: ");
                System.out.printf("|%-5s|%-20s|%-5s|%-5s|%-10s|\n",
                                   "Mã ĐH", "Ngày lập đơn", "Mã NV", "Mã KH", "Tổng tiền");
                donHang.inThongTinDonHang();
                timThay = true;
            }
        }

        if(!timThay) {
            System.out.println("Không tìm thấy đơn hàng nào có mã khách hàng là " + maKH);
        }
    }

    //6. Phương thức cập nhật thông tin đơn hàng
    public void capNhatThongTinDonHang() {
        
    }

            // * Tiếp tục cập nhật?
            System.out.print("\nBạn có muốn tiếp tục cập nhật thông tin đơn hàng không? (y/n): ");
            String tiepTuc = KiemTra.tiepTuc();
            if(tiepTuc.equalsIgnoreCase("n")) {
                System.out.println("Cập nhật đơn hàng hoàn tất.");
                System.out.println("Thông tin đơn hàng sau khi cập nhật là: ");
                System.out.printf("|%-5s|%-20s|%-5s|%-5s|%-10s|\n",
                                   "Mã ĐH", "Ngày lập đơn", "Mã NV", "Mã KH", "Tổng tiền");
                donHang.inThongTinDonHang();
                break;
            }
        }
    }

    //7. Phương thức xóa một đơn hàng khỏi danh sách
    public void xoaMotDonHang() {
        System.out.print("Nhập mã đơn hàng cần xóa: ");
        String maDH = KiemTra.kiemTraNhapMaDH();
        DonHang donHang = timKiemDonHangTheoMaDH(maDH);

        if(donHang == null) {
            System.out.println("Không tìm thấy đơn hàng nào có mã " + maDH);
            return;
        }

        System.out.println("Đơn hàng cần xóa là: ");
        System.out.printf("|%-5s|%-20s|%-5s|%-5s|%-10s|\n",
                           "Mã ĐH", "Ngày lập đơn", "Mã NV", "Mã KH", "Tổng tiền");
        donHang.inThongTinDonHang();

        System.out.print("Bạn có chắc chắn muốn xóa đơn hàng này? (y/n): ");
        String xacNhan = KiemTra.tiepTuc();
        if(xacNhan.equalsIgnoreCase("y")) {
            DS_DonHang.remove(donHang);
            System.out.println("Xóa đơn hàng thành công.");
        } else {
            System.out.println("Đã hủy xóa đơn hàng.");
        }
    }

    //8. Phương thức xóa tất cả đơn hàng trong danh sách
    public void xoaTatCaDonHang() {
        System.out.print("Bạn có chắc chắn muốn xóa tất cả đơn hàng? (y/n): ");
        String xacNhan = KiemTra.tiepTuc();
        if(xacNhan.equalsIgnoreCase("y")) {
            DS_DonHang.clear();
            System.out.println("Xóa tất cả đơn hàng thành công.");
        } else {
            System.out.println("Đã hủy xóa tất cả đơn hàng.");
        }
    }

    //9. Phương thức ghi danh sách đơn hàng vào file
    public void ghiDanhSachDonHangVaoFile(String tenFile) {
        if(DS_DonHang.isEmpty()) {
            System.out.println("Danh sách đơn hàng rỗng.");
            return;
        }

        try {
            FileWriter fw = new FileWriter(tenFile);
            BufferedWriter bw = new BufferedWriter(fw);

            for (DonHang donHang : DS_DonHang) {
                bw.write(donHang.getMaDH() + "#" + donHang.getNgayLapDon() + "#" + donHang.getMaNV() + "#" + donHang.getMaKH() + "#" + donHang.tongTienHoaDon());
                bw.newLine();
            }

            bw.close();
            fw.close();

            System.out.println("Ghi danh sách đơn hàng vào file thành công.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //10. Phương thức đọc danh sách đơn hàng từ file
    public void docDanhSachDonHangTuFile(String tenFile) {
        try {
            FileReader fr = new FileReader(tenFile);
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            while((line = br.readLine()) != null) {
                String[] thongTinDH = line.split("#");
                String maDH = thongTinDH[0];
                Date ngayLapDon = null;
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    ngayLapDon = dateFormat.parse(thongTinDH[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String maNV = thongTinDH[2];
                String maKH = thongTinDH[3];
                DonHang donHang = new DonHang(maDH, ngayLapDon, maNV, maKH);
                DS_DonHang.add(donHang);
            }

            br.close();
            fr.close();

            System.out.println("Đọc danh sách đơn hàng từ file thành công.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
