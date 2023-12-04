import DanhSach.DanhSachDonHang;
import main.ChiTietDonHang;
import main.DonHang;

public class Main {
    public static void main(String[] args) {
        // run a = new run();
        // a.batDau();
        DonHang dh = new DonHang("DH001", "12/12/2023", "NV001", "KH001");
        ChiTietDonHang tmp = new ChiTietDonHang(dh, "SP001", 10, "KM001");
    }
}
