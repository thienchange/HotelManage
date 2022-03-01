/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.controllers;

import com.qlks.pojos.Booking;
import com.qlks.pojos.Order;
import com.qlks.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ACER
 */
@Controller
public class BookingController {
    @GetMapping("/booking")
    public String booking(Model model, HttpSession session){
        Map<Integer, Booking> booking = (Map<Integer, Booking>) session.getAttribute("booking");
        Map<Integer, Order> order = (Map<Integer, Order>) session.getAttribute("order"); //thêm
       
        if(booking != null){
            model.addAttribute("room", booking.values());
        }
        else
            model.addAttribute("room", null);
        
      
        if(order != null)
            model.addAttribute("service", order.values());
        else
            model.addAttribute("service", null);
        
        model.addAttribute("bookingStats", Utils.sumAmount(booking, order)); 
        return "booking"; 
    }
}
