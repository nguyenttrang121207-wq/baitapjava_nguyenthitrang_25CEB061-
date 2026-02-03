package QLNV;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

 class BakeryApp extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);
    private DefaultTableModel cakeModel, billModel;
    private JTextField txtId, txtName, txtPrice, txtStock, txtSearch;
    private JLabel lblTotal;
    private double totalAmount = 0;

    public BakeryApp() {
        setTitle("Bakery Manager - Simple & Fast");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- SIDEBAR (TRÁI) ---
        JPanel sidebar = new JPanel(new GridLayout(10, 1, 5, 5));
        sidebar.setBackground(new Color(44, 62, 80));
        sidebar.setPreferredSize(new Dimension(180, 0));

        String[] navItems = {"🏠 Trang chủ", "🍰 Quản lý bánh", "🧾 Hóa đơn"};
        String[] cardNames = {"Home", "Manage", "Bill"};

        for (int i = 0; i < navItems.length; i++) {
            JButton btn = new JButton(navItems[i]);
            btn.setForeground(Color.WHITE);
            btn.setBackground(new Color(52, 73, 94));
            btn.setFocusPainted(false);
            final String name = cardNames[i];
            btn.addActionListener(e -> cardLayout.show(cardPanel, name));
            sidebar.add(btn);
        }

        // --- NỘI DUNG (PHẢI) ---
        cardPanel.add(createHome(), "Home");
        cardPanel.add(createManage(), "Manage");
        cardPanel.add(createBill(), "Bill");

        add(sidebar, BorderLayout.WEST);
        add(cardPanel, BorderLayout.CENTER);
    }

    private JPanel createHome() {
        JPanel p = new JPanel(new GridBagLayout());
        JLabel lbl = new JLabel("Welcome to my bakery");
        lbl.setFont(new Font("Arial", Font.BOLD, 40));
        p.add(lbl);
        return p;
    }

    private JPanel createManage() {
        JPanel p = new JPanel(new BorderLayout(5, 5));
        // Table
        cakeModel = new DefaultTableModel(new String[]{"Mã", "Tên", "Giá", "SL"}, 0);
        JTable table = new JTable(cakeModel);
        p.add(new JScrollPane(table), BorderLayout.CENTER);

        // Inputs & Buttons
        JPanel south = new JPanel(new GridLayout(2, 1));
        JPanel input = new JPanel();
        input.add(new JLabel("Mã:")); input.add(txtId = new JTextField(5));
        input.add(new JLabel("Tên:")); input.add(txtName = new JTextField(10));
        input.add(new JLabel("Giá:")); input.add(txtPrice = new JTextField(7));
        input.add(new JLabel("SL:")); input.add(txtStock = new JTextField(4));
        input.add(new JLabel("Tìm:")); input.add(txtSearch = new JTextField(8));

        JPanel btns = new JPanel();
        JButton btnAdd = new JButton("Thêm");
        JButton btnEdit = new JButton("Sửa");
        JButton btnDel = new JButton("Xóa");
        JButton btnFind = new JButton("Tìm");

        btnAdd.addActionListener(e -> cakeModel.addRow(new Object[]{txtId.getText(), txtName.getText(), txtPrice.getText(), txtStock.getText()}));
        btnEdit.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r != -1) for(int i=0; i<4; i++) cakeModel.setValueAt(new String[]{txtId.getText(), txtName.getText(), txtPrice.getText(), txtStock.getText()}[i], r, i);
        });
        btnDel.addActionListener(e -> { if(table.getSelectedRow() != -1) cakeModel.removeRow(table.getSelectedRow()); });
        btnFind.addActionListener(e -> {
            TableRowSorter<DefaultTableModel> s = new TableRowSorter<>(cakeModel);
            table.setRowSorter(s);
            s.setRowFilter(RowFilter.regexFilter("(?i)" + txtSearch.getText()));
        });

        btns.add(btnAdd); btns.add(btnEdit); btns.add(btnDel); btns.add(btnFind);
        south.add(input); south.add(btns);
        p.add(south, BorderLayout.SOUTH);
        return p;
    }

    private JPanel createBill() {
        JPanel p = new JPanel(new GridLayout(1, 2, 10, 10));
        // Bên trái: Chọn bánh
        JPanel left = new JPanel(new BorderLayout());
        JTable selTable = new JTable(cakeModel);
        left.add(new JScrollPane(selTable), BorderLayout.CENTER);
        JButton btnAddBill = new JButton("Thêm vào hóa đơn >>");
        left.add(btnAddBill, BorderLayout.SOUTH);

        // Bên phải: Hóa đơn
        JPanel right = new JPanel(new BorderLayout());
        billModel = new DefaultTableModel(new String[]{"Tên", "Giá", "Thành tiền"}, 0);
        right.add(new JScrollPane(new JTable(billModel)), BorderLayout.CENTER);
        lblTotal = new JLabel("Tổng: 0 VNĐ", JLabel.RIGHT);
        lblTotal.setFont(new Font("Arial", Font.BOLD, 16));

        JButton btnPay = new JButton("Thanh toán");
        JPanel rightSouth = new JPanel(new BorderLayout());
        rightSouth.add(lblTotal, BorderLayout.NORTH);
        rightSouth.add(btnPay, BorderLayout.SOUTH);
        right.add(rightSouth, BorderLayout.SOUTH);

        btnAddBill.addActionListener(e -> {
            int r = selTable.getSelectedRow();
            if (r != -1) {
                double pr = Double.parseDouble(cakeModel.getValueAt(r, 2).toString());
                billModel.addRow(new Object[]{cakeModel.getValueAt(r, 1), pr, pr});
                totalAmount += pr;
                lblTotal.setText("Tổng: " + totalAmount + " VNĐ");
            }
        });

        btnPay.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Thanh toán thành công: " + totalAmount + " VNĐ");
            billModel.setRowCount(0); totalAmount = 0; lblTotal.setText("Tổng: 0 VNĐ");
        });

        p.add(left); p.add(right);
        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BakeryApp().setVisible(true));
    }
}