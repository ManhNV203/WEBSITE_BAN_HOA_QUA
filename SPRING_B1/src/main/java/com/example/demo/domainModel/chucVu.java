package com.example.demo.domainModel;

import com.example.demo.viewModel.chucVuVM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChucVu")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class chucVu {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @OneToMany(mappedBy = "cv")
    private List<nhanVien> listNv;

    public void loadCVView(chucVuVM cvVM){
        this.setMa(cvVM.getMa());
        this.setTen(cvVM.getTen());
    }
}
