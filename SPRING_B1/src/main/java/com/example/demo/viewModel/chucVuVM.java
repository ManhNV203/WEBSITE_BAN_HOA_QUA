package com.example.demo.viewModel;

import com.example.demo.domainModel.chucVu;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class chucVuVM {
    @NotBlank(message = "Not Null")
    private String ma;
    @NotBlank(message = "Not Null")
    private String ten;
    public void loadDomain(chucVu cv){
        this.setMa(cv.getMa());
        this.setTen(cv.getTen());
    }
}
