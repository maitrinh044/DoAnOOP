package DanhSach;

import main.KhachHang;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import KiemTra.KiemTra;

public class DanhSachKhachHang {

    Scanner sc = new Scanner(System.in);
    KiemTra kiemTra = new KiemTra();
    private List<KhachHang> DS_KhachHang;

    public DanhSachKhachHang() {
        this.DS_KhachHang = new ArrayList<>();
    }

    public int soLuongKhachHang() {
        return DS_KhachHang.size();
    }

    public List<KhachHang> getDanhSachKhachHang() {
        return DS_KhachHang;
    }

    //Start: Tạo Menu quản lý Danh Sách Khách Hàng
    public void quanLyKhachHang() {
        while(true) {
            System.out.println("==================== QUẢN LÝ DANH SÁCH KHÁCH HÀNG ====================");
            System.out.println("\t\t\t1. Thêm (các) khách hàng mới vào danh sách.");
            System.out.println("\t\t\t2. Xem danh sách khách hàng.");
            System.out.println("\t\t\t3. Tìm kiếm khách hàng theo mã KH.");
            System.out.println("\t\t\t4. Tìm kiếm khách hàng theo tên KH.");
            System.out.println("\t\t\t5. Cập nhật khách hàng dựa theo mã KH.");
            System.out.println("\t\t\t6. Xóa một khách hàng khỏi danh sách.");
            System.out.println("\t\t\t7. Xóa tất cả khách hàng có trong danh sách.");
            System.out.println("\t\t\t8. Ghi danh sách khách hàng vào file.");
            System.out.println("\t\t\t9. Đọc danh sách khách hàng từ file.");
            System.out.println("======================================================================");

            System.out.print("Nhập lựa chọn của bạn: ");
            int luaChon = KiemTra.kiemTraSoNguyenDuong();

            switch(luaChon) {
                case 1:
                    themKhachHang();
                    break;
                case 2:
                    inDanhSachKhachHang();
                    break;
                case 3:
                    timKiemKhachHangTheoMaKH();
                    break;
                case 4:
                    timKiemKhachHangTheoTenKH();
                    break;
                case 5:
                    capNhatThongTinKhachHang();
                    break;
                case 6:
                    xoaMotKhachHang();
                    break;
                case 7:
                    xoaTatCaKhachHang();
                    break;
                case 8:
                    ghiDanhSachKhachHangVaoFile("DanhSachKhachHang.txt");
                    break;
                case 9:
                    docDanhSachKhachHangTuFile("DanhSachKhachHang.txt");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
            }

            //Hỏi người dùng có muốn tiếp tục chọn hay không?
            System.out.print("\nBạn có muốn tiếp tục với Danh Sách Khách Hàng không? (y/n): ");
            String tiepTuc = KiemTra.tiepTuc();
            if(tiepTuc.equals("n")) {
                System.out.println("\nThoát khỏi Quản lý Danh sách Khách hàng...");
                break;
            } 
        }
    }
    //End: Tạo Menu quản lý Danh Sách Khách Hàng

    //1. Phương thức thêm một (nhiều) khách hàng vào danh sách
    private void themKhachHang() {
        System.out.print("Nhập số lượng khách hàng cần thêm: ");
        int soLuong = KiemTra.kiemTraSoNguyenDuong();
        
        //Thêm khách hàng vào danh sách
        String maKH;
        for(int i = 0; i < soLuong; i++) {
            System.out.println("------------------------------");
            System.out.println("Nhập thông tin khách hàng #" + (i+1));
            //Kiểm tra mã KH đã có trong danh sách chưa (tránh trùng mã KH)
            while(true) {
                System.out.print("Nhập mã khách hàng: ");
                maKH = KiemTra.kiemTraNhapMaKH();
                KhachHang kh = timKiemKhachHangTheoMaKH(maKH);

                if(kh == null)  //mã KH chưa có trong danh sách, thoát khỏi vòng lặp
                    break;
                else
                    System.out.println("Đã có mã khách hàng trong danh sách! Vui lòng nhập mã KH khác!");
            }           
            System.out.print("Nhập tên khách hàng: ");
            String tenKH = KiemTra.kiemTraNhapTen();
            System.out.print("Nhập địa chỉ khách hàng: ");
            String diaChi = KiemTra.kiemTraNhapChuoi();
            System.out.print("Nhập số điện thoại khách hàng: ");
            String dienThoai = KiemTra.kiemTraNhapSDT();
            
            //Tạo một đối tượng khách hàng mới
            KhachHang khachHangMoi = new KhachHang(maKH, tenKH, diaChi, dienThoai);
            //Thêm đối tượng khách hàng mới vào danh sách
            DS_KhachHang.add(khachHangMoi);

            System.out.println("Đã thêm khách hàng mã số " + maKH + " vào danh sách thành công!");
        }
    }

