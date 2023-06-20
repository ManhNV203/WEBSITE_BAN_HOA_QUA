package com.example.demo.viewModel;

import com.example.demo.domainModel.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class chiTietSPVM {
    @NotNull(message = "Not Null")
    private sanPham sp;

    @NotNull(message = "Not Null")
    private mauSac ms;

    @NotNull(message = "Not Null")
    private nhaSanXuat nsx;

    @NotNull(message = "Not Null")
    private dongSP dsp;

    @NotBlank(message = "Not Null")
    private String nam_bh;

    @NotBlank(message = "Not Null")
    private String mo_ta;

    @NotBlank(message = "Not Null")
    private String sl_ton;

    @NotNull(message = "Not Null")
    private BigDecimal gia_nhap;

    @NotNull(message = "Not Null")
    private BigDecimal gia_ban;

    public void loadDomain(chiTietSP ctsp){
        this.setSp(ctsp.getSp());
        this.setMs(ctsp.getMs());
        this.setNsx(ctsp.getNsx());
        this.setDsp(ctsp.getDsp());
        this.setNam_bh(String.valueOf(ctsp.getNam_bh()));
        this.setMo_ta(ctsp.getMo_ta());
        this.setSl_ton(String.valueOf(ctsp.getSl_ton()));
        this.setGia_nhap(ctsp.getGia_nhap());
        this.setGia_ban(ctsp.getGia_ban());
    }
}
