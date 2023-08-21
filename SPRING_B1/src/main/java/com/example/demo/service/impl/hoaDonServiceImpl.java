package com.example.demo.service.impl;

import com.example.demo.domainModel.hoaDon;
import com.example.demo.repository.hoaDonRepository;
import com.example.demo.service.hoaDonService;
import com.example.demo.viewModel.hoaDonVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class hoaDonServiceImpl implements hoaDonService {
    @Autowired
    private hoaDonRepository hdRepo;
    @Override
    public List<hoaDonVM> getAllHD() {
        List<hoaDonVM> listHD = new ArrayList<>();
        for (hoaDon hd: this.hdRepo.findAll())
        {
            hoaDonVM hdvm = new hoaDonVM();
            hdvm.setId(hd.getId());
            hdvm.setKhachHang(hd.getKh().getTen());
            hdvm.setNhanVien(hd.getNv().getTen());
            hdvm.setMa(hd.getMa());
            hdvm.setDia_chi(hd.getDia_chi());
            hdvm.setNgay_tao(hd.getNgay_tao());
            hdvm.setNgay_thanh_toan(hd.getNgay_thanh_toan());
            hdvm.setNgay_ship(hd.getNgay_ship());
            hdvm.setNgay_nhan(hd.getNgay_nhan());
            hdvm.setTinh_trang(String.valueOf(hd.getTinh_trang()));
            hdvm.setTen_nguoi_nhan(hd.getTen_nguoi_nhan());
            listHD.add(hdvm);
        }
        return listHD;
    }
}
