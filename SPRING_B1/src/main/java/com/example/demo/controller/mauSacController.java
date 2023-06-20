package com.example.demo.controller;

import com.example.demo.domainModel.mauSac;
import com.example.demo.repository.mauSacRepository;
import com.example.demo.viewModel.mauSacVM;
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
@RequestMapping("mau-sac")
public class mauSacController {
    @Autowired
    private mauSacRepository msRepo;

    @Autowired
    @Qualifier("ms_vm")
    private mauSacVM msVm;

    @GetMapping("index")
    public String index(
            Model model,
            @RequestParam(name = "page",defaultValue = "0") Integer pageNo
    ){
        Pageable pageable = PageRequest.of(pageNo,3);
        Page<mauSac> msPage = this.msRepo.findAll(pageable);
        model.addAttribute("listMS",msPage);
        return "mauSac/index";
    }
    @GetMapping("create")
    public String create(Model model){
        mauSacVM ms = new mauSacVM();
        model.addAttribute("data", ms);
        model.addAttribute("action","/mau-sac/store");
        return "mauSac/form";
    }
    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("data") mauSacVM msVm,
            BindingResult result
    ){
        if (result.hasErrors()){
            return "mauSac/form";
        }
        mauSac ms = new mauSac();
        ms.loadViewM(msVm);
        this.msRepo.save(ms);
        return "redirect:/mau-sac/index";
    }
    @GetMapping("delete/{id}")
    public String delete(
            @PathVariable("id") mauSac ms
    ){
        this.msRepo.delete(ms);
        return "redirect:/mau-sac/index";
    }
    @GetMapping("edit/{id}")
    public String edit(
            @PathVariable("id") mauSac ms,
            Model model
    ){
        msVm.loadDomain(ms);
        model.addAttribute("data", msVm);
        model.addAttribute("action", "/mau-sac/update/" + ms.getId());
        return "mauSac/form";
    }
    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") mauSac ms,
            Model model,
            @Valid @ModelAttribute("data")mauSacVM msVm,
            BindingResult result
    ){
        if (result.hasErrors()){
            model.addAttribute("data",msVm);
            model.addAttribute("action", "/mau-sac/update/" +ms.getId());
            return "mauSac/form";
        }
        ms.loadViewM(msVm);
        this.msRepo.save(ms);
        return "redirect:/mau-sac/index";
    }

}
