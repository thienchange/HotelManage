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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author ACER
 */
@Entity
@Table(name="khach_hang")
public class KhachHang implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 3, max = 50, message="{nhanvien.ten.lenErr}")
    private String ten;
    @Size(min = 8, max = 50, message="{nhanvien.mail.lenErr}")
    @Email(message="{Email.user.email}")
    private String email;
    @Column(name = "dia_chi")
    private String diaChi;
    @Size(min = 8, max = 12, message="{nhanvien.sdt.lenErr}")
    private String sdt;
    @OneToMany(mappedBy = "khachHang", fetch = FetchType.EAGER)
    private Set<User> user;

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
     * @return the user
     */
    public Set<User> getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Set<User> user) {
        this.user = user;
    }
    
}
