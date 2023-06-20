package com.example.demo.domainModel;

import com.example.demo.viewModel.khachHangVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "KhachHang")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class khachHang {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TenDem")
    private String ten_dem;

    @Column(name = "Ho")
    private String ho;

    @Column(name = "NgaySinh")
    private Date ngay_sinh;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "DiaChi")
    private String dia_chi;

    @Column(name = "ThanhPho")
    private String thanh_pho;

    @Column(name = "QuocGia")
    private String quoc_gia;

    @Column(name = "MatKhau")
    private String mat_khau;

    @OneToMany(mappedBy = "kh")
    private List<hoaDon> listhd;

    @OneToMany(mappedBy = "kh")
    private List<gioHang> listgd;

    public void loadView(khachHangVM khVm){
        this.setMa(khVm.getMa());
        this.setTen(khVm.getTen());
        this.setTen_dem(khVm.getTen_dem());
        this.setHo(khVm.getHo());
        this.setNgay_sinh(Date.valueOf(khVm.getNgay_sinh()));
        this.setSdt(khVm.getSdt());
        this.setDia_chi(khVm.getDia_chi());
        this.setQuoc_gia(khVm.getQuoc_gia());
        this.setThanh_pho(khVm.getThanh_pho());
        this.setMat_khau(khVm.getMat_khau());
    }
}
