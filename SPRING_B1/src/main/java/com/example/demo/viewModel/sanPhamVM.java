package com.example.demo.viewModel;

import com.example.demo.domainModel.sanPham;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class sanPhamVM {
    @NotBlank(message = "Khong De Trong")
    private String ma;
    @NotBlank(message = "Khong De Trong")
    private String ten;
    public void loadDomain(sanPham sp){
        this.setMa(sp.getMa());
        this.setTen(sp.getTen());
    }
}
