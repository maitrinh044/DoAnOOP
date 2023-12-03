package main;

public class GiaoHang {
    private String maGiaoHang;
    private String maDH;
    private String ngayGiaoHang;
    private String diaChiGH;
    private double phiGiaoHang;
    private String phuongThucGH;

    //Constructor
    public GiaoHang() {

    }

    public GiaoHang(String maGiaoHang, String maDH, String ngayGiaoHang, String diaChiGH, double phiGiaoHang, String phuongThucGH) {
        this.maGiaoHang = maGiaoHang;
        this.maDH = maDH;
        this.ngayGiaoHang = ngayGiaoHang;
        this.diaChiGH = diaChiGH;
        this.phiGiaoHang = phiGiaoHang;
        this.phuongThucGH = phuongThucGH;
    }

    //Getter - Setter
    public String getMaGiaoHang() {
        return maGiaoHang;
    }

    public void setMaGiaoHang(String maGiaoHang) {
        this.maGiaoHang = maGiaoHang;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public String getNgayGiaoHang() {
        return ngayGiaoHang;
    }

    public void setNgayGiaoHang(String ngayGiaoHang) {
        this.ngayGiaoHang = ngayGiaoHang;
    }

    public String getDiaChiGH() {
        return diaChiGH;
    }

    public void setDiaChiGH(String diaChiGH) {
        this.diaChiGH = diaChiGH;
    }

    public double getPhiGiaoHang() {
        return phiGiaoHang;
    }

    public void setPhiGiaoHang(double phiGiaoHang) {
        this.phiGiaoHang = phiGiaoHang;
    }

    public String getPhuongThucGH() {
        return phuongThucGH;
    }

    public void setPhuongThucGH(String phuongThucGH) {
        this.phuongThucGH = phuongThucGH;
    }
}
