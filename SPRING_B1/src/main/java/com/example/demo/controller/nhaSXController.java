package com.example.demo.controller;

import com.example.demo.domainModel.nhaSanXuat;
import com.example.demo.repository.nhaSanXuanRepository;
import com.example.demo.viewModel.nhaSanXuatVM;
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
@RequestMapping("nhasx")
public class nhaSXController {

    @Autowired
    private nhaSanXuanRepository nsxRepo;

    @Autowired
    @Qualifier("nsx_vm")
    private nhaSanXuatVM nsxVM;
    @GetMapping("index")
    public String index(
            Model model,
        @RequestParam(name = "page", defaultValue = "0")Integer pageNo
    ){
        Pageable pageable = PageRequest.of(pageNo,4);
        Page<nhaSanXuat> pageNSX = this.nsxRepo.findAll(pageable);
        model.addAttribute("listNSX", pageNSX);
        return "nhaSX/index";
    }
    @GetMapping("create")
    public String create(
            Model model
    ){
        nhaSanXuatVM nsxVM = new nhaSanXuatVM();
        model.addAttribute("data", nsxVM);
        model.addAttribute("action","/nhasx/store");
        return "nhaSX/form";
    }
    @PostMapping("store")
    public String store(
            Model model,
            @Valid @ModelAttribute("data") nhaSanXuatVM nsxVM,
            BindingResult result
    ){
        if (result.hasErrors()){
            return "nhaSX/form";
        }
        nhaSanXuat nsx = new nhaSanXuat();
        nsx.loadView(nsxVM);
        this.nsxRepo.save(nsx);
        return "redirect:/nhasx/index";
    }
    @GetMapping("delete/{id}")
    public String delete(
            @PathVariable("id")nhaSanXuat nsx
    ){
        this.nsxRepo.delete(nsx);
        return "redirect:/nhasx/index";
    }
    @GetMapping("edit/{id}")
    public String edit(
            Model model,
            @PathVariable("id") nhaSanXuat nsx
    ){
        nsxVM.loadDomian(nsx);
        model.addAttribute("data",nsxVM);
        model.addAttribute("action","/nhasx/update/"+ nsx.getId());
        return "nhaSX/form";
    }
    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id")nhaSanXuat nsx,
            Model model,
            @Valid @ModelAttribute("data")nhaSanXuatVM nsxVM,
            BindingResult result
    ){
        if (result.hasErrors()){
            model.addAttribute("data",nsxVM);
            model.addAttribute("action","/nhasx/update/"+ nsx.getId());
            return "nhaSX/form";
        }
        nsx.loadView(nsxVM);
        this.nsxRepo.save(nsx);
        return "redirect:/nhasx/index";
    }
}
