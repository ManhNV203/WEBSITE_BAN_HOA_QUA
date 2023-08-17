package com.example.demo.controller;

import com.example.demo.domainModel.cuaHang;
import com.example.demo.repository.cuaHangRepository;
import com.example.demo.viewModel.cuaHangViewModel;
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
@RequestMapping("cua-hang")
public class cuaHangController {
    @Autowired
    private cuaHangRepository chRepo;

    @Autowired
    @Qualifier("ch_vm")
    private cuaHangViewModel vm;

    @GetMapping("index")
    public ResponseEntity<List<cuaHangViewModel>> getAll(){
        List<cuaHangViewModel> listch = new ArrayList<>();
        for (cuaHang ch: this.chRepo.findAll()) {
            cuaHangViewModel chVM = new cuaHangViewModel();
            chVM.loadDomainModel(ch);
            listch.add(chVM);
        }
        System.out.println(listch);
        return new ResponseEntity<>(listch,HttpStatus.OK);
    }

    @GetMapping("create")
    public String create(Model model) {
        cuaHangViewModel vm = new cuaHangViewModel();
        model.addAttribute("data", vm);
        return "/cuaHang/create";
    }

    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("data") cuaHangViewModel vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/cuaHang/create";
        }
        cuaHang ch = new cuaHang();
        ch.loadViewModel(vm);
        this.chRepo.save(ch);
        return "redirect:/cua-hang/index";
    }
    @GetMapping("edit/{id}")
    public String edit(
            Model model,
            @PathVariable("id") cuaHang ch
    ){
        vm.loadDomainModel(ch);
        model.addAttribute("data", vm);
        model.addAttribute("action", "/cua-hang/update/" + ch.getId());
        return "/cuaHang/edit";
    }
    @GetMapping("delete/{id}")
    public String delete(
            @PathVariable("id") cuaHang ch
    ){
      this.chRepo.delete(ch);
        return "redirect:/cua-hang/index";
    }
    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") cuaHang ch,
            Model model,
            @Valid @ModelAttribute("data") cuaHangViewModel vm,
            BindingResult result
    ){
        if (result.hasErrors()){
            model.addAttribute("data",vm);
            model.addAttribute("action", "/cua-hang/update/"+ch.getId());
            return "cuaHang/edit";
        }

        ch.loadViewModel(vm);
        this.chRepo.save(ch);
        return "redirect:/cua-hang/index";
    }
}

