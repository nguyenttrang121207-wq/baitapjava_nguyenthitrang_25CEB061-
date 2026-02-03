package QLTB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class MainView extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel panelNoiDung = new JPanel(cardLayout);
    private DefaultTableModel model;
    private JTable table;
    private JTextField txtTim;
    private JButton btnHome, btnQuanLy, btnTim, btnThem, btnXoa;

    public MainView() {
        setTitle("Hệ Thống Tiệm Bánh");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel menu = new JPanel(new GridLayout(6, 1, 10, 10));
        menu.setBackground(new Color(255, 248, 220));
        menu.setBorder(new EmptyBorder(20, 20, 20, 20));
        menu.setPreferredSize(new Dimension(220, 0));

        JLabel logo = new JLabel("MY BAKERY", JLabel.CENTER);
        logo.setFont(new Font("Arial", Font.BOLD, 28));
        logo.setForeground(new Color(139, 69, 19));
        menu.add(logo);

        btnHome = taoNut(" Trang chủ");
        btnQuanLy = taoNut(" Quản lý bánh");
        menu.add(btnHome); menu.add(btnQuanLy);

        panelNoiDung.add(taoPanelWelcome(), "Welcome");
        panelNoiDung.add(taoPanelQuanLy(), "QuanLy");

        add(menu, BorderLayout.WEST);
        add(panelNoiDung, BorderLayout.CENTER);
    }

    private JPanel taoPanelWelcome() {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(Color.WHITE);
        JLabel l = new JLabel("Welcome to my bakery!");
        l.setFont(new Font("Arial", Font.BOLD, 50));
        l.setForeground(new Color(210, 105, 30));
        p.add(l);
        return p;
    }

    private JPanel taoPanelQuanLy() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(Color.WHITE);
        p.setBorder(new EmptyBorder(10, 20, 20, 20));

        JPanel top = new JPanel(new BorderLayout());
        top.setBackground(Color.WHITE);
        JLabel title = new JLabel("Quản lý tiệm bánh", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(210, 105, 30));
        top.add(title, BorderLayout.NORTH);

        JPanel tools = new JPanel();
        tools.setBackground(Color.WHITE);
        txtTim = new JTextField(15);
        btnTim = taoNutNho(" Tìm");
        btnThem = taoNutNho(" Thêm");
        btnXoa = taoNutNho(" Xóa");
        tools.add(new JLabel("Tên:"));
        tools.add(txtTim);
        tools.add(btnTim);
        tools.add(Box.createHorizontalStrut(20));
        tools.add(btnThem);
        tools.add(btnXoa);

        top.add(tools, BorderLayout.CENTER);
        p.add(top, BorderLayout.NORTH);

        model = new DefaultTableModel(new Object[]{"Mã", "Tên", "Giá", "Trạng Thái"}, 0);
        table = new JTable(model);
        table.setRowHeight(25);
        p.add(new JScrollPane(table), BorderLayout.CENTER);
        return p;
    }

    public void hienThiDanhSach(List<Banh> list) {
        model.setRowCount(0);
        for (Banh b : list)
            model.addRow(new Object[]{b.getId(), b.getTen(), String.format("%,d đ", b.getGia()), b.getTrangThai()});
    }

    public void chuyenTrang(String tenTrang) {
        cardLayout.show(panelNoiDung, tenTrang); }
    public String getTuKhoa() {
        return txtTim.getText(); }
    public JTable getTable() {
        return table; }

    public void addHomeListener(ActionListener l) {
        btnHome.addActionListener(l); }
    public void addQuanLyListener(ActionListener l) {
        btnQuanLy.addActionListener(l); }
    public void addTimListener(ActionListener l) {
        btnTim.addActionListener(l); }
    public void addThemListener(ActionListener l) {
        btnThem.addActionListener(l); }
    public void addXoaListener(ActionListener l) {
        btnXoa.addActionListener(l); }

    private JButton taoNut(String t) {
        JButton b = new JButton(t);
        b.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b.setBackground(new Color(210, 105, 30)); b.setForeground(Color.WHITE); b.setFocusPainted(false);
        return b;
    }
    private JButton taoNutNho(String t) {
        JButton b = taoNut(t);
        b.setFont(new Font("Segoe UI", Font.BOLD, 15));
        return b;
    }
}


