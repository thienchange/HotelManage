/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.controllers;

import com.qlks.service.StatsService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
@RequestMapping("/admin/ThongKe")
public class AdminController {
    @Autowired
    private StatsService statsService;

    @GetMapping("/TKloaiphong")
    public String TKLoai(Model model) {
        model.addAttribute("loaiStats", this.statsService.loaiStats());

        return "TKloaiphong";
    }

    @GetMapping("/doanhthuphong")
    public String phongStats(Model model, @RequestParam(required = false) Map<String, String> params) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);

        Date fromDate = null, toDate = null;
        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = f.parse(from);
            }

            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = f.parse(to);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        model.addAttribute("phongStats", this.statsService.phongStats(kw, fromDate, toDate));

        return "DTphong";
    }
    
    @GetMapping("/doanhthuthang")
    public String phongMonthStats(Model model, @RequestParam(required = false) Map<String, String> params) throws ParseException{
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);

        Date fromDate = null, toDate = null;
        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = f.parse(from);
            }

            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = f.parse(to);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        model.addAttribute("phongMonthStats", this.statsService.phongMonthStats(kw, fromDate, toDate));
        
        return "DTthang";
    }
    
    @GetMapping("/tongdoanhthu")
    public String MonthStats(Model model, @RequestParam(required = false) Map<String, String> params){   
        model.addAttribute("dtThang", this.statsService.MonthStats());
        
        return "tongDT";
    }
    
    @GetMapping("/doanhthudichvu")
    public String dichVuStats(Model model, @RequestParam(required = false) Map<String, String> params) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);

        Date fromDate = null, toDate = null;
        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = f.parse(from);
            }

            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = f.parse(to);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        model.addAttribute("dvuStats", this.statsService.dichVuStats(kw, fromDate, toDate));

        return "DTdichvu";
    }
    
    @GetMapping("/dtdichvuthang")
    public String dichVuMonthStats(Model model, @RequestParam(required = false) Map<String, String> params) throws ParseException{
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);

        Date fromDate = null, toDate = null;
        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = f.parse(from);
            }

            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = f.parse(to);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        model.addAttribute("dvuMonthStats", this.statsService.dichVuMonthStats(kw, fromDate, toDate));
        
        return "DTDVthang";
    }
    
    @GetMapping("/thongkekhachhang")
    public String KhachHangStats(Model model, @RequestParam(required = false) Map<String, String> params) throws ParseException{
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);

        Date fromDate = null, toDate = null;
        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = f.parse(from);
            }

            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = f.parse(to);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        model.addAttribute("khStats", this.statsService.KhachHangStats(kw, fromDate, toDate));
        
        return "TKKH";
    }
    
    @GetMapping("/khachhangtungphong")
    public String KhachHangPhongStats(Model model, @RequestParam(required = false) Map<String, String> params) throws ParseException{
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);

        Date fromDate = null, toDate = null;
        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = f.parse(from);
            }

            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = f.parse(to);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        model.addAttribute("khpStats", this.statsService.KhachHangPhongStats(kw, fromDate, toDate));
        
        return "KHTP";
    }
}
