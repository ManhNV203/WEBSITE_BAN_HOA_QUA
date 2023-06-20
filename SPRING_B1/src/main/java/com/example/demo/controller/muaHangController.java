package com.example.demo.controller;

import com.example.demo.domainModel.chiTietSP;
import com.example.demo.domainModel.gioHang;
import com.example.demo.domainModel.gioHangChiTiet;
import com.example.demo.domainModel.gioHangChiTietId;
import com.example.demo.repository.chiTietSanPhamRepository;
import com.example.demo.repository.gioHangChiTietRepository;
import com.example.demo.repository.gioHangRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("mua-hang")
public class muaHangController {

    @Autowired
    private chiTietSanPhamRepository ctspRepo;

    @Autowired
    private gioHangRepository ghRepo;

    @Autowired
    private gioHangChiTietRepository ghctRepo;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("product")
    public String product(Model model){
        model.addAttribute("listProcduct",this.ctspRepo.findAll());
        return "product/index";
    }

    @GetMapping("gio-hang-ct/view")
    public String viewGHCT(
            Model model
    ){
        model.addAttribute("listCTSP",this.ghctRepo.findAll());
        return "gioHangCT/index";
    }

    @GetMapping("product/add")
    public String addToCart(HttpServletRequest request){
        int sl =1;
        String id = request.getParameter("id");
        chiTietSP chiTietSP = ctspRepo.findById(UUID.fromString(id)).orElse(null);
        httpSession  = request.getSession();
        if (httpSession.getAttribute("ghsession") == null) {
            gioHang gioHang = new gioHang();
            List<gioHangChiTiet> lstGHCT = new ArrayList<>();
            gioHangChiTiet gioHangChiTiet = new gioHangChiTiet();
            gioHangChiTietId ghctID = new gioHangChiTietId();
            ghctID.setCtspgh(chiTietSP);
            ghctID.setGh(gioHang);
            gioHangChiTiet.setId(ghctID);
            gioHangChiTiet.setDon_gia(chiTietSP.getGia_ban());
            gioHangChiTiet.setSo_luong(sl);
            lstGHCT.add(gioHangChiTiet);
            gioHang.setListghct(lstGHCT);
            httpSession.setAttribute("ghsession", gioHang);
            httpSession.setAttribute("slgh", gioHang.getListghct().size());
            this.ghctRepo.save(gioHangChiTiet);
        } else {
            gioHang gioHang = (gioHang) httpSession.getAttribute("ghsession");
            Boolean kq = false;
            for (gioHangChiTiet ghct : gioHang.getListghct()) {
                if (ghct.getId().getCtspgh().getSp().getId().equals(UUID.fromString(id))) {
                    ghct.setSo_luong(ghct.getSo_luong() + sl);
                    kq = true;
                }
            }
            if (kq == false) {
                List<gioHangChiTiet> lstGHCT = new ArrayList<>();
                gioHangChiTiet gioHangChiTiet = new gioHangChiTiet();
                gioHangChiTietId ghctID = new gioHangChiTietId();
                ghctID.setCtspgh(chiTietSP);
                ghctID.setGh(gioHang);
                gioHangChiTiet.setId(ghctID);
                gioHangChiTiet.setDon_gia(chiTietSP.getGia_ban());
                gioHangChiTiet.setSo_luong(sl);
                lstGHCT.add(gioHangChiTiet);
                gioHang.setListghct(lstGHCT);
            }
            httpSession.setAttribute("ghsession", gioHang);
            httpSession.setAttribute("slgh", gioHang.getListghct().size());
        }
        return "redirect:/mua-hang/product";

    }
}