    //2. Phương thức in danh sách khách hàng
    private void inDanhSachKhachHang() {
        if(DS_KhachHang.isEmpty()){
            System.out.println("Danh sách khách hàng đang rỗng!");
        }
        else {
            System.out.println("DANH SÁCH KHÁCH HÀNG: (" + soLuongKhachHang() + " khách hàng)");
            System.out.printf("|%-5s|%-25s|%-30s|%-10s|\n",
                            "Mã KH", "Tên Khách Hàng", "Địa chỉ", "Số ĐT");
            for (KhachHang khachHang : DS_KhachHang) {
                khachHang.inThongTin();
            }
        }
    }

    
    //3a. Phương thức tìm kiếm khách hàng dựa vào mã KH được truyền qua tham số
    //Phục vụ cho phương thức cập nhật và xóa
    private KhachHang timKiemKhachHangTheoMaKH(String maKHCanTim) {
        for (KhachHang khachHang : DS_KhachHang) {
            if(khachHang.getMaKH().equalsIgnoreCase(maKHCanTim)) {
                return khachHang;
            }
        }
        //nếu không thấy thì trả về null
        return null;
    }

    //3b. Phương thức tìm kiếm khách hàng dựa vào mã KH được nhập vào từ bàn phím
    private void timKiemKhachHangTheoMaKH() {
        System.out.print("Nhập mã khách hàng cần tìm: ");
        String maKH = KiemTra.kiemTraNhapMaKH();

        for (KhachHang khachHang : DS_KhachHang) {
            if(khachHang.getMaKH().equalsIgnoreCase(maKH)) {
                System.out.println("------------------------------");
                System.out.println("Thông tin khách hàng cần tìm:");
                System.out.printf("|%-5s|%-25s|%-30s|%-10s|\n",
                                 "Mã KH", "Tên Khách Hàng", "Địa chỉ", "Số ĐT");
                khachHang.inThongTin();
                return;
            }
        }

        System.out.println("Không tìm thấy khách hàng có mã " + maKH + " trong danh sách!");
    }

    //4. Phương thức tìm kiếm khách hàng dựa vào tên (chính xác hoặc gần đúng)
    private void timKiemKhachHangTheoTenKH() {  
        System.out.print("Nhập tên khách hàng cần tìm: ");
        String tenKHCanTim = KiemTra.kiemTraNhapTen();

        boolean timThay = false;

        for (KhachHang khachHang : DS_KhachHang) {
            if(khachHang.getTenKH().equalsIgnoreCase(tenKHCanTim) || khachHang.getTenKH().contains(tenKHCanTim)) {
                System.out.println("------------------------------");
                System.out.println("Thông tin khách hàng cần tìm:");
                System.out.printf("|%-5s|%-25s|%-30s|%-10s|\n",
                                 "Mã KH", "Tên Khách Hàng", "Địa chỉ", "Số ĐT");
                khachHang.inThongTin();
                timThay =  true;
            }
        }

        if(!timThay){
            System.out.println("Không tìm thấy khách hàng có tên \"" + tenKHCanTim + "\" trong danh sách!");
        }
    }


