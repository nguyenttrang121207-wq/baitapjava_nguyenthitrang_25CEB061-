package T2;

public class Banh {
    private int id;
    private String ten;
    private long gia;
    private String trangThai;

    public Banh(int id, String ten, long gia, String trangThai) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
