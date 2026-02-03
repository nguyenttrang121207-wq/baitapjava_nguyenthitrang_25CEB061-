package BTCK;

import java.sql.*;

public class KiemTraKetNoi {
    public static void main(String[] args) {
        System.out.println("--- BẮT ĐẦU KIỂM TRA ---");

        // 1. Thông tin kết nối (Copy y hệt từ bài code chính của bạn sang đây)
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=TiemBanhDB;encrypt=true;trustServerCertificate=true;";
        String user = "sa";
        String pass = "1234"; // Nhớ sửa đúng mật khẩu

        try {
            Connection conn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("✅ Kết nối thành công!");

            // 2. Kiểm tra xem đang đứng ở Database nào
            System.out.println("📂 Đang kết nối vào Database tên là: " + conn.getCatalog());

            // 3. Đếm xem có bao nhiêu cái bánh
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM Banh");

            if (rs.next()) {
                int soLuong = rs.getInt(1);
                System.out.println("📊 Số lượng bánh tìm thấy: " + soLuong);

                if (soLuong == 0) {
                    System.out.println("⚠️ CẢNH BÁO: Bảng 'Banh' có tồn tại nhưng KHÔNG CÓ DỮ LIỆU (Rỗng).");
                    System.out.println("👉 Hãy vào SQL Server chạy lại lệnh INSERT.");
                } else {
                    System.out.println("🎉 Có dữ liệu! Nếu lên giao diện vẫn trống thì do code hiển thị sai.");
                }
            }
            conn.close();

        } catch (Exception e) {
            System.out.println("❌ LỖI KẾT NỐI: " + e.getMessage());
            e.printStackTrace();
        }
    }
}