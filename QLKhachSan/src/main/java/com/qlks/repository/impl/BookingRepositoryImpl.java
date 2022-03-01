/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.repository.impl;

import com.qlks.pojos.Booking;
import com.qlks.pojos.ChiTietPhong;
import com.qlks.pojos.ChiTietDichVu;
import com.qlks.pojos.HoaDonDat;
import com.qlks.pojos.Order;
import com.qlks.pojos.User;
import com.qlks.repository.BookingRepository;
import com.qlks.repository.DichVuRepository;
import com.qlks.repository.PhongRepository;
import com.qlks.repository.UserRepository;
import com.qlks.utils.Utils;
import java.util.Date;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Repository
public class BookingRepositoryImpl implements BookingRepository {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PhongRepository phongRepository;
    @Autowired
    private DichVuRepository dichVuRepository;
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED) // bật giao tác lưu mối quan hệ cha và con
    public boolean addReceipt(Map<Integer, Booking> booking, Map<Integer, Order> order, User creator) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();

            HoaDonDat dat = new HoaDonDat();
            dat.setUser(creator);
            dat.setNgayDat(new Date());

            Map<String, String> stats = Utils.sumAmount(booking, order);
            dat.setTongTien(Long.parseLong(stats.get("amount")));

            session.save(dat);
            
            for (Booking b : booking.values()) {
                ChiTietPhong c = new ChiTietPhong();
                c.setHoaDonDat(dat);
                c.setPhong(this.phongRepository.getPhongById(b.getPhongId()));
                c.setDonGia(b.getGia());
                c.setSoLuongKhach(b.getSoKhach());
                c.setCheckin(b.getCheckin());
                c.setCheckout(b.getCheckout());
                
                session.save(c);
                
            }
            if(order != null)
                    for(Order o : order.values()){
                        ChiTietDichVu d = new ChiTietDichVu();
                        d.setSoDvu(o.getSoDvu());
                        d.setGia(o.getGiaDvu());
                        d.setDichVu(this.dichVuRepository.getDichVuById(o.getDichVuId()));
                        d.setHoaDonDat(dat);
                        
                        session.save(d);
                    }
            return  true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public Booking getBookingById(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        return session.get(Booking.class, id);
    }

}
