/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.pojos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "chi_tiet_dvu")
public class ChiTietDichVu implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="sl_dvu")
    private int soDvu;
    @Column(name="don_gia")
    private long gia;
    @ManyToOne()
    @JoinColumn(name = "dvu_id", insertable = false, updatable = false)
    private DichVu dichVu;
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private HoaDonDat hoaDonDat;
    

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
     * @return the soDvu
     */
    public int getSoDvu() {
        return soDvu;
    }

    /**
     * @param soDvu the soDvu to set
     */
    public void setSoDvu(int soDvu) {
        this.soDvu = soDvu;
    }


    /**
     * @return the gia
     */
    public long getGia() {
        return gia;
    }

    /**
     * @param gia the gia to set
     */
    public void setGia(long gia) {
        this.gia = gia;
    }
    
    /**
     * @return the dichVu
     */
    public DichVu getDichVu() {
        return dichVu;
    }

    /**
     * @param dichVu the dichVu to set
     */
    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
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

}
