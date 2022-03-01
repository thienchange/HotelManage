/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.service.impl;

import com.qlks.pojos.Booking;
import com.qlks.pojos.Order;
import com.qlks.pojos.User;
import com.qlks.repository.BookingRepository;
import com.qlks.service.BookingService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    private BookingRepository bookingRepository;
    
    @Override
    public boolean addReceipt(Map<Integer, Booking> booking, Map<Integer, Order> order, User creator) {
        if(booking != null)
            return this.bookingRepository.addReceipt(booking, order, creator);
        return  false;
    }

    @Override
    public Booking getBookingById(int id) {
        return this.bookingRepository.getBookingById(id);
    }
    
}
