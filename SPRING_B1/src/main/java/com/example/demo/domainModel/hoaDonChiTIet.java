package com.example.demo.domainModel;

import com.example.demo.viewModel.hoaDonChiTietVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "HoaDonChiTiet")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class hoaDonChiTIet {
    @EmbeddedId
    private hoaDonChiTietId id;

    @Column(name = "SoLuong")
    private Integer so_luong;

    @Column(name = "DonGia")
    private BigDecimal don_gia;

    public void loadView(hoaDonChiTietVM hdctVM){
        hoaDonChiTietId hdctId = new hoaDonChiTietId();
        hdctId.setHd(hdctVM.getHd());
        hdctId.setCtsp(hdctVM.getStsp());
        this.setId(hdctId);
        this.getId().setCtsp(hdctVM.getStsp());
        this.setSo_luong(Integer.valueOf(hdctVM.getSo_luong()));
        this.setDon_gia(hdctVM.getDon_gia());
    }
}
