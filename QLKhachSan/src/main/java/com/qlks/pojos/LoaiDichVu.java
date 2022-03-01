/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.pojos;

import java.util.Set;
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
@Table(name="loai_dvu")
public class LoaiDichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String loai;
    @OneToMany(mappedBy = "loaiDichVu", fetch = FetchType.EAGER)//fetch mặc định của 1toN là LAZY, ngược lại vs nTo1
    private Set<DichVu> dichVu;
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
     * @return the dichVu
     */
    public Set<DichVu> getDichVu() {
        return dichVu;
    }

    /**
     * @param dichVu the dichVu to set
     */
    public void setDichVu(Set<DichVu> dichVu) {
        this.dichVu = dichVu;
    }
}
