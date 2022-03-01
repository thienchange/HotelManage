/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.pojos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ACER
 */
@Entity
@Table(name="hoa_don_dat")
public class HoaDonDat implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="tong_tien")
    private Long tongTien;
    @Column(name="ngay_dat")
    private Date ngayDat;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoaDonDat")
    private Collection<ChiTietPhong> chiTietPhong;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoaDonDat")
    private Collection<ChiTietDichVu> chiTietDichVu;
    
    public HoaDonDat(){
        ngayDat = new Date();
    }
    
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
     * @return the tongTien
     */
    public Long getTongTien() {
        return tongTien;
    }

    /**
     * @param tongTien the tongTien to set
     */
    public void setTongTien(Long tongTien) {
        this.tongTien = tongTien;
    }

    /**
     * @return the ngayDat
     */
    public Date getNgayDat() {
        return ngayDat;
    }

    /**
     * @param ngayDat the ngayDat to set
     */
    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the chiTietPhong
     */
    public Collection<ChiTietPhong> getChiTietPhong() {
        return chiTietPhong;
    }

    /**
     * @param chiTietPhong the chiTietPhong to set
     */
    public void setChiTietPhong(Collection<ChiTietPhong> chiTietPhong) {
        this.chiTietPhong = chiTietPhong;
    }

    /**
     * @return the chiTietDichVu
     */
    public Collection<ChiTietDichVu> getChiTietDichVu() {
        return chiTietDichVu;
    }

    /**
     * @param chiTietDichVu the chiTietDichVu to set
     */
    public void setChiTietDichVu(Collection<ChiTietDichVu> chiTietDichVu) {
        this.chiTietDichVu = chiTietDichVu;
    }
    
}
