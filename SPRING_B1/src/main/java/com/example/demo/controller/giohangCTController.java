package com.example.demo.controller;

import com.example.demo.repository.chiTietSanPhamRepository;
import com.example.demo.repository.gioHangChiTietRepository;
import com.example.demo.repository.gioHangRepository;
import com.example.demo.viewModel.gioHangChiTietVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("gio-hang-ct")
public class giohangCTController {

    @Autowired
    private gioHangChiTietRepository ghctRepo;

    @Autowired
    private chiTietSanPhamRepository ctspRepo;

    @Autowired
    private gioHangRepository ghRepo;

    @Autowired
    @Qualifier("ghct_vm")
    private gioHangChiTietVM ghctVM;

    @GetMapping("index")
    public String index(
            Model model
    ){
        model.addAttribute("listGHCT", this.ghctRepo.findAll());
        return "gioHangCT/index";
    }
    @GetMapping("create")
    public String create(
            Model model
    ){
        gioHangChiTietVM ghctVM = new gioHangChiTietVM();
        model.addAttribute("data",ghctVM);
        model.addAttribute("listGH",this.ghRepo.findAll());
        model.addAttribute("listCTSP",this.ctspRepo.findAll());
        return "gioHangCT/form";
    }
    @PostMapping("store")
    public String store(
            Model model,
            @Valid @ModelAttribute("data")gioHangChiTietVM ghvtVM,
            BindingResult result
    ){
        if (result.hasErrors()){
            return "";
        }
        return "";
    }
}
