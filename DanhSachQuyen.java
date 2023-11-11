import java.util.Arrays;

public class DanhSachQuyen {
    private static int soLuongQuyen;
    private Quyen arrQuyen[];

    public DanhSachQuyen()
    {
        soLuongQuyen = 3;
        arrQuyen = new Quyen[soLuongQuyen];
        arrQuyen[0] = new Quyen();
            arrQuyen[0].setMaQuyen(0);
            arrQuyen[0].setTenQuyen("Admin");
        arrQuyen[1] = new Quyen();
            arrQuyen[1].setMaQuyen(1);
            arrQuyen[1].setTenQuyen("Manager");
        arrQuyen[2] = new Quyen();
            arrQuyen[2].setMaQuyen(2);
            arrQuyen[2].setTenQuyen("User");
    }

    public void themQuyen()
    {
        soLuongQuyen++;
        arrQuyen = Arrays.copyOf(arrQuyen, soLuongQuyen);
        arrQuyen[soLuongQuyen] = new Quyen();
        arrQuyen[soLuongQuyen].setMaQuyen();
        arrQuyen[soLuongQuyen].setTenQuyen();
    }
}
