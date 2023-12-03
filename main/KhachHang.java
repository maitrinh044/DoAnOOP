package main;

public class KhachHang {
    private String maKH;
    private String tenKH;
    private String diaChi;
    private String dienThoai;

    //Constructor
    public KhachHang() {

    }

    public KhachHang(String maKH, String tenKH, String diaChi, String dienThoai) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
    }

    //Getter - Setter
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public void inThongTin() {
        System.out.printf("|%-5s|%-25s|%-30s|%-10s|\n",
                           maKH, tenKH, diaChi, dienThoai);
    }
}
