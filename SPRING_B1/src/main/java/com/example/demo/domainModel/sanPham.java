package com.example.demo.domainModel;

import com.example.demo.viewModel.sanPhamVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "SanPham")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class sanPham {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @OneToMany(mappedBy = "sp")
    private List<chiTietSP> Listctsp;
    public void loadView(sanPhamVM spVM){
        this.setMa(spVM.getMa());
        this.setTen(spVM.getTen());
    }
}
