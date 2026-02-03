package BT1;

public class GiangVien extends Person{
    private String maGV;
    private double luongThang;

    public GiangVien(String hoTen, String diaChi, int namSinh, String maGV, double luongThang) {
        super(hoTen, diaChi, namSinh);
        this.maGV = maGV;
        this.luongThang = luongThang;
    }
    @Override
    public String getLoai() {
        return "Giang vien";
    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Ma GV: "+maGV);
        System.out.println("Luong thang: "+luongThang);
    }
}
