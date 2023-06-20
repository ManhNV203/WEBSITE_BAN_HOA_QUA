package com.example.demo.domainModel;

import com.example.demo.viewModel.nhaSanXuatVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "NSX")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class nhaSanXuat {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @OneToMany(mappedBy = "nsx")
    private List<chiTietSP> listctsp;
    public void loadView(nhaSanXuatVM sanXuatVM){
        this.setMa(sanXuatVM.getMa());
        this.setTen(sanXuatVM.getTen());
    }
}
