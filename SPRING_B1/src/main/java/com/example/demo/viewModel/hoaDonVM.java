package com.example.demo.viewModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class hoaDonVM {
    private UUID id;
    private String khachHang;
    private String nhanVien;
    private String ma;
    private Date ngay_tao;
    private Date ngay_thanh_toan;
    private Date ngay_ship;
    private Date ngay_nhan;
    private String tinh_trang;
    private String ten_nguoi_nhan;
    private String dia_chi;
    private String sdt;
}
