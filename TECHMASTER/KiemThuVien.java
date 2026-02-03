package TECHMASTER;

    public class KiemThuVien extends NhanVien {
        private int soLoiPhatHien;

        public KiemThuVien(String maNV, String hoTen, double luongCoBan, int soLoiPhatHien) {
            super(maNV, hoTen, luongCoBan);
            this.soLoiPhatHien = soLoiPhatHien;
        }

        @Override
        public double tinhLuong() {
            return getLuongCoBan() + soLoiPhatHien * 50_000;
        }

        @Override
        public void lamViec() {
            System.out.println("Kiểm tra phần mềm");
        }
    }
