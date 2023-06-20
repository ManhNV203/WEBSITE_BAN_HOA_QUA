package com.example.demo.domainModel;

import com.example.demo.viewModel.dongSPVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "DongSP")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class dongSP {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @OneToMany(mappedBy = "dsp")
    private List<chiTietSP> listctsp;

    public void loadView(dongSPVM dspVM){
        this.setMa(dspVM.getMa());
        this.setTen(dspVM.getTen());
    }

}
