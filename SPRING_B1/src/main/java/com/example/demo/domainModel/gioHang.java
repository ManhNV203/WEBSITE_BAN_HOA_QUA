package com.example.demo.domainModel;

import com.example.demo.viewModel.gioHangVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "GioHang")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class gioHang {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne()
    @JoinColumn(
            name = "IdKH",
            referencedColumnName = "Id",
            nullable = true
    )
    private khachHang kh;

    @ManyToOne()
    @JoinColumn(
            name = "IdNV",
            referencedColumnName = "Id",
            nullable = true
    )
    private nhanVien nv;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayTao")
    private Date ngay_tao;

    @Column(name = "NgayThanhToan")
    private Date ngay_thanh_toan;

    @Column(name = "TenNguoiNhan")
    private String ten_nguoi_nhan;

    @Column(name = "DiaChi")
    private String dia_chi;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "TinhTrang")
    private Integer tinh_trang;
    @OneToMany(mappedBy = "id.gh")
    private List<gioHangChiTiet> listghct;

    public  void loadView(gioHangVM ghVM){
        this.setKh(ghVM.getKh());
        this.setNv(ghVM.getNv());
        this.setMa(ghVM.getMa());
        this.setNgay_tao(Date.valueOf(ghVM.getNgay_tao()));
        this.setNgay_thanh_toan(Date.valueOf(ghVM.getNgay_thanh_toan()));
        this.setTen_nguoi_nhan(ghVM.getTen_nguoi_nhan());
        this.setDia_chi(ghVM.getDia_chi());
        this.setSdt(ghVM.getSdt());
        this.setTinh_trang(Integer.valueOf(ghVM.getTinh_trang()));
    }

}
