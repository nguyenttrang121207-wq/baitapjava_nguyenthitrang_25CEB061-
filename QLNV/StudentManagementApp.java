package QLNV;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class MainFrame extends JFrame {

    private JTextField txtSearch;
    private JTable table;
    private DefaultTableModel model;
    private List<Object[]> cakeList = new ArrayList<>();

    public MainFrame() {
        setTitle("Quản Lý Tiệm Bánh");
        setSize(700, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initUI();
        loadData();
    }

    private void initUI() {
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Tìm bánh (theo tên):"));
        txtSearch = new JTextField(20);
        JButton btnSearch = new JButton("Tìm");
        JButton btnShowAll = new JButton("Hiển thị tất cả");

        topPanel.add(txtSearch);
        topPanel.add(btnSearch);
        topPanel.add(btnShowAll);

        String[] columnNames = {"Mã bánh", "Tên bánh", "Giá", "Số lượng"};
        model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel bottomPanel = new JPanel();
        JButton btnAdd = new JButton("Thêm");
        JButton btnEdit = new JButton("Sửa");
        JButton btnDelete = new JButton("Xóa");
        JButton btnExit = new JButton("Thoát");

        bottomPanel.add(btnAdd);
        bottomPanel.add(btnEdit);
        bottomPanel.add(btnDelete);
        bottomPanel.add(btnExit);

        setLayout(new BorderLayout(10, 10));
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        btnSearch.addActionListener(e -> searchCake());
        btnShowAll.addActionListener(e -> {
            txtSearch.setText("");
            showAllCakes();
        });
        btnAdd.addActionListener(e -> addCake());
        btnEdit.addActionListener(e -> editCake());
        btnDelete.addActionListener(e -> deleteCake());
        btnExit.addActionListener(e -> System.exit(0));
    }

    private void loadData() {
        cakeList.clear();
        cakeList.add(new Object[]{"B01", "Bánh mì", 10000, 50});
        cakeList.add(new Object[]{"B02", "Bánh kem", 200000, 10});
        cakeList.add(new Object[]{"B03", "Bánh su", 5000, 100});
        showAllCakes();
    }

    private void showAllCakes() {
        model.setRowCount(0);
        for (Object[] cake : cakeList) {
            model.addRow(cake);
        }
    }

    private void searchCake() {
        String keyword = txtSearch.getText().trim().toLowerCase();
        if (keyword.isEmpty()) {
            showAllCakes();
            return;
        }

        model.setRowCount(0);
        boolean found = false;
        for (Object[] cake : cakeList) {
            String tenBanh = cake[1].toString().toLowerCase();
            if (tenBanh.contains(keyword)) {
                model.addRow(cake);
                found = true;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy bánh có tên: " + keyword);
            showAllCakes();
        }
    }

    private void addCake() {
        JTextField ma = new JTextField();
        JTextField ten = new JTextField();
        JTextField gia = new JTextField();
        JTextField soLuong = new JTextField();

        Object[] input = { "Mã bánh:", ma, "Tên bánh:", ten, "Giá:", gia, "Số lượng:", soLuong };

        int result = JOptionPane.showConfirmDialog(this, input, "Thêm bánh mới", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                if (ma.getText().isEmpty() || ten.getText().isEmpty()) throw new Exception("Không để trống!");
                cakeList.add(new Object[]{ ma.getText(), ten.getText(), Double.parseDouble(gia.getText()), Integer.parseInt(soLuong.getText()) });
                showAllCakes();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
            }
        }
    }
    private void editCake() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa!");
            return;
        }
        String currentMa = model.getValueAt(row, 0).toString();
        JTextField ma = new JTextField(model.getValueAt(row, 0).toString());
        JTextField ten = new JTextField(model.getValueAt(row, 1).toString());
        JTextField gia = new JTextField(model.getValueAt(row, 2).toString());
        JTextField soLuong = new JTextField(model.getValueAt(row, 3).toString());

        Object[] input = { "Mã bánh:", ma, "Tên bánh:", ten, "Giá:", gia, "Số lượng:", soLuong };

        if (JOptionPane.showConfirmDialog(this, input, "Sửa bánh", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            try {
                int idx = findCakeIndexByMa(currentMa);
                if (idx != -1) cakeList.set(idx, new Object[]{ ma.getText(), ten.getText(), Double.parseDouble(gia.getText()), Integer.parseInt(soLuong.getText()) });
                showAllCakes();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi dữ liệu!");
            }
        }
    }
    private void deleteCake() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa!");
            return;
        }
        String ma = model.getValueAt(row, 0).toString();
        if (JOptionPane.showConfirmDialog(this, "Xác nhận xóa bánh " + ma + "?", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            int idx = findCakeIndexByMa(ma);
            if (idx != -1) cakeList.remove(idx);
            showAllCakes();
        }
    }
    private int findCakeIndexByMa(String maBanh) {
        for (int i = 0; i < cakeList.size(); i++) {
            if (cakeList.get(i)[0].toString().equals(maBanh)) return i;
        }
        return -1;
    }
    // ===== HÀM MAIN VỚI LOGIN ĐƠN GIẢN =====
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            // Tạo các ô nhập đơn giản
            JTextField user = new JTextField();
            JPasswordField pass = new JPasswordField();
            Object[] loginFields = { "Tài khoản:", user, "Mật khẩu:", pass };

            // Hiện bảng nhập ngay khi chạy
            int option = JOptionPane.showConfirmDialog(null, loginFields, "Đăng nhập", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                // Kiểm tra tài khoản (admin / 123)
                if (user.getText().equals("admin") && new String(pass.getPassword()).equals("123")) {
                    new MainFrame().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Sai thông tin đăng nhập!");
                    System.exit(0);
                }
            } else {
                System.exit(0);
            }
        });
    }
}