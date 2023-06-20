package com.example.demo.domainModel;

import com.example.demo.viewModel.chiTietSPVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class chiTietSP {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne()
    @JoinColumn(
            name = "IdSP",
            referencedColumnName = "Id",
            nullable = true
    )
    private sanPham sp;

    @ManyToOne()
    @JoinColumn(
            name = "IdNSX",
            referencedColumnName = "Id",
            nullable = true
    )
    private nhaSanXuat nsx;

    @ManyToOne()
    @JoinColumn(
            name = "IdMauSac",
            referencedColumnName = "Id",
            nullable = true
    )
    private mauSac ms;

    @ManyToOne()
    @JoinColumn(
            name = "IdDongSP",
            referencedColumnName = "Id",
            nullable = true
    )
    private dongSP dsp;

    @Column(name = "NamBH")
    private Integer nam_bh;

    @Column(name = "MoTa")
    private String mo_ta;

    @Column(name = "SoLuongTon")
    private Integer sl_ton;

    @Column(name = "GiaNhap")
    private BigDecimal gia_nhap;

    @Column(name = "GiaBan")
    private BigDecimal gia_ban;
    @OneToMany(mappedBy = "id.ctsp")
    private List<hoaDonChiTIet> listhdct;

    @OneToMany(mappedBy = "id.ctspgh")
    private List<gioHangChiTiet> listghct;

    public void loadView(chiTietSPVM ctspVM){
        this.setSp(ctspVM.getSp());
        this.setMs(ctspVM.getMs());
        this.setNsx(ctspVM.getNsx());
        this.setDsp(ctspVM.getDsp());
        this.setNam_bh(Integer.valueOf(ctspVM.getNam_bh()));
        this.setMo_ta(ctspVM.getMo_ta());
        this.setSl_ton(Integer.valueOf(ctspVM.getSl_ton()));
        this.setGia_nhap(ctspVM.getGia_nhap());
        this.setGia_ban(ctspVM.getGia_ban());
    }
}
