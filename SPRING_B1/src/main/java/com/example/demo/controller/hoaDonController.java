package com.example.demo.controller;

import com.example.demo.service.hoaDonService;
import com.example.demo.viewModel.hoaDonVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("hoa-don")
public class hoaDonController {
    @Autowired
    private hoaDonService hdSer;

    @GetMapping("index")
    public ResponseEntity<List<hoaDonVM>> getAll(){
        return new ResponseEntity<>(hdSer.getAllHD(), HttpStatus.OK);
    }
}
