/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.controllers;

import com.qlks.pojos.NhanVien;
import com.qlks.service.NhanVienService;
import com.qlks.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private UserService userDetailsService;
    
    @RequestMapping("/admin/qlnv")
    public String qlNhanVien(Model model, 
            @RequestParam(value = "kw", required = false, defaultValue = "") String kw){
        model.addAttribute("nhanvien", this.nhanVienService.getNhanVien(kw));
        return "qlnv";
    }
    
    @GetMapping("/admin/qlnv/add")
    public String listNhanVien(Model model){
        model.addAttribute("nhanvien", new NhanVien());
        return "addnv";
    }
    
    @RequestMapping("/admin/qlnv/qtv")
    public String chiTietDat(Model model, @RequestParam(value="role", required = true, defaultValue = "ROLE_STAFF")String role){
        model.addAttribute("qtv", this.userDetailsService.getUsers(role));
        
        return "list-qtv";
    }
    
    @GetMapping("admin/qlnv/qtv/{qtvId}")
    public String deleteQTV(Model model, @PathVariable("qtvId") int id){
        model.addAttribute("qtv", this.userDetailsService.deleteById(id));
        model.addAttribute("mess", "");
        return "redirect:/admin/qlnv/qtv";
    }
        
    @PostMapping("/admin/qlnv/add")
    public String addNhanVien(Model model, @ModelAttribute(value="nhanvien") @Valid NhanVien nhanVien,
            BindingResult result){
        if(!result.hasErrors()){
            if(this.nhanVienService.addOrUpdate(nhanVien) == true)
                return "redirect:/admin/qlnv";
            else
                model.addAttribute("errMsg", "Lỗi hình ảnh !!!");
        }
            return "addnv";
    }
    
    @GetMapping("admin/qlnv/delete/{nvId}")
    public String deleteNhanVien(Model model, @PathVariable("nvId") int id){
        model.addAttribute("nhanvien", this.nhanVienService.deleteById(id));
        model.addAttribute("mess", "");
        return "redirect:/admin/qlnv";
    }
    
    @GetMapping("/admin/qlnv/update/{nvId}")
    public String updateNV(Model model, @PathVariable(value="nvId") int id){
        NhanVien nv = this.nhanVienService.getNhanVienById(id);
        model.addAttribute("nhanvien", nv);
        
        return "update-nv";
    }
    
    @PostMapping("/admin/qlnv/update/{nvId}")
    public String updateNhanVien(Model model, 
            @ModelAttribute("nhanvien") @Valid NhanVien nhanVien, BindingResult result){
        if(!result.hasErrors()){
            if(this.nhanVienService.addOrUpdate(nhanVien) == true)
                model.addAttribute("messUpdate", "");
            else
                model.addAttribute("messUpdate", "Error !!!");
            
        }else
            return "update-nv";
        
        return "redirect:/admin/qlnv";
    }

}
