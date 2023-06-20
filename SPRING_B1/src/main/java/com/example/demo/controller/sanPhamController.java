package com.example.demo.controller;

import com.example.demo.domainModel.mauSac;
import com.example.demo.domainModel.sanPham;
import com.example.demo.repository.sanPhamRepository;
import com.example.demo.viewModel.mauSacVM;
import com.example.demo.viewModel.sanPhamVM;
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
@RequestMapping("san-pham")
public class sanPhamController {

    @Autowired
    private sanPhamRepository spRepo;
    @Autowired
    @Qualifier("sp_vm")
    private sanPhamVM spVM;

    @GetMapping("index")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0")Integer pageNo
    ){
        Pageable pageable = PageRequest.of(pageNo, 4);
        Page<sanPham> spPage = this.spRepo.findAll(pageable);
        model.addAttribute("listSP", spPage);
        return "sanPham/index";
    }

    @GetMapping("create")
    public String create(
            Model model
    ){
        sanPhamVM spVM = new sanPhamVM();
        model.addAttribute("action","/san-pham/store");
        model.addAttribute("data",spVM);
        return "sanPham/form";
    }
    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("data") sanPhamVM spVM,
            BindingResult result
    ){
        if (result.hasErrors()){
            return "sanPham/form";
        }
        sanPham sp = new sanPham();
        sp.loadView(spVM);
        this.spRepo.save(sp);
        return "redirect:/san-pham/index";
    }
    @GetMapping("delete/{id}")
    public String delete(
            @PathVariable("id") sanPham sp
    ){
        this.spRepo.delete(sp);
        return "redirect:/san-pham/index";
    }
    @GetMapping("edit/{id}")
    public String edit(
            @PathVariable("id") sanPham sp,
            Model model
    ){
        spVM.loadDomain(sp);
        model.addAttribute("data", spVM);
        model.addAttribute("action","/san-pham/update/" + sp.getId());
        return "sanPham/form";
    }
    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") sanPham sp,
            Model model,
            @Valid @ModelAttribute("data") sanPhamVM spVM,
            BindingResult result
    ){
        if (result.hasErrors()){
            model.addAttribute("data", spVM);
            model.addAttribute("action","/san-pham/update/" + sp.getId());
            return "sanPham/form";
        }
        sp.loadView(spVM);
        this.spRepo.save(sp);
        return "redirect:/san-pham/index";
    }
}
