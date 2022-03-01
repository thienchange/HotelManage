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
@Table(name = "bo_phan")
public class BoPhan implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ten;
    @Column(name= "cong_viec")
    private String congViec;
    @OneToMany(mappedBy = "boPhan", fetch = FetchType.EAGER)
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
     * @return the boPhan
     */
    public String getTen() {
        return ten;
    }

    /**
     * @param boPhan the boPhan to set
     */
    public void setTen(String ten) {
        this.ten = ten;
    }

    /**
     * @return the congViec
     */
    public String getCongViec() {
        return congViec;
    }

    /**
     * @param congViec the congViec to set
     */
    public void setCongViec(String congViec) {
        this.congViec = congViec;
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
