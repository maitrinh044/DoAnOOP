package KiemTra;

import java.util.*;

/*
@author made by Quỳnh Hương with luv 💖
*/

public class KiemTra {
    static transient Scanner sc = new Scanner(System.in);

    public static String kiemTraNhapChuoi() {
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            dauVao = dauVao.trim();   //Xóa khoảng trắng đầu chuỗi và cuối chuỗi
            if (dauVao != null) {
                return dauVao;
            }
            else{
                System.out.println("Không được bỏ trống chuỗi! Mời nhập lại chuỗi: ");
            }
        }
    }

    //Start: ID CHECK
    public static String kiemTraNhapMaKH() {
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            dauVao = dauVao.trim().toUpperCase();
            if(!dauVao.isEmpty() && dauVao.matches("KH" + "[0-9]{3}")) {
                return dauVao;
            }
            else {
                System.out.println("Nhập sai định dạng mã khách hàng: KH___. Ví dụ: KH001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }

    public static String kiemTraNhapMaNhaCC() { 
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            dauVao = dauVao.trim().toUpperCase();
            if(!dauVao.isEmpty() && dauVao.matches("NCC" + "[0-9]{3}")) {
                return dauVao;
            }
            else {
                System.out.println("Nhập sai định dạng mã nhà cung cấp: NCC___. Ví dụ: NCC001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }

    public static String kiemTraNhapMaNV() {
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            dauVao = dauVao.trim().toUpperCase();
            if(!dauVao.isEmpty() && dauVao.matches("NV" + "[0-9]{3}")) {
                return dauVao;  
            }
            else {
                System.out.println("Nhập sai định dạng mã nhân viên: NV___. Ví dụ: NV001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }

    public static String kiemTraNhapMaSP() {
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            dauVao = dauVao.trim().toUpperCase();
            if(!dauVao.isEmpty() && dauVao.matches("(SP)" + "[0-9]{3}")) {
                return dauVao;
            }
            else {
                System.out.println("Nhập sai định dạng mã sản phẩm: SP___. Ví dụ: SP001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }

    public static String kiemTraNhapMaDH() {
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            dauVao = dauVao.trim().toUpperCase();
            if(!dauVao.isEmpty() && dauVao.matches("DH" + "[0-9]{3}")) {
                                                            //  "\d{0,3}
                return dauVao;
            }
            else {
                System.out.println("Nhập sai định dạng mã đơn hàng: DH___. Ví dụ: DH001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }

    public static String kiemTraNhapMaCTDH() {
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            dauVao = dauVao.trim().toUpperCase();
            if(!dauVao.isEmpty() && dauVao.matches("DH" + "[0-9]{3}" + "_" + "[0-9]{1,3}")) {
                                                            //VÍ DỤ: DH001_1
                return dauVao;
            }
            else {
                System.out.println("Nhập sai định dạng mã chi tiết đơn hàng. Ví dụ: DH001_1");
            }
            System.out.print("Mời nhập lại: ");
        }
    }

    public static String kiemTraNhapMaKM() {
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            dauVao = dauVao.trim().toUpperCase();
            if(!dauVao.isEmpty() && dauVao.matches("KM" + "[0-9]{3}")) {
                return dauVao;
            }
            else {
                System.out.println("Nhập sai định dạng mã khuyến mãi: KM___. Ví dụ: KM001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }

    public static String kiemTraNhapMaPN() {
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            dauVao = dauVao.trim().toUpperCase();
            if(!dauVao.isEmpty() && dauVao.matches("PN" + "[0-9]{3}")) {
                return dauVao;
            }
            else {
                System.out.println("Nhập sai định dạng mã phiếu nhập: PN___. Ví dụ: PN001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }

    public static String kiemTraNhapMaNL() {
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            dauVao = dauVao.trim().toUpperCase();
            if(!dauVao.isEmpty() && dauVao.matches("NL" + "[0-9]{3}")) {
                return dauVao;
            }
            else {
                System.out.println("Nhập sai định dạng mã nguyên liệu: NL___. Ví dụ: NL001");
            }
            System.out.print("Mời nhập lại: ");
        }
    }
    //End: ID CHECK

    public static String kiemTraNhapTen() {
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            if(!dauVao.isEmpty() && dauVao.matches("[\\pL\\pMn*\\s*]+")) {
                //xóa ký tự khoảng trắng đầu và cuối chuỗi
                dauVao = dauVao.trim();
                //xóa các khoảng trắng dư trong chuỗi
                dauVao = dauVao.replaceAll("\\s+", " ");
                //viết hoa mỗi chữ cái đầu của mỗi từ
                dauVao = dauVao.toLowerCase();
                String[] chuoi = dauVao.split(" ");
                dauVao = "";
                for (int i = 0 ; i < chuoi.length ; i++) {
                    dauVao += String.valueOf(chuoi[i].charAt(0)).toUpperCase() + chuoi[i].substring(1);
                    //thêm khoảng trắng vào sau mỗi từ (trừ từ cuối)
                    if(i < chuoi.length - 1) {
                        dauVao += " ";
                    }
                }
                return dauVao;
            }
            else {
                System.out.print("Tên không hợp lệ! Vui lòng nhập lại: ");
            }
        }
    }

    public static String kiemTraNhapSDT() {
        String dauVao;
        while(true) {
            dauVao = sc.nextLine();
            dauVao = dauVao.trim();
            // Số đầu là số 0, sau đó là 9 đến 10 chữ số
            if(!dauVao.isEmpty() && dauVao.matches("0[0-9]{9,10}")) {
                return dauVao;
            }
            else {
                System.out.println("Sai định dạng số điện thoại: 0__________. Ví dụ: 0906666666");
            }
            System.out.print("Mời nhập lại: ");
        }
    }

    // Start: NUMBER CHECK
    public static int kiemTraNhapSoNguyen() {
        int dauVao;
        while(true) {
            try {
                dauVao = Integer.parseInt(sc.nextLine());
                return dauVao;
            }
            catch(NumberFormatException exception) {
                System.out.print("Sai kiểu dữ liệu! Vui lòng nhập lại: ");
            }
        }
    }

    public static int kiemTraSoNguyenDuong() {
        int dauVao;
        while(true) {
            dauVao = kiemTraNhapSoNguyen();
            if(dauVao > 0) {
                return dauVao;
            }
            else {
                System.out.print("Số nhập vào phải lớn hơn 0! Mời nhập lại: ");
            }
        }
    }

    public static Double kiemTraNhapSoThuc() {
        double dauVao;
        while(true) {
            try {
                dauVao = Double.parseDouble(sc.nextLine());
                return dauVao;
            }
            catch (NumberFormatException exception) {
                System.out.print("Nhập sai kiểu dữ liệu! Mời nhập lại: ");
            }
        }
    }

    public static Double kiemTraTienThuong() {
        double dauVao;
        while(true) {
            try {
                dauVao = Double.parseDouble(sc.nextLine());
                if(dauVao >= 0)
                    return dauVao;
                else
                    System.out.print("Tiền thưởng không thể nhỏ hơn 0! Mời nhập lại: ");
            }
            catch (NumberFormatException exception) {
                System.out.print("Nhập sai kiểu dữ liệu! Mời nhập lại: ");
            }
        }
    }
    // End: NUMBER CHECK

    // Start: CHOICE CHECK
    public static String tiepTuc() {
        String dauVao;
        String dinhDang = "[y|n]";
        while(true) {
            dauVao = sc.nextLine().trim();
            dauVao = dauVao.toLowerCase();
            if(!dauVao.isEmpty() && dauVao.matches(dinhDang)) {
                return dauVao;
            }
            else {
                System.out.print("Lựa chọn sai định dạng! Mời nhập lại: ");
            }
        }
    }
    // End: CHOICE CHECK

    //Start: DATE CHECK
    public static String kiemTraNgayThangNam() {
        String dauVao;
        String dinhDang = "\\d{1,2}/\\d{1,2}/\\d{4}";
        while(true) {
            dauVao = sc.nextLine().trim();
            if(!dauVao.isEmpty() && dauVao.matches(dinhDang) && kiemTraNgayThangNamHopLe(dauVao)) {
                return dauVao;
            }
            else {
                System.out.println("Ngày tháng năm không hợp lệ (dd/mm/yyyy)");
                System.out.print("Mời nhập lại: ");
            }
        }
    }

    //Kiểm tra năm nhuận
    public static boolean kiemTraNamNhuan(int nam) {
        return ((nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0));
    }

    //Kiểm tra ngày tháng hợp lệ
    public static boolean kiemTraNgayThangNamHopLe(String dauVao) {
        String[] ngayThangNam = dauVao.split("/");
        int ngay = Integer.parseInt(ngayThangNam[0]);
        int thang = Integer.parseInt(ngayThangNam[1]);
        int nam = Integer.parseInt(ngayThangNam[2]);

        if(thang < 1 || thang > 12 || nam < 0) {
            return false;
        }

        //kiểm tra số ngày trong tháng 2
        if(thang == 2) {
            if(kiemTraNamNhuan(nam)) {
                return (ngay >= 1 && ngay <= 29);
            }
            else {
                return (ngay >= 1 && ngay <= 28);
            }
        }

        //kiểm tra số ngày của tháng có 30 ngày
        if(thang == 4 || thang == 6 || thang == 9 || thang == 11) {
            return (ngay >= 1 && ngay <= 30);
        }

        //kiểm tra số ngày của tháng có 31 ngày
        return (ngay >= 1 && ngay <= 31);
    }
    //End: DATE CHECK
}
