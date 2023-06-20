package com.example.demo.viewModel;

import com.example.demo.domainModel.khachHang;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class khachHangVM {
    @NotBlank(message = "không được để trống")
    private String ma;
    @NotBlank(message = "không được để trống")
    private String ten;
    @NotBlank(message = "không được để trống")
    private String ten_dem;
    @NotBlank(message = "không được để trống")
    private String ho;
    @NotBlank(message = "không được để trống")
    private String ngay_sinh;
    @NotBlank(message = "không được để trống")
    private String sdt;
    @NotBlank(message = "không được để trống")
    private String dia_chi;
    @NotBlank(message = "không được để trống")
    private String thanh_pho;
    @NotBlank(message = "không được để trống")
    private String quoc_gia;
    @NotBlank(message = "không được để trống")
    private String mat_khau;

    public void loadDomain(khachHang kh){
        this.setMa(kh.getMa());
        this.setTen(kh.getTen());
        this.setTen_dem(kh.getTen_dem());
        this.setHo(kh.getHo());
        this.setNgay_sinh(String.valueOf(kh.getNgay_sinh()));
        this.setSdt(kh.getSdt());
        this.setDia_chi(kh.getDia_chi());
        this.setQuoc_gia(kh.getQuoc_gia());
        this.setThanh_pho(kh.getThanh_pho());
        this.setMat_khau(kh.getMat_khau());
    }

}
