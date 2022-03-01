/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.controllers;

import com.qlks.pojos.DichVu;
import com.qlks.service.DichVuService;
import com.qlks.validator.WebAppValidator;
import java.io.IOException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
public class DichVuController {
    @Autowired
    private WebAppValidator dichVuValidator;
    @Autowired
    private DichVuService dichVuService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(dichVuValidator);
    }

    @RequestMapping("/dichvu")
    public String dichVuKS(Model model,
            @RequestParam(value = "kw", required = false, defaultValue = "") String kw) {
        model.addAttribute("dvu", this.dichVuService.getDichVu(kw));

        return "dichvu";
    }
    
    @RequestMapping("/admin/qldv")
    public String qlDichVu(Model model,
            @RequestParam(value = "kw", required = false, defaultValue = "") String kw) {
        model.addAttribute("dvu", this.dichVuService.getDichVu(kw));

        return "qldv";
    }

    @GetMapping("admin/qldv/delete/{dvId}")
    public String deleteDichVu(Model model, @PathVariable("dvId") int id) {
        model.addAttribute("dvu", this.dichVuService.deleteById(id));
        model.addAttribute("mess", "");
        return "redirect:/admin/qldv";
    }

    @GetMapping("/admin/qldv/add")
    public String list(Model model) {
        model.addAttribute("dvu", new DichVu());
        return "adddv";
    }

    @PostMapping("/admin/qldv/add")
    public String add(Model model, @ModelAttribute(value = "dvu") @Valid DichVu dichVu,
            BindingResult result) {
        try {
            if (!result.hasErrors()) {
                if (this.dichVuService.addOrUpdate(dichVu) == true) {
                    return "redirect:/dichvu";
                } else {
                    model.addAttribute("errMsg", "Lỗi hình ảnh !!!");
                }
            }
        } catch (Exception ex) {
            model.addAttribute("errMsg", "Lỗi hình ảnh !!! Vui lòng chọn một tệp ảnh");
        }
        return "adddv";
    }

    @GetMapping("/admin/qldv/update/{dvId}")
    public String updateDV(Model model, @PathVariable(value = "dvId") int id) {
        DichVu dv = this.dichVuService.getDichVuById(id);
        model.addAttribute("dvu", dv);

        return "update-dv";
    }

    @PostMapping("/admin/qldv/update/{dvId}")
    public String updateDichVu(Model model,
            @ModelAttribute("dvu") @Valid DichVu dichVu, BindingResult result) {
        try{
        if (!result.hasErrors()) {
            if (this.dichVuService.addOrUpdate(dichVu) == true) {
                model.addAttribute("messUpdate", "");
            }else {
                model.addAttribute("messUpdate", "Error !!!");
            }
        }else
            return "update-dv";
        } catch (Exception e) {
            return "update-dv";
        }
        
        return "redirect:/admin/qldv";
    }

}
