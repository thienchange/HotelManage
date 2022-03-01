/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.pojos;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "chuc_vu")
public class ChucVu implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ten;
    @Column(name= "phan_cong")
    private String phanCong;
    @OneToMany(mappedBy = "chucVu", fetch = FetchType.EAGER)
    private Set<NhanVien> nhanVien;
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
     * @return the chucVu
     */
    public String getTen() {
        return ten;
    }

    /**
     * @param chucVu the chucVu to set
     */
    public void setTen(String ten) {
        this.ten = ten;
    }

    /**
     * @return the phanCong
     */
    public String getPhanCong() {
        return phanCong;
    }

    /**
     * @param phanCong the phanCong to set
     */
    public void setPhanCong(String phanCong) {
        this.phanCong = phanCong;
    }

    /**
     * @return the nhanVien
     */
    public Set<NhanVien> getNhanVien() {
        return nhanVien;
    }

    /**
     * @param nhanVien the nhanVien to set
     */
    public void setNhanVien(Set<NhanVien> nhanVien) {
        this.nhanVien = nhanVien;
    }
    
}
