package com.example.demo.domainModel;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class gioHangChiTietId implements Serializable {
    @ManyToOne()
    @JoinColumn(
            name = "IdGioHang",
            referencedColumnName = "Id",
            nullable = false
    )
    private gioHang gh;
    @ManyToOne
    @JoinColumn(
            name = "IdChiTietSP",
            referencedColumnName = "Id",
            nullable = false
    )
    private chiTietSP ctspgh;
}
