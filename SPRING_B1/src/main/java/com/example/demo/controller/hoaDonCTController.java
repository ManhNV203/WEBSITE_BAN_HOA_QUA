package com.example.demo.controller;

import com.example.demo.domainModel.hoaDonChiTIet;
import com.example.demo.repository.chiTietSanPhamRepository;
import com.example.demo.repository.hoaDonChiTietRepository;
import com.example.demo.repository.hoaDonRepository;
import com.example.demo.viewModel.hoaDonChiTietVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hoa-don-ct")
public class hoaDonCTController {
    @Autowired
    private hoaDonChiTietRepository hdctRepo;

    @Autowired
    private hoaDonRepository hdRepo;

    @Autowired
    private chiTietSanPhamRepository ctspRepo;

    @GetMapping("index")
    public String index(
            Model model
    ){
        model.addAttribute("listHDCT",hdctRepo.findAll());
        return "hoaDonChiTiet/index";
    }
    @GetMapping("create")
    public String create(
            Model model
    ){

        hoaDonChiTietVM hdctVM = new hoaDonChiTietVM();
        model.addAttribute("data",hdctVM);
        model.addAttribute("listHD",this.hdRepo.findAll());
        model.addAttribute("listCTSP",this.ctspRepo.findAll());
        return "hoaDonChiTiet/hoaDonChiTiet";
    }
    @PostMapping("store")
    public String store(
            Model model,
            @Valid @ModelAttribute("data")hoaDonChiTietVM hdctVM,
            BindingResult result
    ){
        if (result.hasErrors()){
            model.addAttribute("listHD",this.hdRepo.findAll());
            model.addAttribute("listCTSP",this.ctspRepo.findAll());
            return "hoaDonChiTiet/hoaDonChiTiet";
        }
        hoaDonChiTIet hdct = new hoaDonChiTIet();
        hdct.loadView(hdctVM);
        System.out.println(hdct.getId());
        this.hdctRepo.save(hdct);
        return "redirect:/hoa-don-ct/index";
    }

}
