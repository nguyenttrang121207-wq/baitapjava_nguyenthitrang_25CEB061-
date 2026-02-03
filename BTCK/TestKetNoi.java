package BTCK;

import java.sql.*;

public class TestKetNoi {
    public static void main(String[] args) {
        System.out.println("====== BẮT ĐẦU KIỂM TRA ======");

        // 1. Kiểm tra Driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("✅ Đã tìm thấy thư viện Driver!");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ LỖI: Chưa thêm thư viện .jar vào dự án!");
            return; // Dừng luôn
        }

        // 2. Thử kết nối
        String url = "jdbc:sqlserver://localhost:1433;databaseName=TiemBanhDB;encrypt=true;trustServerCertificate=true;";
        String user = "sa";
        String pass = "1234"; // <--- Kiểm tra kỹ mật khẩu này

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.println("✅ Kết nối Database thành công!");

            // 3. Kiểm tra dữ liệu
            String sql = "SELECT * FROM Banh";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            int dem = 0;
            while (rs.next()) {
                dem++;
                String ten = rs.getString("ten_banh");
                System.out.println("   -> Tìm thấy bánh: " + ten);
            }

            if (dem == 0) {
                System.out.println("⚠️ CẢNH BÁO: Kết nối được nhưng BẢNG RỖNG (Không có bánh nào).");
                System.out.println("👉 Lý do: Bạn đang kết nối vào một Database trống, hoặc chưa chạy lệnh INSERT.");
            } else {
                System.out.println("🎉 Có " + dem + " cái bánh. Nếu giao diện không hiện thì do code giao diện sai.");
            }

        } catch (SQLException e) {
            System.out.println("❌ LỖI KẾT NỐI: " + e.getMessage());

            // Kiểm tra lỗi cổng 1433
            if (e.getMessage().contains("TCP/IP")) {
                System.out.println("👉 Gợi ý: Hãy thử sửa 'localhost:1433' thành 'localhost' hoặc 'localhost\\SQLEXPRESS'");
            }
        }
    }
}