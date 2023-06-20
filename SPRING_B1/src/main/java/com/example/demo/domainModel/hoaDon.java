package com.example.demo.domainModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "HoaDon")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class hoaDon {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "IdKH",
            referencedColumnName = "Id",
            nullable = true
    )
    private khachHang kh;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "IdNV",
            referencedColumnName = "Id",
            nullable = false
    )
    private nhanVien nv;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayTao")
    private Date ngay_tao;

    @Column(name = "NgayThanhToan")
    private Date ngay_thanh_toan;

    @Column(name = "NgayShip")
    private Date ngay_ship;

    @Column(name = "NgayNhan")
    private Date ngay_nhan;

    @Column(name = "TinhTrang")
    private Integer tinh_trang;

    @Column(name = "TenNguoiNhan")
    private String ten_nguoi_nhan;

    @Column(name = "DiaChi")
    private String dia_chi;

    @Column(name = "Sdt")
    private String sdt;
    @OneToMany(mappedBy = "id.hd")
    private List<hoaDonChiTIet> listhdct;
}