    //5. Phương thức cập nhật thông tin khách hàng
    private void capNhatThongTinKhachHang() {
        System.out.print("Nhập mã khách hàng cần cập nhật: ");
        String maKH = KiemTra.kiemTraNhapMaKH();

        KhachHang khachHang = timKiemKhachHangTheoMaKH(maKH);

        if(khachHang != null) {
            System.out.println("Thông tin khách hàng cần cập nhật:");
            khachHang.inThongTin();

            while(true) {
                System.out.println("---------- Cập Nhật Hồ Sơ Khách Hàng ----------");
                System.out.println("\t\t1. Cập nhật mã khách hàng.");
                System.out.println("\t\t2. Cập nhật tên khách hàng.");
                System.out.println("\t\t3. Cập nhật địa chỉ khách hàng.");
                System.out.println("\t\t4. Cập nhật số điện thoại khách hàng.");
                System.out.println("-----------------------------------------------");
                System.out.print("Nhập thông tin cần cập nhật: ");
                int luaChon = KiemTra.kiemTraSoNguyenDuong();

                switch(luaChon) {
                    case 1:
                        System.out.print("Nhập mã KH mới: ");
                        String maKHMoi = KiemTra.kiemTraNhapMaKH();
                        khachHang.setMaKH(maKHMoi);
                        break;
                    case 2:
                        System.out.print("Nhập tên KH mới: ");
                        String tenKHMoi = KiemTra.kiemTraNhapTen();
                        khachHang.setTenKH(tenKHMoi);
                        break;
                    case 3:
                        System.out.print("Nhập địa chỉ mới: ");
                        String diaChiMoi = KiemTra.kiemTraNhapChuoi();
                        khachHang.setDiaChi(diaChiMoi);
                        break;
                    case 4:
                        System.out.print("Nhập số điện thoại mới: ");
                        String sdtMoi = KiemTra.kiemTraNhapSDT();
                        khachHang.setDienThoai(sdtMoi);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }

                System.out.print("\nBạn có muốn tiếp tục cập nhật không? (y/n): ");
                String tiepTuc = KiemTra.tiepTuc();
                if(tiepTuc.equals("n")) {
                    System.out.println("Cập nhật hoàn tất!");
                    System.out.println("Thông tin khách hàng sau khi cập nhật:");
                    khachHang.inThongTin();
                    break; 
                }
            }
        }
        else {
            System.out.println("Không tìm thấy khách hàng có mã " + maKH + " để cập nhật!");
            System.out.print("Bạn có muốn nhập lại mã KH không? (y/n): ");
            String tiepTuc = KiemTra.tiepTuc();
            if(tiepTuc.equals("y"))
                capNhatThongTinKhachHang();
        }
    }

    //6. Phương thức xóa một khách hàng khỏi danh sách dựa vào mã số KH do người dùng nhập vào
    private void xoaMotKhachHang() {
        System.out.print("Nhập mã KH cần xóa: ");
        String maKHXoa = KiemTra.kiemTraNhapMaKH();

        //Tìm kiem khách hàng có mã KH cần xóa
        KhachHang khachHang = timKiemKhachHangTheoMaKH(maKHXoa);

        if(khachHang != null) {
            int index = DS_KhachHang.indexOf(khachHang);
            DS_KhachHang.remove(index);
            System.out.println("Đã xóa khách hàng có mã " + maKHXoa + " thành công!");
        }
        else {
            System.out.println("Không tìm thấy khách hàng có mã " + maKHXoa + " để xóa!");
            System.out.print("Bạn có muốn nhập lại mã KH không? (y/n): ");
            String tiepTuc = KiemTra.tiepTuc();
            if(tiepTuc.equals("y"))
                xoaMotKhachHang();
        }
    }

    //7. Phương thức xóa tất cả khách hàng có trong danh sách
    private void xoaTatCaKhachHang() {
        if(DS_KhachHang.isEmpty()) {
            System.out.println("Danh sách Khách hàng đang rỗng, không có khách hàng để xóa!");
        }
        else {
            DS_KhachHang.clear();
            System.out.println("Đã xóa tất cả khách hàng khỏi danh sách!");
        }
    }

    //8. Phương thức ghi danh sách khách hàng vào file
    public void ghiDanhSachKhachHangVaoFile(String tenFile) {
        if(DS_KhachHang.isEmpty()) {
            System.out.println("Danh sách khách hàng đang rỗng!");
            return;
        }
        try {
            FileWriter fw = new FileWriter(tenFile);
            BufferedWriter bw = new BufferedWriter(fw);

            for (KhachHang khachHang : DS_KhachHang) {
                bw.write(khachHang.getMaKH() + "#" + khachHang.getTenKH() + "#" + khachHang.getDiaChi() + "#" + khachHang.getDienThoai());
                bw.newLine();
            }

            bw.close();
            fw.close();

            System.out.println("Đã ghi danh sách khách hàng vào file thành công!");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    //9. Phương thức đọc danh sách khách hàng từ file
    public void docDanhSachKhachHangTuFile(String tenFile) {
        try {
            DS_KhachHang.clear();
            FileReader fr = new FileReader(tenFile);
            BufferedReader br = new BufferedReader(fr);

            String lines;
            while((lines = br.readLine()) != null) {
                String[] thongTinKH = lines.split("#");
                KhachHang khachHang = new KhachHang(thongTinKH[0], thongTinKH[1], thongTinKH[2], thongTinKH[3]);
                DS_KhachHang.add(khachHang);
            }

            br.close();
            fr.close();

            System.out.println("Đã đọc danh sách khách hàng từ file thành công!");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
