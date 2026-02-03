package BT2;
import java.util.ArrayList;
public class TestHinhHoc {
    public static void main(String[] args) {
        ArrayList<Hinh> ds = new ArrayList<>();
        ds.add(new HinhTron("Hinh tron", 5.0));
        ds.add(new HinhChuNhat("Hinh chu nhat", 4.0, 6.0));
        ds.add(new HinhVuong("Hinh vuong", 7.0));
        System.out.println("Các hinh có trong list là: ");

        double tongDienTich = 0.0;
        for (int i = 0; i < ds.size(); i++) {
            Hinh hinh = ds.get(i);

            String tenHinh = hinh.getTenHinh();
            System.out.println(tenHinh);

            switch (tenHinh) {
                case "Hinh tron": {
                    HinhTron hinhTron = (HinhTron) hinh;
                    double dienTich = hinhTron.tinhDienTich();
                    System.out.println("Dien tich hinh tron: " + dienTich);
                    tongDienTich += dienTich;
                    break;
                }
                case "Hinh chu nhat": {
                    HinhChuNhat hinhChunhat=(HinhChuNhat) hinh;
                    double dienTich = hinhChunhat.tinhDienTich();
                    System.out.println("Dien tich hinh chu nhat: " + dienTich);
                    tongDienTich += dienTich;
                    break;
                }
                case "Hinh vuong": {
                    HinhVuong hinhVuong =(HinhVuong) hinh;
                    double dienTich = hinhVuong.tinhDienTich();
                    System.out.println("Dien tich hinh vuong: " + dienTich);
                    tongDienTich += dienTich;
                    break;
                    }
                }
            };
            System.out.println("Tong dien tich cua tat ca cac hinh la: " + tongDienTich);
        }
    }