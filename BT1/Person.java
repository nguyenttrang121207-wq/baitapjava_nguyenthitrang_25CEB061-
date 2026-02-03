package BT1;

public abstract class Person {
    private String hoTen;
    private String diaChi;
    private int namSinh;
    public Person(String hoTen,String diaChi, int namSinh){
        this.hoTen=hoTen;
        this.diaChi=diaChi;
        this.namSinh=namSinh;
    }

    protected Person() {
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
    public abstract String getLoai();
    public void inThongTin(){
        System.out.println("Ho ten: "+hoTen);
        System.out.println("Dia chi: "+ diaChi);
        System.out.println("Nam sinh: "+namSinh);
    }
    @Override
    public String toString() {
        return "Person{" +
                "hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", namSinh=" + namSinh +
                '}';
    }
}
