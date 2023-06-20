package com.example.demo.controller;

import com.example.demo.domainModel.dongSP;
import com.example.demo.repository.dongSPRepository;
import com.example.demo.viewModel.dongSPVM;
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
@RequestMapping("dongsp")
public class dongSPController {

    @Autowired
    private dongSPRepository dspRepo;

    @Autowired
    @Qualifier("dsp_vm")
    private dongSPVM dspVM;

    @GetMapping("index")
    public String index(
            Model model,
            @RequestParam(name = "page",defaultValue = "0")Integer pageNo
    ){
        Pageable pageable = PageRequest.of(pageNo, 4);
        Page<dongSP> dspPage = this.dspRepo.findAll(pageable);
        model.addAttribute("listDSP",dspPage);
        return "dongSP/index";
    }
    @GetMapping("create")
    public String create(Model model){
        dongSPVM dspVM = new dongSPVM();
        model.addAttribute("data",dspVM);
        model.addAttribute("action","/dongsp/store");
        return "dongSP/form";
    }
    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("data") dongSPVM dspVM,
            BindingResult result
    ){
        if (result.hasErrors()){
            return "dongSP/form";
        }
        dongSP dsp = new dongSP();
        dsp.loadView(dspVM);
        this.dspRepo.save(dsp);
        return "redirect:/dongsp/index";
    }
    @GetMapping("delete/{id}")
    public String delete(
            @PathVariable("id") dongSP dsp
    ){
        this.dspRepo.delete(dsp);
        return "redirect:/dongsp/index";
    }
    @GetMapping("edit/{id}")
    public String edit(
            @PathVariable("id") dongSP dsp,
            Model model
    ){
        dspVM.LoadDomain(dsp);
        model.addAttribute("data", dspVM);
        model.addAttribute("action","/dongsp/update/"+ dsp.getId());
        return "dongSP/form";
    }
    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") dongSP dsp,
            Model model,
            @Valid @ModelAttribute("data") dongSPVM dspVM,
            BindingResult result
    ){
        if (result.hasErrors()){
            model.addAttribute("data",dspVM);
            model.addAttribute("action","/dongsp/update/" + dsp.getId());
            return "dongSP/form";
        }
        dsp.loadView(dspVM);
        this.dspRepo.save(dsp);
        return "redirect:/dongsp/index";
    }
}
