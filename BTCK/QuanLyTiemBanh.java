package BTCK;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class QuanLyTiemBanh extends JFrame {
    // 1. CẤU HÌNH DATABASE
    final String DB = "jdbc:sqlserver://localhost:1433;databaseName=TiemBanhDB;encrypt=true;trustServerCertificate=true;";
    final String US = "sa", PW = "88888888"; // <--- Đổi mật khẩu ở đây

    // 2. KHAI BÁO BIẾN
    JPanel mainPanel = new JPanel(new CardLayout());
    DefaultTableModel modelBanh = new DefaultTableModel(new Object[]{"Mã", "Tên Bánh", "Giá", "Trạng Thái"}, 0);
    Color cCam = new Color(210, 105, 30), cTrang = Color.WHITE;

    public QuanLyTiemBanh() {
        setTitle("Hệ Thống Quản Lý Tiệm Bánh"); setSize(1000, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE); setLocationRelativeTo(null);

        // --- MENU BÊN TRÁI ---
        JPanel menu = new JPanel(new GridLayout(6, 1, 10, 10));
        menu.setBackground(new Color(255, 248, 220));
        menu.setBorder(new EmptyBorder(20, 20, 20, 20)); menu.setPreferredSize(new Dimension(240, 0));

        JLabel logo = new JLabel("JAVA BAKERY", 0);
        logo.setFont(new Font("Arial", 1, 24)); logo.setForeground(new Color(139, 69, 19));

        menu.add(logo);
        // Chỉ còn 2 nút: Trang Chủ và Thực Đơn
        menu.add(btn("🏠 Trang Chủ", 14, e -> ((CardLayout)mainPanel.getLayout()).show(mainPanel, "Home")));
        menu.add(btn("🍰 Thực Đơn", 14, e -> {
            mainPanel.add(trangThucDon(), "Menu"); // Load lại trang để cập nhật dữ liệu mới
            ((CardLayout)mainPanel.getLayout()).show(mainPanel, "Menu");
        }));

        // --- PANEL CHÍNH ---
        mainPanel.setBackground(cTrang);
        // Trang Chủ mặc định
        mainPanel.add(new JLabel("<html><center><h1 style='color:orange'>Welcome!</h1></center></html>", 0), "Home");

        add(menu, "West"); add(mainPanel, "Center");
    }

    // --- TRANG QUẢN LÝ BÁNH (Thực Đơn) ---
    private JPanel trangThucDon() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(cTrang); p.setBorder(new EmptyBorder(10, 20, 20, 20));

        // 1. Header & Công cụ (Tìm, Thêm, Xóa)
        JPanel top = new JPanel(new BorderLayout()); top.setBackground(cTrang);
        JLabel lbl = new JLabel("QUẢN LÝ THỰC ĐƠN", 0);
        lbl.setFont(new Font("Segoe UI", 1, 22)); lbl.setForeground(cCam);
        top.add(lbl, "North");

        JPanel tool = new JPanel(); tool.setBackground(cTrang);
        JTextField txt = new JTextField(15);

        tool.add(new JLabel("Tìm tên:")); tool.add(txt);
        tool.add(btn("🔍 Tìm", 12, e -> taiBanh(txt.getText()))); // Nút Tìm
        tool.add(Box.createHorizontalStrut(20));
        tool.add(btn("➕ Thêm", 12, e -> xuLyThem())); // Nút Thêm

        // Nút Xóa (Cần tham chiếu đến bảng để biết dòng nào đang chọn)
        JTable tbl = new JTable(modelBanh); fixTable(tbl);
        tool.add(btn("🗑️ Xóa", 12, e -> xuLyXoa(tbl)));

        top.add(tool, "Center"); p.add(top, "North");

        // 2. Bảng dữ liệu
        p.add(new JScrollPane(tbl), "Center");

        // Tải dữ liệu lên bảng
        taiBanh("");
        return p;
    }

    // --- LOGIC DATABASE (Load, Add, Delete) ---
    private void taiBanh(String key) {
        modelBanh.setRowCount(0); // Xóa trắng bảng cũ
        try (Connection c = DriverManager.getConnection(DB, US, PW); Statement s = c.createStatement()) {
            ResultSet rs = s.executeQuery("SELECT * FROM Banh WHERE ten_banh LIKE N'%" + key + "%'");
            while(rs.next())
                modelBanh.addRow(new Object[]{rs.getInt(1), rs.getString(2), String.format("%,d đ", rs.getLong(3)), rs.getString(4)});
        } catch(Exception e) { JOptionPane.showMessageDialog(this, "Lỗi: " + e); }
    }

    private void xuLyThem() {
        JTextField t1 = new JTextField(), t2 = new JTextField(), t3 = new JTextField("Còn hàng");
        Object[] msg = {"Tên:", t1, "Giá:", t2, "Trạng Thái:", t3};

        if(JOptionPane.showConfirmDialog(this, msg, "Thêm Bánh", 2) == 0) {
            execSQL("INSERT INTO Banh VALUES (?, ?, ?)", t1.getText(), t2.getText(), t3.getText());
            taiBanh(""); // Load lại bảng sau khi thêm
        }
    }

    private void xuLyXoa(JTable t) {
        int r = t.getSelectedRow();
        if(r == -1) { JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa!"); return; }

        if(JOptionPane.showConfirmDialog(this, "Xóa bánh này?", "Xác nhận", 0) == 0) {
            execSQL("DELETE FROM Banh WHERE id=?", t.getValueAt(r, 0));
            taiBanh(""); // Load lại bảng sau khi xóa
        }
    }

    // Hàm chạy lệnh SQL chung (Rút gọn code)
    private void execSQL(String sql, Object... args) {
        try (Connection c = DriverManager.getConnection(DB, US, PW); PreparedStatement p = c.prepareStatement(sql)) {
            for(int i=0; i<args.length; i++) p.setObject(i+1, args[i]);
            p.executeUpdate();
            JOptionPane.showMessageDialog(this, "Thành công!");
        } catch(Exception e) { JOptionPane.showMessageDialog(this, "Lỗi: " + e); }
    }

    // --- HÀM HỖ TRỢ GIAO DIỆN ---
    private JButton btn(String txt, int size, ActionListener act) {
        JButton b = new JButton(txt); b.setFont(new Font("Segoe UI", 1, size));
        b.setBackground(cCam); b.setForeground(cTrang); b.setFocusPainted(false);
        b.addActionListener(act); return b;
    }

    private void fixTable(JTable t) {
        t.setRowHeight(30);
        t.getTableHeader().setBackground(cCam); t.getTableHeader().setForeground(cTrang);
        DefaultTableCellRenderer c = new DefaultTableCellRenderer(); c.setHorizontalAlignment(0);
        t.setDefaultRenderer(Object.class, c);
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); } catch(Exception e){}
        SwingUtilities.invokeLater(() -> new QuanLyTiemBanh().setVisible(true));
    }
}