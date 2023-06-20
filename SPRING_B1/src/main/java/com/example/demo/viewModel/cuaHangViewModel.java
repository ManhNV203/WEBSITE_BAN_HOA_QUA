package com.example.demo.viewModel;

import com.example.demo.domainModel.cuaHang;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class cuaHangViewModel {

    @NotBlank(message = "Mã không để trống")
    private String ma;

    @NotBlank(message = "tên không để trống")
    private String ten;

    @NotBlank(message = "tên không để trống")
    private String diaChi;

    @NotBlank(message = "Quốc gia không để trống")
    private String quocGia;

    @NotBlank(message = "Thành Phố không để trống")
    private String thanhPho;
    public void loadDomainModel(cuaHang ch){
        this.setMa( ch.getMa() );
        this.setTen( ch.getTen() );
        this.setDiaChi( ch.getDia_chi());
        this.setThanhPho( ch.getThanh_pho() );
        this.setQuocGia( ch.getQuoc_gia() );
    }
}
