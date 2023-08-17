package com.example.demo;

import com.example.demo.viewModel.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class beanViewModel {
    @Bean("ch_vm")
    public cuaHangViewModel getCuaHangVm(){
        cuaHangViewModel chVM = new cuaHangViewModel();
        return chVM;
    }

    @Bean("nv_vm")
    public nhanVienDto getNhanVienVm(){
        nhanVienDto nvVM = new nhanVienDto();
        return nvVM;
    }

    @Bean("kh_vm")
    public khachHangVM getKhachHangVM(){
        khachHangVM khVM = new khachHangVM();
        return khVM;
    }
    @Bean("ms_vm")
    public mauSacVM getMauSacVM(){
        mauSacVM msVM = new mauSacVM();
        return msVM;
    }
    @Bean("dsp_vm")
    public dongSPVM getdongSPVM(){
        dongSPVM dspVM = new dongSPVM();
        return dspVM;
    }
    @Bean("nsx_vm")
    public nhaSanXuatVM getNhaSXVM(){
        nhaSanXuatVM nsxVM = new nhaSanXuatVM();
        return nsxVM;
    }
    @Bean("sp_vm")
    public sanPhamVM getSanPhamVm(){
        sanPhamVM spVM = new sanPhamVM();
        return spVM;
    }
    @Bean("ctsp_vm")
    public chiTietSPVM getChiTeitSP(){
        chiTietSPVM ctspVM = new chiTietSPVM();
        return ctspVM;
    }
    @Bean("cv_vm")
    public chucVuVM getChucVu(){
        chucVuVM cvVM = new chucVuVM();
        return cvVM;
    }
    @Bean("hd_vm")
    public hoaDonVM getHoaDon(){
        hoaDonVM hdVm = new hoaDonVM();
        return hdVm;
    }
    @Bean("hdct_vm")
    public hoaDonChiTietVM getHoaDonChiTiet(){
        hoaDonChiTietVM hdctVM = new hoaDonChiTietVM();
        return hdctVM;
    }
    @Bean("gh_vm")
    public gioHangVM getGiohang(){
        gioHangVM ghVM = new gioHangVM();
        return ghVM;
    }
    @Bean("ghct_vm")
    public gioHangChiTietVM getGHCHiTiet(){
        gioHangChiTietVM ghctVM = new gioHangChiTietVM();
        return ghctVM;
    }

}
