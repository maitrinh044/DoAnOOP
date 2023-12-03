package DanhSach;

import main.*;
import KiemTra.*;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;


public class DanhSachSanPham implements QuanLiDS, ThongKeSoLuong{
    private static int soLuong;
    private static SanPham[] arrSP;

    // Constructor
    public DanhSachSanPham() {
        soLuong = 0;
        arrSP = new SanPham[soLuong];
        try {
            FileInputStream fis = new FileInputStream("./input/SanPham.txt");
            if (fis.available() > 0) {
                docFile(fis);
                fis.close();
            }
            else {
                soLuong = 10;
                arrSP = new SanPham[soLuong];
                arrSP[0] = new ThucAn("SP001", "Burger Tôm", 40000, "Burger Tôm - disc", 100, "Món Chính");
                arrSP[1] = new ThucAn("SP002", "Burger Bò", 40000, "Burger Bò - disc", 100, "Món Chính");
                arrSP[2] = new ThucAn("SP003", "Mì Ý", 40000, "Mì Ý - disc", 100, "Món Chính");
                arrSP[3] = new ThucAn("SP004", "Pizza Hải Sản", 70000, "Pizza Hải Sản - disc", 100, "Món Chính");
                arrSP[4] = new ThucAn("SP005", "Pizza Phô Mai", 60000, "Pizza Phô Mai - disc", 100, "Món Chính");
                arrSP[5] = new ThucAn("SP006", "Xúc Xích", 20000, "Xúc Xích - disc", 100, "Món Ăn Kèm");
                arrSP[6] = new ThucAn("SP007", "Phô Mai Que", 20000, "Phô Mai Que - disc", 100, "Món Ăn Kèm");
                arrSP[7] = new ThucUong("SP008", "Coca", 40000, "Coca - disc", 100, "Lớn");
                arrSP[8] = new ThucUong("SP009", "Pepsi", 40000, "Pepsi - disc", 100, "Lớn");
                arrSP[9] = new ThucUong("SP010", "Trà Đào", 40000, "Trà Đào - disc", 100, "Nhỏ");

                ghiFile();
            }            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ghi danh sách vào file DanhSachSanPham
    public void ghiFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./input/SanPham.txt"))) {
            for (int i = 0; i < soLuong; i++) {
                oos.writeObject(arrSP[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // đọc danh sách từ file DanhSachSanPham
    public void docFile(FileInputStream fis) {
        try {
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                try {
                    SanPham tmp = (SanPham) ois.readObject();
                    if (tmp instanceof ThucAn) {
                        ThucAn thucAn = (ThucAn) tmp;
                        themSanPham(thucAn);
                    } else if (tmp instanceof ThucUong) {
                        ThucUong thucUong = (ThucUong) tmp;
                        themSanPham(thucUong);
                    }
                } catch (EOFException e) {
                    // Đã đọc hết file
                    break;
                }
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 1. Thêm sản phẩm vào danh sách
    public void themSanPham() {
        do {
            System.out.println("1. Thức ăn");
            System.out.println("2. Thức uống");
            System.out.print("Chọn loại sản phẩm muốn thêm:");
            int luaChon = KiemTra.kiemTraNhapSoNguyen();
            switch (luaChon) {
                case 1:
                    ThucAn ta = new ThucAn();
                    ta.nhapSanPham();
                    arrSP = Arrays.copyOf(arrSP, ++soLuong);
                    arrSP[soLuong-1] = ta;
                    return;
                case 2:
                    ThucUong tu = new ThucUong();
                    tu.nhapSanPham();
                    arrSP = Arrays.copyOf(arrSP, ++soLuong);
                    arrSP[soLuong-1] = tu;
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
            }
        } while (true);
    }

    public void themSanPham(ThucAn a) {
        arrSP = Arrays.copyOf(arrSP, ++soLuong);
        arrSP[soLuong-1] = a;
        // a.xuatSanPham();
    }
    public void themSanPham(ThucUong a) {
        arrSP = Arrays.copyOf(arrSP, ++soLuong);
        arrSP[soLuong-1] = a;
    }

    // in danh sách sản phẩm
    public void xuatDSSP() {
        if (soLuong <= 0) {
            System.out.println("Danh sách sản phẩm trống!");            
            return;
        }
        System.out.println("DANH SÁCH SẢN PHẨM");
        System.out.printf("%-13s%-25s%-9s%-40s%-15s%-6s\n", "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Mô tả", "Loại/Kích cỡ", "Còn lại" );
        for (int i = 0; i < soLuong; i++) {
            arrSP[i].xuatSanPham();
        }
    }

   

    // Phương thức tìm kiếm sản phẩm theo mã sản phẩm
    public static SanPham timKiemSanPhamTheoMaSP(String maSPCanTim) {
        for (int i = 0; i < soLuong; i++) {
            if (arrSP[i].getMaSP().equalsIgnoreCase(maSPCanTim)) {
                return arrSP[i];
            }
        }
        return null;
    }

    // Phương thức tìm kiếm theo tên sản phẩm
    public static SanPham timKiemSanPhamTheoTenSP(String tenSPCanTim) {
        for (int i = 0; i < soLuong; i++) {
            if (arrSP[i].getTenSP().equalsIgnoreCase(tenSPCanTim)) {
                return arrSP[i];
            }
        }
        return null;
    }

    public SanPham[] timKiemSanPhamTheoPham(String tenSP) {
        if (soLuong == 0 ) {
            return null;
        }
        else {
            int c=0;
            SanPham[] arr = new SanPham[0];
            for (int i=0; i<soLuong; i++) {
                if (arrSP[i].getTenSP().toLowerCase().contains(tenSP.toLowerCase()) == true) {
                    c++;
                    arr = Arrays.copyOf(arr, c);
                } 
            }
            if (arr == null) return null;
            else return arr;
        }
    }

    // Phương thức cập nhật thông tin sản phẩm theo masp
    public void capNhatThongTinSanPham(String masp) {
        if (timKiemSanPhamTheoMaSP(masp) == null) {
            System.out.println("Sản phẩm không tồn tại. Thoát!");
            return;
        }
        for (int i = 0; i < soLuong; i++) {
            arrSP[i].suaSanPham();
        }
    }
    

    // Xóa sản phẩm ra khỏi danh sách theo mã sản phẩm
    public void xoaSanPham(String masp) {
        System.out.print("Bạn có muốn xóa sản phẩm?(1. Có - 2. Không)");
        int opt = KiemTra.kiemTraNhapSoNguyen();
        if (opt == 1) {
            int i, j;
            SanPham[] arrSP_new = Arrays.copyOf(arrSP, soLuong);
            arrSP = new SanPham[soLuong-1];
            for (i = 0, j = 0; i < soLuong; i++) {
                if (!arrSP_new[i].getMaSP().equalsIgnoreCase(masp)) {
                    arrSP[j] = arrSP_new[i];
                    j++;
                }
            }
            soLuong--;
        }
        else {
            return;
        }
    }

    // Xóa tất cả các sản phẩm trong danh sách
    public void xoaDanhSachSanPham() {
        System.out.print("Bạn có muốn xóa tất cả sản phẩm?(1. Có - 2. Không)");
        int opt = KiemTra.kiemTraNhapSoNguyen();
        if (opt == 1) {
            arrSP = Arrays.copyOf(arrSP, 0);
            soLuong = 0;
            System.out.println("Đã xóa toàn bộ sản phẩm hiện có.");
        }
        else return;
    }

    @Override
    public long thongKeSoLuong() {
        long s = 0;
        for (int i=0; i<soLuong; i++) {
            s += arrSP[i].getSoLuong();
        }
        return s;
    }


// Start: Menu quản lý sản phẩm
    @Override
    public void quanLiDS() {
        String tiepTuc;
        do {
            String masp;
            System.out.println("================== QUẢN LÝ SẢN PHẨM ==================");
            System.out.println("\t\t\t1. Thêm một sản phẩm vào danh sách.");
            System.out.println("\t\t\t2. In danh sách sản phẩm.");
            System.out.println("\t\t\t3. Tìm kiếm sản phẩm theo mã sản phẩm.");
            System.out.println("\t\t\t4. Tìm kiếm sản phẩm theo tên sản phẩm.");
            System.out.println("\t\t\t5. Cập nhật thông tin sản phẩm sản phẩm.");
            System.out.println("\t\t\t6. Xóa một sản phẩm khỏi danh sách theo mã sản phẩm.");
            System.out.println("\t\t\t7. Xóa tất cả sản phẩm khỏi danh sách.");
            System.out.println("======================================================");

            System.out.print("Nhập lựa chọn của bạn: ");
            int luaChon = KiemTra.kiemTraNhapSoNguyen();

            switch (luaChon) {
                case 1:
                    themSanPham();
                    ghiFile();
                    break;
                case 2:
                    xuatDSSP();
                    break;
                case 3:
                    System.out.print("Hãy nhập mã sản phẩm mà bạn muốn tìm: ");
                    masp = KiemTra.kiemTraNhapChuoi();
                    SanPham a = timKiemSanPhamTheoMaSP(masp);
                    a.xuatSanPham();
                    break;
                case 4:
                    System.out.print("Hãy nhập tên sản phẩm mà bạn muốn tìm: ");
                    String tensp = KiemTra.kiemTraNhapChuoi();
                    SanPham b = timKiemSanPhamTheoTenSP(tensp);
                    b.xuatSanPham();
                    break;
                case 5:
                    System.out.print("Nhập mã sản phẩm mà bạn muốn cập nhật: ");
                    masp = KiemTra.kiemTraNhapChuoi();
                    capNhatThongTinSanPham(masp);
                    ghiFile();
                    break;
                case 6:
                    System.out.print("Nhập mã sản phẩm mà bạn muốn xóa: ");
                    masp = KiemTra.kiemTraNhapChuoi();
                    xoaSanPham(masp);
                    ghiFile();
                    break;
                case 7:
                    xoaDanhSachSanPham();
                    ghiFile();
                    System.out.println("Đã xóa danh sách sản phẩm.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
            }
        
            System.out.println("Bạn có muốn tiếp tục các thao tác trên? (y/n)");
            System.out.print("Lựa chọn: ");
            tiepTuc = KiemTra.tiepTuc();
        }
        while (tiepTuc.equals("y"));
    }
    // End: Menu quản lý sản phẩm

}