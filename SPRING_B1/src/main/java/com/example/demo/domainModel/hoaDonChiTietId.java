package com.example.demo.domainModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class hoaDonChiTietId implements Serializable {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "IdHoaDon",
            referencedColumnName = "Id",
            nullable = false
    )
    private hoaDon hd;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "IdChiTietSP",
            referencedColumnName = "Id",
            nullable = false
    )
    private chiTietSP ctsp;
}
