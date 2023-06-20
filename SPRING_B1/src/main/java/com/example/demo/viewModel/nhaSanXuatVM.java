package com.example.demo.viewModel;

import com.example.demo.domainModel.nhaSanXuat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class nhaSanXuatVM {
    @NotBlank(message = "Not Null")
    private String ma;
    @NotBlank(message = "Not Null")
    private String ten;
    public void loadDomian(nhaSanXuat nsx){
        this.setMa(nsx.getMa());
        this.setTen(nsx.getTen());
    }
}
