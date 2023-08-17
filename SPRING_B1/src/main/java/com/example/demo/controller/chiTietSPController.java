package com.example.demo.controller;

import com.example.demo.domainModel.chiTietSP;
import com.example.demo.repository.*;
import com.example.demo.viewModel.chiTietSPVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("chi-tiet-sp")
public class chiTietSPController {

    @Autowired
    private chiTietSanPhamRepository ctspRepo;

    @Autowired
    private sanPhamRepository spRepo;

    @Autowired
    private nhaSanXuanRepository nsxRepo;

    @Autowired
    private mauSacRepository msRepo;

    @Autowired
    private dongSPRepository dspRepo;

    @Autowired
    @Qualifier("ctsp_vm")
    private chiTietSPVM ctspVM;

    @GetMapping("index")
//    public String index(
//            Model model,
//            @RequestParam(name = "page", defaultValue = "0")Integer pageNo
//    ){
//        Pageable pageable = PageRequest.of(pageNo,4);
//        Page<chiTietSP> pageCtsp = this.ctspRepo.findAll(pageable);
//        model.addAttribute("listCTSP", pageCtsp);
//        return "chiTietSP/index";
//    }
    public ResponseEntity<List<chiTietSPVM>> getAll(){
        List<chiTietSPVM> listch = new ArrayList<>();
        for (chiTietSP ch: this.ctspRepo.findAll()) {
            chiTietSPVM chVM = new chiTietSPVM();
            chVM.loadDomain(ch);
            listch.add(chVM);
        }
        System.out.println(listch);
        return new ResponseEntity<>(listch, HttpStatus.OK);
    }
    @GetMapping("create")
    public String create(
            Model model
    ){
        chiTietSPVM ctspVM = new chiTietSPVM();
        model.addAttribute("data",ctspVM);
        model.addAttribute("action","/chi-tiet-sp/store");
        model.addAttribute("listSP",this.spRepo.findAll());
        model.addAttribute("listNSX",this.nsxRepo.findAll());
        model.addAttribute("listMS",this.msRepo.findAll());
        model.addAttribute("listDSP",this.dspRepo.findAll());
        return "chiTietSP/form";
    }

    @PostMapping("store")
    public String store(
            Model model,
            @Valid @ModelAttribute("data") chiTietSPVM ctspVM,
            BindingResult result
    ){
        if (result.hasErrors()){
            model.addAttribute("data",ctspVM);
            model.addAttribute("action","/chi-tiet-sp/store");
            model.addAttribute("listSP",this.spRepo.findAll());
            model.addAttribute("listNSX",this.nsxRepo.findAll());
            model.addAttribute("listMS",this.msRepo.findAll());
            model.addAttribute("listDSP",this.dspRepo.findAll());
            return "chiTietSP/form";
        }
        chiTietSP ctsp = new chiTietSP();
        ctsp.loadView(ctspVM);
        this.ctspRepo.save(ctsp);
        return "redirect:/chi-tiet-sp/index";
    }
    @GetMapping("delete/{id}")
    public String delete(
            @PathVariable("id")chiTietSP ctsp
    ){
        this.ctspRepo.delete(ctsp);
        return "redirect:/chi-tiet-sp/index";
    }
    @GetMapping("edit/{id}")
    public String edit(
            @PathVariable("id")chiTietSP ctsp,
            Model model
    ){
        ctspVM.loadDomain(ctsp);
        model.addAttribute("data",ctspVM);
        model.addAttribute("listSP",this.spRepo.findAll());
        model.addAttribute("listNSX",this.nsxRepo.findAll());
        model.addAttribute("listMS",this.msRepo.findAll());
        model.addAttribute("listDSP",this.dspRepo.findAll());
        model.addAttribute("action","/chi-tiet-sp/update/" + ctsp.getId());
        return "chiTietSP/form";
    }
    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id")chiTietSP ctsp,
            Model model,
            @Valid @ModelAttribute("data")chiTietSPVM ctspVM,
            BindingResult result
    ){
        if (result.hasErrors()){
            model.addAttribute("data",ctspVM);
            model.addAttribute("listSP",this.spRepo.findAll());
            model.addAttribute("listNSX",this.nsxRepo.findAll());
            model.addAttribute("listMS",this.msRepo.findAll());
            model.addAttribute("listDSP",this.dspRepo.findAll());
            model.addAttribute("action","/chi-tiet-sp/update/" + ctsp.getId());
            return "chiTietSP/form";
        }
        ctsp.loadView(ctspVM);
        this.ctspRepo.save(ctsp);
        return "redirect:/chi-tiet-sp/index";
    }
}
