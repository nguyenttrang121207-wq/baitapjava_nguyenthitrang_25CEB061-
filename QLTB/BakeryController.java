package QLTB;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BakeryController {
    private MainView view;
    private BanhDAO dataAccess;

    public BakeryController(MainView view, BanhDAO dataAccess) {
        this.view = view;
        this.dataAccess = dataAccess;

        view.addHomeListener(e -> view.chuyenTrang("Welcome"));
        view.addQuanLyListener(e -> {
            view.chuyenTrang("QuanLy");
            loadData();
        });

        view.addTimListener(e -> loadData());
        view.addThemListener(e -> xuLyThem());
        view.addXoaListener(e -> xuLyXoa());
    }

    private void loadData() {
        String tuKhoa = view.getTuKhoa().trim();
        view.hienThiDanhSach(dataAccess.getAllBanh(tuKhoa));
    }

    private void xuLyThem() {
        JTextField txtTen = new JTextField();
        JTextField txtGia = new JTextField();
        JTextField txtTrangThai = new JTextField("Còn hàng");

        Object[] form = {
                "Tên bánh:", txtTen,
                "Giá bán:", txtGia,
                "Trạng thái:", txtTrangThai
        };

        if (JOptionPane.showConfirmDialog(view, form, "Thêm Bánh", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            try {
                Banh b = new Banh(0,
                        txtTen.getText().trim(),
                        Long.parseLong(txtGia.getText().trim()),
                        txtTrangThai.getText().trim());
                if (dataAccess.addBanh(b)) {
                    loadData();
                    JOptionPane.showMessageDialog(view, "Thêm thành công!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Lỗi nhập!");
            }
        }
    }


    private void xuLyXoa() {
        int row = view.getTable().getSelectedRow();
        if (row != -1 && JOptionPane.showConfirmDialog(view, "Xóa bánh này?", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(view.getTable().getValueAt(row, 0).toString());
            if (dataAccess.deleteBanh(id)) {
                loadData();
                JOptionPane.showMessageDialog(view, "Đã xóa!");
            }
        }
    }
}