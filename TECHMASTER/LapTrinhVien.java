package TECHMASTER;

public class LapTrinhVien extends NhanVien {
    private int soGioOT;

    public LapTrinhVien(String maNV, String hoTen, double luongCoBan, int soGioOT) {
        super(maNV, hoTen, luongCoBan);
        this.soGioOT = soGioOT;
    }

    @Override
    public double tinhLuong() {
        return getLuongCoBan() + soGioOT * 200_000;
    }

    @Override
    public void lamViec() {
        System.out.println("Viết code và fix bug");
    }
}