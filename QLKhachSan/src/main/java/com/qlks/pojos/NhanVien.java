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
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/**
 *
 * @author ACER
 */
@Entity
@Table(name="nhan_vien")
public class NhanVien implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 3, max = 50, message="{nhanvien.ten.lenErr}")
    private String ten;
    @Size(min = 8, max = 50, message="{nhanvien.mail.lenErr}")
    @Email(message="{Email.user.email}")
    private String email;
    @Column(name = "dia_chi")
    @Size(min = 3, max = 100, message="{nhanvien.dc.lenErr}")
    private String diaChi;
    @Size(min = 8, max = 12, message="{nhanvien.sdt.lenErr}")
    private String sdt;
    @ManyToOne
    @JoinColumn(name = "chuc_vu")
    private ChucVu chucVu;
    @ManyToOne
    @JoinColumn(name = "bo_phan")
    private BoPhan boPhan;

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
     * @return the ten
     */
    public String getTen() {
        return ten;
    }

    /**
     * @param ten the ten to set
     */
    public void setTen(String ten) {
        this.ten = ten;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    /**
     * @return the sdt
     */
    public String getSdt() {
        return sdt;
    }

    /**
     * @param sdt the sdt to set
     */
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }


    /**
     * @return the chucVu
     */
    public ChucVu getChucVu() {
        return chucVu;
    }

    /**
     * @param chucVu the chucVu to set
     */
    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    /**
     * @return the boPhan
     */
    public BoPhan getBoPhan() {
        return boPhan;
    }

    /**
     * @param boPhan the boPhan to set
     */
    public void setBoPhan(BoPhan boPhan) {
        this.boPhan = boPhan;
    }

    
}
