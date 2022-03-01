/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.utils;

import com.qlks.pojos.Booking;
import com.qlks.pojos.Order;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ACER
 */
public class Utils {

    public static int countBooking(Map<Integer, Booking> booking) {
        int sl = 0;
        if (booking != null) {
            for (Booking b : booking.values()) {
                sl += b.getSoLuong();
            }
        }

        return sl;
    }

    public static int countOrder(Map<Integer, Order> order) {
        int sl = 0;
        if (order != null) {
            for (Order b : order.values()) {
                sl += b.getSoDvu();
                
            }
        }

        return sl;
    }

    public static Map<String, String> sumAmount(Map<Integer, Booking> booking,
            Map<Integer, Order> order) {
        Long s = 0l;
        int q = 0;
        int d = 0;
        if (booking != null) {
            for (Booking b : booking.values()) {
                long soNgay = b.getCheckout().getTime()- b.getCheckin().getTime();
                long getDaysDiff = TimeUnit.MILLISECONDS.toDays(soNgay);
                q = b.getSoLuong();
                if(getDaysDiff <= 0)
                    s += b.getGia();
                else
                    s+= b.getGia() * getDaysDiff;
            }
        }
        if (order != null) {
            for (Order o : order.values()) {
                if(o.getSoDvu() >= 0){
                    d += o.getSoDvu();
                    s += o.getGiaDvu() * o.getSoDvu();
                }else{
                    s += o.getGiaDvu();
                }
            }
        }
        Map<String, String> kq = new HashMap<>();
        kq.put("counter", String.valueOf(q));
        kq.put("countDvu", String.valueOf(d));
        kq.put("amount", String.valueOf(s));
        return kq;
    }

    public static Map<String, String> countKH(Map<Integer, Booking> booking) {
        int sl = 0;
        Date in = new Date();
        Date out = new Date();
        if (booking != null) {
            for (Booking b : booking.values()) {
                sl = b.getSoKhach();
                in = b.getCheckin();
                out = b.getCheckout();
            }
        }
        Map<String, String> kq = new HashMap<>();
        kq.put("slk", String.valueOf(sl));
        kq.put("ngayIn", String.valueOf(in));
        kq.put("ngayOut", String.valueOf(out));
        
        return kq;
    }
}
