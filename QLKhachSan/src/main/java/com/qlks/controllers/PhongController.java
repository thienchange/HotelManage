/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.controllers;

import com.qlks.pojos.Phong;
import com.qlks.service.PhongService;
import java.util.Map;
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
import com.qlks.service.HoaDonService;

/**
 *
 * @author ACER
 */
@Controller
public class PhongController {
    @Autowired
    private PhongService phongService;

    @RequestMapping("/phong")
    public String phongKS(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        String kw = params.get("kw");
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("phongks", this.phongService.getPhong(kw, page));
        model.addAttribute("counter", this.phongService.countPhong());

        return "phong";
    }

    @GetMapping("/phong/{phongId}")
    public String detail(Model model, @PathVariable(value = "phongId") int phongId) {
        model.addAttribute("phongs", this.phongService.getPhongById(phongId));
        return "chitiet-phong";
    }
    
    @GetMapping("/admin/qlp/{phongId}")
    public String updateP(Model model, @PathVariable(value = "phongId") int id) {
        Phong p = this.phongService.getPhongById(id);
        model.addAttribute("phongks", p);

        return "qlp";
    }

    @PostMapping("/admin/qlp/{phongId}")
    public String updatePhong(Model model, 
            @ModelAttribute(value = "phongks") @Valid Phong phong, BindingResult result) {
        try {
            if (!result.hasErrors()) {
                if (this.phongService.addOrUpdate(phong) == true) {
                    model.addAttribute("messUpdate", "");
                } else {
                    model.addAttribute("messUpdate", "Error !!!");
                }
            } else {
                return "qlp";
            }
        } catch (Exception ex) {
            System.err.println("== UPDATE PHONG ERROR" + ex.getMessage());
            ex.printStackTrace();
            return "qlp";
        }
        return "redirect:/phong";
    }

}
