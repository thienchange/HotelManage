/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.controllers;

import com.qlks.pojos.Booking;
import com.qlks.pojos.Order;
import com.qlks.pojos.User;
import com.qlks.service.BookingService;
import com.qlks.utils.Utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
public class ApiBookController {
    @Autowired
    private BookingService bookingService;

    @PostMapping(path = "/api/room", produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public int addtoRoom(@RequestBody Booking params, HttpSession session) {
        Map<Integer, Booking> booking = (Map<Integer, Booking>) session.getAttribute("booking");

        if (booking == null) {
            booking = new HashMap<>();
        }

        int phongId = params.getPhongId();
        if (booking != null) {
            if (booking.containsKey(phongId) == true) { //Phòng đã đặt trước đó
                Booking b = booking.get(phongId);
                b.setSoLuong(b.getSoLuong());
                b.setCheckin(b.getCheckin());
                b.setCheckout(b.getCheckout());
            } else {
                booking.put(phongId, params);
            }
        }

        session.setAttribute("booking", booking);

        return Utils.countBooking(booking);
    }

    @PostMapping(path = "/api/service", produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public int addtoService(@RequestBody Order params, HttpSession session) {
        Map<Integer, Order> order = (Map<Integer, Order>) session.getAttribute("order");
        if (order == null) {
            order = new HashMap<>();
        }
        int dvuId = params.getDichVuId();
        if (order.containsKey(params.getDichVuId())) {
            Order o = order.get(dvuId);
            o.setSoDvu(o.getSoDvu() + 1);
        } else {
            order.put(dvuId, params);
        }
        session.setAttribute("order", order);
        return Utils.countOrder(order);
    }

    @PutMapping("api/room")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String, String>> updateBooking(@RequestBody Booking params, HttpSession session) {
        Map<Integer, Booking> booking = (Map<Integer, Booking>) session.getAttribute("booking");
        if (booking == null) {
            booking = new HashMap<>();
        }

        int phongId = params.getPhongId();
        if (booking.containsKey(phongId) == true) { //Phòng đã đặt trước đó
            Booking b = booking.get(phongId);
            b.setSoKhach(params.getSoKhach());
            b.setCheckin(params.getCheckin());
            b.setCheckout(params.getCheckout());
        }
        session.setAttribute("booking", booking);
        
        return new ResponseEntity<>(Utils.countKH(booking), HttpStatus.OK);
    }

    @PutMapping("api/service")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String, String>> updateOrder(@RequestBody Order o, HttpSession session) {
        Map<Integer, Order> order = (Map<Integer, Order>) session.getAttribute("order");
        if (order == null) {
            order = new HashMap<>();
        }

        int dvuId = o.getDichVuId();
        if (order.containsKey(dvuId) == true) {
            Order b = order.get(dvuId);
            b.setSoDvu(o.getSoDvu());
        }
        session.setAttribute("order", order);
        
        return new ResponseEntity<>(Utils.sumAmount(null, order), HttpStatus.OK);
    }

    @DeleteMapping("/api/room/{phongId}")
    public ResponseEntity<Map<String, String>> cancelBooking(@PathVariable(value = "phongId") int phongId, HttpSession session) {
        Map<Integer, Booking> booking = (Map<Integer, Booking>) session.getAttribute("booking");
        if (booking != null && booking.containsKey(phongId)) {
            booking.remove(phongId);
            session.setAttribute("booking", booking);
        }
        return new ResponseEntity<>(Utils.sumAmount(booking, null), HttpStatus.OK);
    }

    @DeleteMapping("/api/service/{dvuId}")
    public int deleteService(@PathVariable(value = "dvuId") int dvuId, HttpSession session) {
        Map<Integer, Order> order = (Map<Integer, Order>) session.getAttribute("order");
        if (order != null && order.containsKey(dvuId)) {
            order.remove(dvuId);
            session.setAttribute("order", order);
        }
        return Utils.countOrder(order);
    }

    @PostMapping("/api/pay")
    public HttpStatus pay(Model model, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user != null)
            try {
            if (this.bookingService.addReceipt((Map<Integer, Booking>) session.getAttribute("booking"),
                    (Map<Integer, Order>) session.getAttribute("order"), user) == true) {
                session.removeAttribute("booking");
                session.removeAttribute("order");
                return HttpStatus.OK;
            }
        } catch (Exception e) {
        }
        
        return HttpStatus.BAD_REQUEST;
    }
}
