package com.example.demo.viewModel;

import com.example.demo.domainModel.chiTietSP;
import com.example.demo.domainModel.hoaDon;
import com.example.demo.domainModel.hoaDonChiTIet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class hoaDonChiTietVM {
    @NotNull(message = "Not Null")
    private hoaDon hd;
    @NotNull(message = "Not Null")
    private chiTietSP stsp;
    @NotBlank(message = "Not Null")
    private String so_luong;
    @NotNull(message = "Not Null")
    private BigDecimal don_gia;
    public void loadDomain(hoaDonChiTIet hdct){
        this.setHd(hdct.getId().getHd());
        this.setStsp(hdct.getId().getCtsp());
        this.setSo_luong(String.valueOf(hdct.getSo_luong()));
        this.setDon_gia(hdct.getDon_gia());
    }
}
