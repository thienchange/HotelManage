/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.service;

import com.qlks.pojos.Booking;
import com.qlks.pojos.Order;
import com.qlks.pojos.User;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface BookingService {
    boolean addReceipt(Map<Integer, Booking> booking, Map<Integer, Order> order, User creator);
    Booking getBookingById(int id);
}
