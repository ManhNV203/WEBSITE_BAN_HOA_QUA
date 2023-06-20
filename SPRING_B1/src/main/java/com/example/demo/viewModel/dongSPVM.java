package com.example.demo.viewModel;

import com.example.demo.domainModel.dongSP;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class dongSPVM {
    @NotBlank(message = "Not Null")
    private String ma;

    @NotBlank(message = "Not Null")
    private String ten;

    public void LoadDomain(dongSP dsp){
        this.setMa(dsp.getMa());
        this.setTen(dsp.getTen());
    }
}
