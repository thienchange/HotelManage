/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.pojos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "chi_tiet_phong")
public class ChiTietPhong implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="sl_khach")
    private int soLuongKhach;
    @Column(name="don_gia")
    private long donGia;
    private Date checkin;
    private Date checkout;
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private HoaDonDat hoaDonDat;
    @ManyToOne()
    @JoinColumn(name = "phong_id")
    private Phong phong;
//    @OneToMany(mappedBy = "chiTietPhong", fetch = FetchType.EAGER)
//    private Set<ChiTietDichVu> chiTietDichVu;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the soLuongKhach
     */
    public int getSoLuongKhach() {
        return soLuongKhach;
    }

    /**
     * @param soLuongKhach the soLuongKhach to set
     */
    public void setSoLuongKhach(int soLuongKhach) {
        this.soLuongKhach = soLuongKhach;
    }

    /**
     * @return the donGia
     */
    public long getDonGia() {
        return donGia;
    }

    /**
     * @param donGia the donGia to set
     */
    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }

    /**
     * @return the phong
     */
    public Phong getPhong() {
        return phong;
    }

    /**
     * @param phong the phong to set
     */
    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    /**
     * @return the hoaDonDat
     */
    public HoaDonDat getHoaDonDat() {
        return hoaDonDat;
    }

    /**
     * @param hoaDonDat the hoaDonDat to set
     */
    public void setHoaDonDat(HoaDonDat hoaDonDat) {
        this.hoaDonDat = hoaDonDat;
    }

    /**
     * @return the checkin
     */
    public Date getCheckin() {
        return checkin;
    }

    /**
     * @param checkin the checkin to set
     */
    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    /**
     * @return the checkout
     */
    public Date getCheckout() {
        return checkout;
    }

    /**
     * @param checkout the checkout to set
     */
    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }
    
}
