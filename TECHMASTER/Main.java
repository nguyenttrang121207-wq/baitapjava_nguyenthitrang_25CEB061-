package TECHMASTER;
    public class Main {
        public static void main(String[] args) {
            NhanVien nv1 = new LapTrinhVien("LT01", "Nguyen Van A", 10_000_000, 5);
            NhanVien nv2 = new KiemThuVien("KT01", "Tran Thi B", 9_000_000, 12);
            NhanVien nv3 = new TruongDuAn("DA01", "Le Van C", 15_000_000, 3);

            nv1.inThongTin();
            nv1.lamViec();
            System.out.println("Lương: " + nv1.tinhLuong());

            nv2.inThongTin();
            nv2.lamViec();
            System.out.println("Lương: " + nv2.tinhLuong());

            nv3.inThongTin();
            nv3.lamViec();
            System.out.println("Lương: " + nv3.tinhLuong());
        }
    }

