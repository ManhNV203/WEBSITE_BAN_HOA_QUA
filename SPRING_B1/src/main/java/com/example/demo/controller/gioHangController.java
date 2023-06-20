package com.example.demo.controller;

import com.example.demo.domainModel.gioHang;
import com.example.demo.repository.gioHangRepository;
import com.example.demo.repository.khachHangRepository;
import com.example.demo.repository.nhanVienRepository;
import com.example.demo.viewModel.gioHangVM;
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

@Controller
@RequestMapping("gio-hang")
public class gioHangController {

    @Autowired
    private gioHangRepository ghRepo;

    @Autowired
    private khachHangRepository khRepo;

    @Autowired
    private nhanVienRepository nvRepo;

    @Autowired
    @Qualifier("gh_vm")
    private gioHangVM ghVM;

    @GetMapping("index")
    public String index(
        Model model,
        @RequestParam(name = "page", defaultValue = "0")Integer pageNo
    ){
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<gioHang> pageGH = this.ghRepo.findAll(pageable);
        model.addAttribute("listGH",pageGH);
        return "gioHang/index";
    }
    @GetMapping("create")
    public String create(
        Model model
    ){
        gioHangVM ghVM = new gioHangVM();
        model.addAttribute("data",ghVM);
        model.addAttribute("action","/gio-hang/store");
        model.addAttribute("listKH",this.khRepo.findAll());
        model.addAttribute("listNV",this.nvRepo.findAll());
        return "gioHang/from";
    }
    @PostMapping("store")
    public String store(
            Model model,
            @Valid @ModelAttribute("data")gioHangVM ghVM,
            BindingResult result
    ){
        if (result.hasErrors()){
            model.addAttribute("data",ghVM);
            model.addAttribute("action","/gio-hang/store");
            model.addAttribute("listKH",this.khRepo.findAll());
            model.addAttribute("listNV",this.nvRepo.findAll());
            return "gioHang/from";
        }
        gioHang gh = new gioHang();
        gh.loadView(ghVM);
        this.ghRepo.save(gh);
        return "redirect:/gio-hang/index";
    }
    @GetMapping("delete/{id}")
    public String delete(
            @PathVariable("id")gioHang gh
    ){
        this.ghRepo.delete(gh);
        return "redirect:/gio-hang/index";
    }

    @GetMapping("edit/{id}")
    public String edit(
            @PathVariable("id") gioHang gh,
            Model model
    ){
        ghVM.loadDomain(gh);
        model.addAttribute("data",ghVM);
        model.addAttribute("action","/gio-hang/update/" + gh.getId());
        model.addAttribute("listKH",this.khRepo.findAll());
        model.addAttribute("listNV",this.nvRepo.findAll());
        return "gioHang/from";
    }
    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") gioHang gh,
            Model model,
            @Valid @ModelAttribute("data")gioHangVM ghVm,
            BindingResult result
    ){
        if (result.hasErrors()){
            model.addAttribute("data",ghVM);
            model.addAttribute("action","/gio-hang/update/" + gh.getId());
            model.addAttribute("listKH",this.khRepo.findAll());
            model.addAttribute("listNV",this.nvRepo.findAll());
            return "gioHang/from";
        }
        gh.loadView(ghVm);
        this.ghRepo.save(gh);
        return "redirect:/gio-hang/index";
    }
}
