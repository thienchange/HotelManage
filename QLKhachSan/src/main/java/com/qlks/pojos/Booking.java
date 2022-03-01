/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.pojos;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author ACER
 */
public class Booking {
    private int phongId;
    private String soPhong;
    private String loaiPhong;
    private Long gia;
    private int soLuong;
    private int soKhach;
    private Date checkin;
    private Date checkout;

    /**
     * @return the phongId
     */
    public int getPhongId() {
        return phongId;
    }

    /**
     * @param phongId the phongId to set
     */
    public void setPhongId(int phongId) {
        this.phongId = phongId;
    }

    /**
     * @return the soPhong
     */
    public String getSoPhong() {
        return soPhong;
    }

    /**
     * @param soPhong the soPhong to set
     */
    public void setSoPhong(String soPhong) {
        this.soPhong = soPhong;
    }

    /**
     * @return the gia
     */
    public Long getGia() {
        return gia;
    }

    /**
     * @param gia the gia to set
     */
    public void setGia(Long gia) {
        this.gia = gia;
    }

    /**
     * @return the soLuong
     */
    public int getSoLuong() {
        return soLuong;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    /**
     * @return the loaiPhong
     */
    public String getLoaiPhong() {
        return loaiPhong;
    }

    /**
     * @param loaiPhong the loaiPhong to set
     */
    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    /**
     * @return the soKhach
     */
    public int getSoKhach() {
        return soKhach;
    }

    /**
     * @param soKhach the soKhach to set
     */
    public void setSoKhach(int soKhach) {
        this.soKhach = soKhach;
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
