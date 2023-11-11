public class ChiTietGioHang {
    private String maGioHang;
    private String maSP;
    private int soLuong;
    private int donGia;

    public ChiTietGioHang()
    {
        maGioHang = "";
        maSP = "";
        soLuong = 0;
        donGia = 0;
    }

    public ChiTietGioHang(String maGioHang, String maSP, int soLuong, int donGia)
    {
        this.maGioHang = maGioHang;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    
}
