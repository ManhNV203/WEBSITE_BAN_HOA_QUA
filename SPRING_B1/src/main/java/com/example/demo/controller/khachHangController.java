package com.example.demo.controller;

import com.example.demo.domainModel.khachHang;
import com.example.demo.repository.khachHangRepository;
import com.example.demo.viewModel.khachHangVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("khach-hang")
public class khachHangController {
    @Autowired
    private khachHangRepository khRepo;

    @Autowired
    @Qualifier("kh_vm")
    private khachHangVM khVM;

    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("listKH",khRepo.findAll());
        return "khachHang/index";
    }
    @GetMapping("create")
    public String create(
            Model model
    ){
        khachHangVM khView = new khachHangVM();
        model.addAttribute("data",khView);
        return "khachHang/create";
    }
    @PostMapping("store")
    public String store(
            Model model,
            @Valid @ModelAttribute("data") khachHangVM khVM,
            BindingResult result
    ){
        if (result.hasErrors()){
            model.addAttribute("data",khVM);
            return "khachHang/create";
        }else {
            khachHang kh = new khachHang();
            kh.loadView(khVM);
            this.khRepo.save(kh);
            return "redirect:/khach-hang/index";
        }
    }
    @GetMapping("delete/{id}")
    public String delete(
            @PathVariable("id") khachHang kh
    ){
        this.khRepo.delete(kh);
        return "redirect:/khach-hang/index";
    }
    @GetMapping("edit/{id}")
    public String edit(
            Model model,
            @PathVariable("id") khachHang kh
    ){
        khVM.loadDomain(kh);
        model.addAttribute("data",khVM);
        model.addAttribute("action","/khach-hang/update/"+ kh.getId());
        return "khachHang/edit";
    }
    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") khachHang kh,
            Model model,
            @Valid @ModelAttribute("data") khachHangVM khVM,
            BindingResult result
    ){
        if (result.hasErrors()){
            model.addAttribute("data",khVM);
            model.addAttribute("action","/khach-hang/update/"+ kh.getId());
            return "khachHang/edit";
        }else {
            kh.loadView(khVM);
            this.khRepo.save(kh);
            return "redirect:/khach-hang/index";
        }

    }
}
