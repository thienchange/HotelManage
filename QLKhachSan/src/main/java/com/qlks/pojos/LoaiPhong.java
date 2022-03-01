/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author ACER
 */
@Entity
@Table(name="loai_phong")
public class LoaiPhong implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String loai;
//    @Min(value= 650000, message = "{loaiphong.price.minErr}")
//    @Max(value= 10000000, message = "{loaiphong.price.maxErr}")
    @Column(name = "muc_gia")
    private BigDecimal mucgia;
    @Column(name = "sl_khach")
    @Min(value= 1, message = "{loaiphong.sl.minErr}")
    @Max(value= 4, message = "{loaiphong.sl.maxErr}")
    private int sl;
    @OneToMany(mappedBy = "loaiPhong", fetch = FetchType.EAGER)
    private Set<Phong> phong;
    
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
     * @return the loai
     */
    public String getLoai() {
        return loai;
    }

    /**
     * @param loai the loai to set
     */
    public void setLoai(String loai) {
        this.loai = loai;
    }

    /**
     * @return the phong
     */
    public Set<Phong> getPhong() {
        return phong;
    }

    /**
     * @param phong the phong to set
     */
    public void setPhong(Set<Phong> phong) {
        this.phong = phong;
    }

    /**
     * @return the mucgia
     */
    public BigDecimal getMucgia() {
        return mucgia;
    }

    /**
     * @param mucgia the mucgia to set
     */
    public void setMucgia(BigDecimal mucgia) {
        this.mucgia = mucgia;
    }

    /**
     * @return the sl
     */
    public int getSl() {
        return sl;
    }

    /**
     * @param sl the sl to set
     */
    public void setSl(int sl) {
        this.sl = sl;
    }
}
