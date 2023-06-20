package com.example.demo.domainModel;

import com.example.demo.viewModel.mauSacVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "MauSac")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class mauSac implements java.io.Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @OneToMany(mappedBy = "ms")
    private List<chiTietSP> listctsp;

    public void loadViewM(mauSacVM msVM){
        this.setMa(msVM.getMa());
        this.setTen(msVM.getTen());
    }
}
