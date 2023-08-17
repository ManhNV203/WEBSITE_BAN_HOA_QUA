package com.example.demo.viewModel;

import com.example.demo.domainModel.chucVu;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class chucVuVM {
    private UUID id;
    @NotBlank(message = "Not Null")
    private String ma;
    @NotBlank(message = "Not Null")
    private String ten;
    public void loadDomain(chucVu cv){
        this.setId(cv.getId());
        this.setMa(cv.getMa());
        this.setTen(cv.getTen());
    }
}
