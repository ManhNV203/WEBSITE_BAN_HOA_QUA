package com.example.demo.controller;

import com.example.demo.domainModel.cuaHang;
import com.example.demo.domainModel.nhanVien;
import com.example.demo.repository.chucVuRepository;
import com.example.demo.repository.cuaHangRepository;
import com.example.demo.repository.nhanVienRepository;
import com.example.demo.viewModel.cuaHangViewModel;
import com.example.demo.viewModel.nhanVienVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("nhan-vien")
public class nhanVienController {
    @Autowired
    private nhanVienRepository nvRepo;
    @Autowired
    private cuaHangRepository chRepo;
    @Autowired
    private chucVuRepository cvRepo;
    @Autowired
    @Qualifier("nv_vm")
    private nhanVienVM nvVm;

    @GetMapping("index")
    public String index(
            @RequestParam(name = "page",defaultValue = "0") Integer pageNo,
            Model model
    ) {
        Pageable pageable = PageRequest.of(pageNo, 3);
        Page<nhanVien> nvPage = nvRepo.findAll(pageable);
        model.addAttribute("listNV", nvPage);
        return "nhanVien/index";
    }

    @GetMapping("create")
    public String create(
            Model model
    ) {
        nhanVienVM nv = new nhanVienVM();
        model.addAttribute("data", nv);
        model.addAttribute("datach", chRepo.findAll());
        model.addAttribute("datacv", cvRepo.findAll());
        return "/nhanVien/create";
    }

    @GetMapping("delete/{id}")
    public String delete(
            @PathVariable("id") nhanVien nv
    ) {
        this.nvRepo.delete(nv);
        return "redirect:/nhan-vien/index";
    }

    @PostMapping("store")
    public String store(
            Model model,
            @Valid @ModelAttribute("data") nhanVienVM vienVM,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("data", vienVM);
            model.addAttribute("datach", chRepo.findAll());
            model.addAttribute("datacv", cvRepo.findAll());
            return "nhanVien/create";
        } else {
            nhanVien nv = new nhanVien();
            nv.loadView(vienVM);
            this.nvRepo.save(nv);
            return "redirect:/nhan-vien/index";
        }
    }

    @GetMapping("edit/{id}")
    public String edit(
            Model model,
            @PathVariable("id") nhanVien nv
    ) {
        nvVm.loadDomain(nv);
        model.addAttribute("data", nvVm);
        model.addAttribute("action", "/nhan-vien/update/" + nv.getId());
        model.addAttribute("datach", chRepo.findAll());
        model.addAttribute("datacv", cvRepo.findAll());
        return "nhanVien/edit";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") nhanVien nv,
            Model model,
            @Valid @ModelAttribute("data") nhanVienVM nvVm,
            BindingResult result
    ){
        if (result.hasErrors()){
            model.addAttribute("data",nv);
            model.addAttribute("action", "/nhan-vien/update/"+nv.getId());
            model.addAttribute("datach", chRepo.findAll());
            model.addAttribute("datacv", cvRepo.findAll());
            return "nhanVien/edit";
        }

        nv.loadView(nvVm);
        this.nvRepo.save(nv);
        return "redirect:/nhan-vien/index";
    }
}
