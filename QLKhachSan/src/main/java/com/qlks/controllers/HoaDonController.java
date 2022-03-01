/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.controllers;

import com.qlks.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
public class HoaDonController {
    @Autowired
    private HoaDonService hoaDonService;
    
    @RequestMapping("/admin/hoadon")
    public String qlHoaDon(Model model, @RequestParam(value="kw", required = false, defaultValue = "")String kw){
        model.addAttribute("hd", this.hoaDonService.getHoaDonDat(kw));
        
        return "hoadon";
    }
    
    @GetMapping("admin/hoadon/delete/{hdId}")
    public String deleteHoaDon(Model model, @PathVariable("hdId") int id){
        model.addAttribute("hd", this.hoaDonService.deleteById(id));
        model.addAttribute("mess", "");
        
        return "redirect:/admin/hoadon";
    }
    
    @RequestMapping("/admin/hoadon/ctdat")
    public String chiTietDat(Model model, @RequestParam(value="id", required = true)int id){
        model.addAttribute("hdkh", this.hoaDonService.getHoaDonDatById(id));
        model.addAttribute("ctp", this.hoaDonService.getChiTietPhong(id));
        model.addAttribute("ctdv", this.hoaDonService.getChiTietDichVu(id));
        
        return "chitiet-dat";
    }
}
