package BT2;

public class HinhChuNhat extends Hinh{
    private double chieuDai,chieuRong;

    public HinhChuNhat(String tenHinh, double chieuDai, double chieuRong) {
        super(tenHinh);
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    @Override
    public double tinhChuvi() {
        return (chieuDai+chieuRong)*2;
    }

    @Override
    public double tinhDienTich() {
        return chieuDai*chieuRong;
    }
}
