/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.controllers;

import com.qlks.pojos.Booking;
import com.qlks.pojos.Order;
import com.qlks.service.BoPhanService;
import com.qlks.service.ChucVuService;
import com.qlks.service.LoaiDichVuService;
import com.qlks.service.LoaiPhongService;
import com.qlks.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ACER
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private LoaiPhongService loaiPhongService;
    @Autowired
    private LoaiDichVuService loaiDichVuService;
    @Autowired
    private BoPhanService boPhanService;
    @Autowired
    private ChucVuService chucVuService;

    @ModelAttribute
    public void commonAttr(Model model, HttpSession session) {
        model.addAttribute("loaidvu", this.loaiDichVuService.getLoaiDichVu());
        model.addAttribute("bophan", this.boPhanService.getBoPhan());
        model.addAttribute("chucvu", this.chucVuService.getChucVu());
        model.addAttribute("lphong", this.loaiPhongService.getLoaiPhong());
        model.addAttribute("bookingCounter", Utils.countBooking((Map<Integer, Booking>) session.getAttribute("booking")));
        model.addAttribute("orderCounter", Utils.countOrder((Map<Integer, Order>) session.getAttribute("order")));
//        model.addAttribute("currentUser", session.getAttribute("currentUser")); //lỗi vadi addDv
    }

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
    
}
