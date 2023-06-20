package com.example.demo.viewModel;

import com.example.demo.domainModel.mauSac;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor  @AllArgsConstructor
public class mauSacVM {
    @NotBlank(message = "Not Null")
    private String ma;
    @NotBlank(message = "Not Null")
    private String ten;
    public void loadDomain(mauSac ms){
        this.setMa(ms.getMa());
        this.setTen(ms.getTen());
    }
}
