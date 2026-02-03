package BT2;

public class HinhTron extends Hinh{
    private double banKinh;

    public HinhTron(String tenHinh, double banKinh) {
        super(tenHinh);
        this.banKinh = banKinh;
    }

    @Override
    public double tinhChuvi() {
        return 2*Math.PI*banKinh;
    }

    @Override
    public double tinhDienTich() {
        return Math.PI*banKinh*banKinh;
    }
}
