package com.example.demo.domainModel;

import com.example.demo.viewModel.cuaHangViewModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "CuaHang")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class cuaHang implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")
    private String  ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "DiaChi")
    private String dia_chi;

    @Column(name = "ThanhPho")
    private String thanh_pho;

    @Column(name = "QuocGia")
    private String quoc_gia;
    public void loadViewModel(cuaHangViewModel vm){
        this.setMa( vm.getMa() );
        this.setTen( vm.getTen() );
        this.setDia_chi( vm.getDiaChi());
        this.setThanh_pho( vm.getThanhPho() );
        this.setQuoc_gia( vm.getQuocGia() );
    }
    @JsonBackReference
    @OneToMany(mappedBy = "ch",cascade = {CascadeType.ALL})
    private List<nhanVien> listNv;


}
