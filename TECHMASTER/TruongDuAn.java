package TECHMASTER;
public class TruongDuAn extends NhanVien {
        private int soNamKinhNghiem;

        public TruongDuAn(String maNV, String hoTen, double luongCoBan, int soNamKinhNghiem) {
            super(maNV, hoTen, luongCoBan);
            this.soNamKinhNghiem = soNamKinhNghiem;
        }

        @Override
        public double tinhLuong() {
            return getLuongCoBan() + soNamKinhNghiem * 1_000_000;
        }

        @Override
        public void lamViec() {
            System.out.println("Quản lý tiến độ team");
        }
    }

