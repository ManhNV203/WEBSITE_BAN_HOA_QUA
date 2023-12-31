package com.example.demo.controller;

import com.example.demo.domainModel.chucVu;
import com.example.demo.repository.chucVuRepository;
import com.example.demo.viewModel.chucVuVM;
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

@RestController
@CrossOrigin("*")
@RequestMapping("chuc-vu")
public class chucVuController {

    @Autowired
    private chucVuRepository cvRepo;

    @Autowired
    @Qualifier("cv_vm")
    private chucVuVM cvVm;
    @GetMapping("index")
    public ResponseEntity<List<chucVuVM>> getAll(){
        List<chucVuVM> listch = new ArrayList<>();
        for (chucVu ch: this.cvRepo.findAll()) {
            chucVuVM chVM = new chucVuVM();
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
        chucVuVM cvVm = new chucVuVM();
        model.addAttribute("data",cvVm);
        model.addAttribute("action","/chuc-vu/store");
        return "chucVu/form";
    }
    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("data") chucVuVM cvVm,
            BindingResult result
    ){
        if (result.hasErrors()){
            return "chucVu/form";
        }
        chucVu cv = new chucVu();
        cv.loadCVView(cvVm);
        this.cvRepo.save(cv);
        return "redirect:/chuc-vu/index";
    }
    @GetMapping("delete/{id}")
    public String delete(
            @PathVariable("id") chucVu cv
    ){
        this.cvRepo.delete(cv);
        return "redirect:/chuc-vu/index";
    }
    @GetMapping("edit/{id}")
    public String edit(
            Model model,
            @PathVariable("id") chucVu cv
    ){
        cvVm.loadDomain(cv);
        model.addAttribute("data",cvVm);
        model.addAttribute("action","/chuc-vu/update/"+ cv.getId());
        return "chucVu/form";
    }
    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") chucVu cv,
            @Valid @ModelAttribute("data")chucVuVM cvVm,
            Model model,
            BindingResult result
    ){
        if (result.hasErrors()){
            model.addAttribute("data", cvVm);
            model.addAttribute("action","/chuc-vu/update/" + cv.getId());
            return "chucVu/form";
        }
        cv.loadCVView(cvVm);
        this.cvRepo.save(cv);
        return "redirect:/chuc-vu/index";
    }

}
