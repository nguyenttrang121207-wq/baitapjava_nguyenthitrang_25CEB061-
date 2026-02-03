//package T2;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class BanhDAO {
//    final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=TiemBanhDB;encrypt=true;trustServerCertificate=true;";
//    final String USER = "sa";
//    final String PASS = "88888888";
//
//    public Connection getConnection() throws Exception {
//        return DriverManager.getConnection(DB_URL, USER, PASS);
//    }
//
//    public List<Banh> getAllBanh(String timKiem) {
//
//        List<Banh> list = new ArrayList<>();
//
//        String sql = "SELECT * FROM Banh WHERE ten_banh LIKE ?";
//
//        try (
//                Connection conn = getConnection();
//                PreparedStatement ps = conn.prepareStatement(sql);
//        ) {
//            ps.setString(1, "%" + timKiem + "%");
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String ten = rs.getString("ten_banh");
//                long gia = rs.getLong("gia");
//                String tt = rs.getString("tinh_trang");
//                Banh b = new Banh(id, ten, gia, tt);
//                list.add(b);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return list;
//    }}