package com.example.demo.controller;

import com.example.demo.domainModel.chucVu;
import com.example.demo.domainModel.cuaHang;
import com.example.demo.domainModel.nhanVien;
import com.example.demo.repository.chucVuRepository;
import com.example.demo.repository.cuaHangRepository;
import com.example.demo.repository.nhanVienRepository;
import com.example.demo.viewModel.chucVuVM;
import com.example.demo.viewModel.cuaHangViewModel;
import com.example.demo.viewModel.nhanVienDto;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("nhan-vien")
public class nhanVienController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private nhanVienRepository nvRepo;
    @Autowired
    private cuaHangRepository chRepo;
    @Autowired
    private chucVuRepository cvRepo;
    @Autowired
    @Qualifier("nv_vm")
    private nhanVienDto nvVm;

    @Autowired
    @Qualifier("cv_vm")
    private chucVuVM cvVm;
    @Autowired
    @Qualifier("ch_vm")
    private cuaHangViewModel chVM;
    @GetMapping("index")
    public ResponseEntity<List<nhanVienDto>> getAll(){
        List<nhanVienDto> listnv = new ArrayList<>();
        List<chucVu> listcv = new ArrayList<>();
        List<cuaHang> listch = new ArrayList<>();
        for (nhanVien nv: this.nvRepo.findAll()){
          nhanVienDto nvDto = new nhanVienDto();
          nvDto.setId(nv.getId());
          nvDto.setMa(nv.getMa());
          nvDto.setTen(nv.getTen());
          nvDto.setTen_dem(nv.getTen_dem());
          nvDto.setHo(nv.getHo());
          nvDto.setNgay_sinh(nv.getNgay_sinh());
          nvDto.setGioi_tinh(nv.getGioi_tinh());
          nvDto.setDia_chi(nv.getDia_chi());
          nvDto.setSdt(nv.getSdt());
          nvDto.setChucvuid(nv.getCv().getTen());
          nvDto.setCuahangid(nv.getCh().getTen());
          nvDto.setMat_khau(nv.getMat_khau());
          nvDto.setTrang_thai(String.valueOf(nv.getTrang_thai()));
          listnv.add(nvDto);
        }
        System.out.println(listnv);
        return new ResponseEntity<>(listnv,HttpStatus.OK);
    }

    @GetMapping("create")
    public String create(
            Model model
    ) {
        nhanVienDto nv = new nhanVienDto();
        model.addAttribute("data", nv);
        model.addAttribute("datach", chRepo.findAll());
        model.addAttribute("datacv", cvRepo.findAll());
        return "/nhanVien/create";
    }

    @DeleteMapping("/delete/{id}")
    public void delete(
            @PathVariable(value = "id") nhanVien nv
    ) {
        this.nvRepo.delete(nv);
    }

    @PostMapping("store")
    public ResponseEntity<nhanVien> addnhanVien(
           @Valid @RequestBody nhanVienDto nvDto
    ){
        nhanVien nvDM = new nhanVien();
        nvDM.setMa(nvDto.getMa());
        nvDM.setTen(nvDto.getTen());
        nvDM.setTen_dem(nvDto.getTen_dem());
        nvDM.setHo(nvDto.getHo());
        nvDM.setNgay_sinh(nvDto.getNgay_sinh());
        nvDM.setGioi_tinh(nvDto.getGioi_tinh());
        nvDM.setDia_chi(nvDto.getDia_chi());
        nvDM.setSdt(nvDto.getSdt());
        nvDM.setMat_khau(nvDto.getMat_khau());
        nvDM.setTrang_thai(Integer.valueOf(nvDto.getTrang_thai()));
        cuaHang ch = null;
        ch = this.chRepo.findById(UUID.fromString(nvDto.getCuahangid())).orElseThrow();
        nvDM.setCh(ch);
        chucVu cv = null;
        cv = this.cvRepo.findById(UUID.fromString(nvDto.getChucvuid())).orElseThrow();
        nvDM.setCv(cv);
        return new ResponseEntity<>(this.nvRepo.save(nvDM),HttpStatus.CREATED);
    }

    @GetMapping("edit/{id}")
    public ResponseEntity<nhanVienDto> edit(
            Model model,
            @PathVariable("id") nhanVien nv
    ) {
        nhanVienDto nvDto = new nhanVienDto();
        nvDto.setId(nv.getId());
        nvDto.setMa(nv.getMa());
        nvDto.setTen(nv.getTen());
        nvDto.setTen_dem(nv.getTen_dem());
        nvDto.setHo(nv.getHo());
        nvDto.setNgay_sinh(nv.getNgay_sinh());
        nvDto.setGioi_tinh(nv.getGioi_tinh());
        nvDto.setDia_chi(nv.getDia_chi());
        nvDto.setSdt(nv.getSdt());
        nvDto.setTrang_thai(String.valueOf(nv.getTrang_thai()));
        nvDto.setMat_khau(nv.getMat_khau());
        nvDto.setCuahangid(String.valueOf(nv.getCh().getId()));
        nvDto.setChucvuid(String.valueOf(nv.getCv().getId()));
        return new ResponseEntity<>(nvDto,HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<nhanVien> update(
            @PathVariable("id") nhanVien nvDM,
            Model model,
            @Valid @RequestBody nhanVienDto nvDto,
            BindingResult result
    ){
        nvDM.setMa(nvDto.getMa());
        nvDM.setTen(nvDto.getTen());
        nvDM.setTen_dem(nvDto.getTen_dem());
        nvDM.setHo(nvDto.getHo());
        nvDM.setNgay_sinh(nvDto.getNgay_sinh());
        nvDM.setGioi_tinh(nvDto.getGioi_tinh());
        nvDM.setDia_chi(nvDto.getDia_chi());
        nvDM.setSdt(nvDto.getSdt());
        nvDM.setMat_khau(nvDto.getMat_khau());
        nvDM.setTrang_thai(Integer.valueOf(nvDto.getTrang_thai()));
        cuaHang ch = null;
        ch = this.chRepo.findById(UUID.fromString(nvDto.getCuahangid())).orElseThrow();
        nvDM.setCh(ch);
        chucVu cv = null;
        cv = this.cvRepo.findById(UUID.fromString(nvDto.getChucvuid())).orElseThrow();
        nvDM.setCv(cv);
        return new ResponseEntity<>(this.nvRepo.save(nvDM),HttpStatus.OK);
    }
}
