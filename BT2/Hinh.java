package BT2;

public abstract class Hinh implements IHinhHoc{
    private String tenHinh;
    private double tinhChuvi;
    private double tinhDienTich;


    public void setTinhDienTich(double tinhDienTich) {
        this.tinhDienTich = tinhDienTich;
    }

    public double getTinhDienTich() {
        return tinhDienTich;
    }

    public Hinh(String tenHinh) {
        this.tenHinh = tenHinh;
    }

    public String getTenHinh() {
        return tenHinh;
    }
    public void xuatThongtin(){
        System.out.println("Hinh: "+tenHinh);
        System.out.println("Chu vi= "+tinhChuvi);
        System.out.println("Dien tich= "+tinhDienTich);
    }
}
