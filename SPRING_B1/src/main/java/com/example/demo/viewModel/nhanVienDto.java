package com.example.demo.viewModel;

import com.example.demo.domainModel.chucVu;
import com.example.demo.domainModel.cuaHang;
import com.example.demo.domainModel.nhanVien;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class nhanVienDto implements Serializable {
    private UUID id;
    private String ma;
    private String ten;
    private String ten_dem;
    private String ho;
    private Date ngay_sinh;
    private String gioi_tinh;
    private String dia_chi;
    private String sdt;
    private String mat_khau;
    private String trang_thai;
    private String cuahangid;
    private String chucvuid;

}
