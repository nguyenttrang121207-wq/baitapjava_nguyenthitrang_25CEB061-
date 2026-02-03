//package T2;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//    public class MainView extends JFrame {
//        private CardLayout cardLayout=new CardLayout();
//        private JPanel panelNoiDung=new JPanel(cardLayout);
//        private DefaultTableModel model;
//        private JTable table;
//        private JTextField txtTim;
//        private JButton btnHome,btnQuanLy,btnTim,btnThem,btnXoa;
//        public MainView(){
//            setTitle("Quản lý Tiệm Bánh");
//            setSize(900,600);
//            setDefaultCloseOperation(EXIT_ON_CLOSE);
//            setLocationRelativeTo(null);
//            setLayout(new BorderLayout());
//
//            JPanel menu=new JPanel();
//            menu.setLayout(new GridLayout(6,1,10,10));
//            menu.setBackground(new Color(255,248,220));
//            menu.setBorder(new EmptyBorder(20,20,20,20));
//            menu.setPreferredSize(new Dimension(220,0));
//
//            JLabel logo=new JLabel("MY BAKERY",JLabel.CENTER);
//            logo.setFont(new Font("Arial",Font.BOLD,22));
//            logo.setForeground(new Color(139,69,19));
//            menu.add(logo);
//
//
//            btnHome=new JButton(" Trang chủ");
//            btnHome.setFont(new Font("Arial",Font.PLAIN,16));
//            btnHome.setBackground(new Color(255,228,196));
//            menu.add(btnHome);
//
//            btnQuanLy=new JButton(" Quản lý bánh");
//            btnQuanLy.setFont(new Font("Arial",Font.PLAIN,16));
//            btnQuanLy.setBackground(new Color(255,228,196));
//            btnQuanLy.setForeground(Color.WHITE);
//            menu.add(btnQuanLy);
//
//            add(menu,BorderLayout.WEST);
//
//
//            panelNoidung.add(taoPanelWelcome(),"Welcome");
//            panelNoiDung.add(taoPanelQuanLy(),"QuanLy");
//            add(panelNoiDung,BorderLayout.CENTER);
//
//            private JPanel taoPanelWelcome(){
//                JPanel p=new JPanel(new BorderLayout());
//                p.setBackground(Color.WHITE);
//                JLabel l=new JLabel("Chào mừng đến với tiệm bánh!");
//                l.setFont(new Font("Arial",Font.BOLD,60));
//                l.setForeground(new Color(210,105,30));
//                p.add(l);
//                return p;}
//
//            private JPanel taoPanelQuanLy() {
//                JPanel p = new JPanel(new BorderLayout(10, 10));
//                p.setBackground(Color.WHITE);
//
//                JPanel top = new JPanel(new BorderLayout());
//                top.setBackground(Color.WHITE);
//                txtTim = new JTextField(20);
//                btnTim = new JButton(" Tìm");
//                btnThem = new JButton(" Thêm");
//                btnXoa = new JButton(" Xóa");
//
//                top.add(txtTim, BorderLayout.WEST);
//                top.add(btnTim, BorderLayout.CENTER);
//                top.add(btnThem, BorderLayout.EAST);
//                top.add(btnXoa, BorderLayout.SOUTH);
//                p.add(top, BorderLayout.NORTH);
//
//                String[] columns = {"ID", "Tên Bánh", "Giá Bán", "Trạng Thái"};
//                model = new DefaultTableModel(columns, 0);
//                table = new JTable(model);
//                table.setRowHeight(35);
//                JScrollPane scrollPane = new JScrollPane(table);
//                p.add(scrollPane, BorderLayout.CENTER);
//                return p;
//            }
//
//            public void chuyenTrang(String tenTrang){
//                cardLayout.show(panelNoiDung,tenTrang);
//
//                public String getTuKhoa() {
//                    return txtTim.getText().trim();
//                }
//                public JTable getTable() {
//                    return table;
//
//
//
//
//            }
//
//        }
//    }
//
