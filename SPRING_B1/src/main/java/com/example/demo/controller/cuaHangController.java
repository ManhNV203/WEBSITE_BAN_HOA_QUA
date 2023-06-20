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

import java.util.List;


@Controller
@RequestMapping("cua-hang")
public class cuaHangController {
    @Autowired
    private cuaHangRepository chRepo;

    @Autowired
    @Qualifier("ch_vm")
    private cuaHangViewModel vm;

    @GetMapping("index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 4);
        Page<cuaHang> cuaHangPage = chRepo.findAll(pageable);
        model.addAttribute("dsCh", cuaHangPage);
        return "/cuaHang/index";
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

