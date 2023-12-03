package DanhSach;

import KiemTra.KiemTra;
import main.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DanhSachCTDonHang {
    private int soCTDonHangTiepTheo;
    public List<ChiTietDonHang> DS_CTDonHang;
    // KiemTra kiemTra = new KiemTra();

    //Constructor
    public DanhSachCTDonHang() {
        soCTDonHangTiepTheo = 1;
        this.DS_CTDonHang = new ArrayList<>();
        docDanhSachCTDHTuFile("./input/ChiTietDonHang.txt");
    }

    //Getter - Setter
    public int getSoCTDonHangTiepTheo() {
        return soCTDonHangTiepTheo;
    }

    public void setSoCTDonHangTiepTheo(int soCTDonHangTiepTheo) {
        this.soCTDonHangTiepTheo = soCTDonHangTiepTheo;
    }

    public List<ChiTietDonHang> getDS_CTDonHang() {
        return DS_CTDonHang;
    }

    public void setDS_CTDonHang(List<ChiTietDonHang> DS_CTDonHang) {
        this.DS_CTDonHang = DS_CTDonHang;
    }


    //Start: Menu Quản lý danh sách chi tiết đơn hàng
    public void quanLyDanhSachCTDH() {
        while(true) {
            System.out.println("=============== QUẢN LÝ DANH SÁCH CHI TIẾT ĐƠN HÀNG ===============");
            System.out.println("1. Thêm chi tiết đơn hàng");
            System.out.println("2. In danh sách chi tiết đơn hàng");
            System.out.println("3. Tìm kiếm chi tiết đơn hàng");
            System.out.println("4. Xóa một chi tiết đơn hàng");
            System.out.println("===================================================================");
            System.out.print("Nhập lựa chọn của bạn: ");
            int luaChon = KiemTra.kiemTraSoNguyenDuong();

            switch(luaChon) {
                case 1:
                    
                    break;
                case 2:
                    inDanhSachCTDH();
                    break;
                case 3:
                    timKiemCTDH();
                    break;
                case 4:
                    xoaMotCTDH();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại!");
            }

            System.out.print("Bạn có muốn tiếp tục Quản lý danh sách chi tiết đơn hàng không? (y/n): ");
            String tiepTuc = KiemTra.tiepTuc();
            if(tiepTuc.equalsIgnoreCase("n")) {
                System.out.println("Thoát khỏi Quản lý danh sách chi tiết đơn hàng...");
                break;
            }
        }
        ghiDanhSachCTDHVaoFile("./input/ChiTietDonHang");
    }
    //End: Menu Quản lý danh sách chi tiết đơn hàng


    //1. Thêm chi tiết đơn hàng


    //2. In danh sách chi tiết đơn hàng
    public void inDanhSachCTDH() {
        if(DS_CTDonHang.isEmpty()) {
            System.out.println("Danh sách chi tiết đơn hàng rỗng!");
            return;
        }

        System.out.println("---------- DANH SÁCH CHI TIẾT ĐƠN HÀNG ----------");
        for (ChiTietDonHang chiTietDonHang : DS_CTDonHang) {
            chiTietDonHang.inCTDonHang();
        }
        System.out.println("-------------------------------------------------");
    }

    //3. Tìm kiếm chi tiết đơn hàng
    public ChiTietDonHang timKiemCTDH(String maCTDH) {
        for (ChiTietDonHang chiTietDonHang : DS_CTDonHang) {
            if(chiTietDonHang.getMaCTDH().equalsIgnoreCase(maCTDH)) {
                return chiTietDonHang;
            }
        }
        return null;
    }

    public void timKiemCTDH() {
        System.out.print("Nhập mã chi tiết đơn hàng cần tìm kiếm: ");
        String maCTDH = KiemTra.kiemTraNhapMaCTDH();
        ChiTietDonHang chiTietDonHang = timKiemCTDH(maCTDH);

        if(chiTietDonHang == null) {
            System.out.println("Không tìm thấy chi tiết đơn hàng có mã " + maCTDH);
        }
        else {
            System.out.println("---------- CHI TIẾT ĐƠN HÀNG CẦN TÌM KIẾM ----------");
            chiTietDonHang.inCTDonHang();
            System.out.println("-----------------------------------------------------");
        }
    }

    //4. Xóa một chi tiết đơn hàng
    public void xoaMotCTDH() {
        System.out.print("Nhập mã chi tiết đơn hàng cần xóa: ");
        String maCTDH = KiemTra.kiemTraNhapMaCTDH();
        ChiTietDonHang chiTietDonHang = timKiemCTDH(maCTDH);

        if(chiTietDonHang == null) {
            System.out.println("Không tìm thấy chi tiết đơn hàng có mã " + maCTDH);
        }
        else {
            DS_CTDonHang.remove(chiTietDonHang);
            System.out.println("Xóa thành công chi tiết đơn hàng có mã " + maCTDH);
        }
    }

    //5. Ghi danh sách chi tiết đơn hàng vào file
    public void ghiDanhSachCTDHVaoFile(String tenFile) {
        try {
            FileWriter fw = new FileWriter(tenFile);
            BufferedWriter bw = new BufferedWriter(fw);

            for (ChiTietDonHang chiTietDonHang : DS_CTDonHang) {
                bw.write(chiTietDonHang.getMaCTDH() + "#" + chiTietDonHang.getMaSP() + "#" + chiTietDonHang.getSoLuong() + "#" + chiTietDonHang.getMaKM() + "#" + chiTietDonHang.thanhTien());
                bw.newLine();
            }

            bw.close();
            fw.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }


    //6. Đọc danh sách chi tiết đơn hàng từ file
    public void docDanhSachCTDHTuFile(String tenFile) {
        try {
            DS_CTDonHang.clear();

            FileReader fr = new FileReader(tenFile);
            BufferedReader br = new BufferedReader(fr);

            String data;
            while((data = br.readLine()) != null) {
                String[] arr = data.split("#");
                ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
                chiTietDonHang.setMaCTDH(arr[0]);
                chiTietDonHang.setMaSP(arr[1]);
                chiTietDonHang.setSoLuong(Integer.parseInt(arr[2]));
                chiTietDonHang.setMaKM(arr[3]);
                DS_CTDonHang.add(chiTietDonHang);
            }

            br.close();
            fr.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
