package com.example.demo.domainModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "NhanVien")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class nhanVien implements Serializable {
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

    @Column(name = "GioiTinh")
    private String gioi_tinh;

    @Column(name = "NgaySinh")
    private Date ngay_sinh;

    @Column(name = "DiaChi")
    private String dia_chi;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "MatKhau")
    private String mat_khau;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "IdCH",
            referencedColumnName = "Id",
            nullable = true
    )
    private cuaHang ch;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "IdCV",
            referencedColumnName = "Id",
            nullable =true
    )
    private chucVu cv;

    @Column(name = "IdGuiBC")
    private UUID id_GuiBCChucVu;

    @Column(name = "TrangThai")
    private Integer trang_thai;


//    public void loadView(nhanVienVM nvView){
//        this.setMa(nvView.getMa());
//        this.setTen(nvView.getTen());
//        this.setTen_dem(nvView.getTen_dem());
//        this.setHo(nvView.getHo());
//        this.setNgay_sinh(Date.valueOf(nvView.getNgay_sinh()));
//        this.setGioi_tinh(nvView.getGioi_tinh());
//        this.setDia_chi(nvView.getDia_chi());
//        this.setSdt(nvView.getSdt());
//        this.setMat_khau(nvView.getMat_khau());
//        this.setTrang_thai(Integer.valueOf(nvView.getTrang_thai()));
//        this.setMat_khau(nvView.getMat_khau());
//    }
}
