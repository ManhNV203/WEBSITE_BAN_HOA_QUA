package com.example.demo.viewModel;

import com.example.demo.domainModel.chucVu;
import com.example.demo.domainModel.cuaHang;
import com.example.demo.domainModel.nhanVien;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class nhanVienVM {

    @NotBlank(message = "Không được để trống")
    private String ma;

    @NotBlank(message = "Không được để trống")
    private String ten;

    @NotBlank(message = "Không được để trống")
    private String ten_dem;

    @NotBlank(message = "Không được để trống")
    private String ho;

    @NotEmpty(message = "Không được để trống")
    private String ngay_sinh;

    @NotBlank(message = "Không được để trống")
    private String gioi_tinh;

    @NotBlank(message = "Không được để trống")
    private String dia_chi;

    @NotBlank(message = "Không được để trống")
    private String sdt;

    @NotBlank(message = "Không được để trống")
    private String mat_khau;

    @NotBlank(message = "Không được để trống")
    private String trang_thai;
    @NotNull(message = "khong de trong")
    private cuaHang ch;

    @NotNull(message = "khong de trong")
    private chucVu cv;
    public void loadDomain(nhanVien nv){
        this.setMa(nv.getMa());
        this.setTen(nv.getTen());
        this.setTen_dem(nv.getTen_dem());
        this.setHo(nv.getHo());
        this.setNgay_sinh(String.valueOf(nv.getNgay_sinh()));
        this.setGioi_tinh(nv.getGioi_tinh());
        this.setDia_chi(nv.getDia_chi());
        this.setSdt(nv.getSdt());
        this.setMat_khau(nv.getMat_khau());
        this.setTrang_thai(String.valueOf(nv.getTrang_thai()));
        this.setMat_khau(nv.getMat_khau());
        this.setCh(nv.getCh());
        this.setCv(nv.getCv());
    }
}
