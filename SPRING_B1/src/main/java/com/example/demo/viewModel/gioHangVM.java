package com.example.demo.viewModel;

import com.example.demo.domainModel.gioHang;
import com.example.demo.domainModel.khachHang;
import com.example.demo.domainModel.nhanVien;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class gioHangVM {
    @NotNull(message = "Không Để Trống")
    private khachHang kh;

    @NotNull(message ="Không Để Trống")
    private nhanVien nv;

    @NotBlank(message ="Không để trống")
    private String ma;

    @NotNull(message ="Không Để Trống")
    private String ngay_tao;

    @NotNull(message ="Không Để Trống")
    private String ngay_thanh_toan;

    @NotBlank(message ="Không để trống")
    private String ten_nguoi_nhan;

    @NotBlank(message ="Không để trống")
    private String dia_chi;

    @NotBlank(message ="Không để trống")
    private String sdt;

    @NotNull(message ="Không để trống")
    private String tinh_trang;

    public  void loadDomain(gioHang gh){
        this.setKh(gh.getKh());
        this.setNv(gh.getNv());
        this.setMa(gh.getMa());
        this.setNgay_tao(String.valueOf(gh.getNgay_tao()));
        this.setNgay_thanh_toan(String.valueOf(gh.getNgay_thanh_toan()));
        this.setTen_nguoi_nhan(gh.getTen_nguoi_nhan());
        this.setDia_chi(gh.getDia_chi());
        this.setSdt(gh.getSdt());
        this.setTinh_trang(String.valueOf(gh.getTinh_trang()));
    }
}
