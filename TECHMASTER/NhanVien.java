package TECHMASTER;

public abstract class NhanVien {
    private String maNV;
    private String hoTen;
    private double luongCoBan;

    public NhanVien(String maNV, String hoTen, double luongCoBan) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.luongCoBan = luongCoBan;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }
    public void inThongTin(){
        System.out.println("Ma NV: "+ maNV);
        System.out.println("Ho ten: "+ hoTen);}
    public abstract double tinhLuong();
    double tinhThuong(){
        return 0;
    }
    public void lamViec(){
        System.out.println(hoTen+" dang lam viec");
    }

}
