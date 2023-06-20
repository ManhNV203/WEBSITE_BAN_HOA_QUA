package com.example.demo.domainModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "GioHangChiTiet")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class gioHangChiTiet {
    @EmbeddedId
    private gioHangChiTietId id;


    @Column(name = "SoLuong")
    private Integer so_luong;

    @Column(name = "DonGia")
    private BigDecimal don_gia;

    @Column(name = "DonGiaKhiGiam")
    private BigDecimal don_gia_khi_giam;
}
