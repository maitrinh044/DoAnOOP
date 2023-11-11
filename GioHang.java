import java.util.ArrayList;

public class GioHang {
    private String maGioHang;
    private String maTaiKhoan;
    private ArrayList<ChiTietGioHang> ChiTiet = new ArrayList<>();
    
    // constructor
    public GioHang()
    {
        maGioHang ="";
        maTaiKhoan="";
    }

    public GioHang(String maGioHang, String maTaiKhoan) 
    {
        this.maGioHang = maGioHang;
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getMaGioHang() {
        return maGioHang;
    }

    public void setMaGioHang(String maGioHang) {
        this.maGioHang = maGioHang;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public ArrayList<ChiTietGioHang> getChiTiet() {
        return ChiTiet;
    }

    public void setChiTiet(ArrayList<ChiTietGioHang> chiTiet) {
        ChiTiet = chiTiet;
    }
    
    
}
