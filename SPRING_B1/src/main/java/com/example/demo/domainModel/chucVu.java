package com.example.demo.domainModel;

import com.example.demo.viewModel.chucVuVM;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChucVu")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class chucVu implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @JsonBackReference

    @OneToMany(mappedBy = "cv",cascade = {CascadeType.ALL})
    private List<nhanVien> listNv;

    public void loadCVView(chucVuVM cvVM){
        this.setMa(cvVM.getMa());
        this.setTen(cvVM.getTen());
    }
}
