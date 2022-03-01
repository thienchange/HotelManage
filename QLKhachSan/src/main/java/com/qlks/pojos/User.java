 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.pojos;

import java.io.Serializable;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Cascade;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "user")
public class User implements Serializable{
    public static final String ADMIN = "ROLE_ADMIN";
    public static final String USER = "ROLE_USER";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 3, max = 10, message="{user.tk.lenErr}")
    private String user;
    @Size(min = 3, message="{user.mk.lenErr}")
    private String pass;
    @Column(name="quyen_user")
    private String quyenUser;
    private String avatar;
    @Transient
    private MultipartFile file;
    @Transient
    private String confirmPassword;
    @ManyToOne()
    @JoinColumn(name = "kh_id")
    @Cascade(value= {org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE})
    private KhachHang khachHang;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<HoaDonDat> datPhong;
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
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the quyenUser
     */
    public String getQuyenUser() {
        return quyenUser;
    }

    /**
     * @param quyenUser the quyenUser to set
     */
    public void setQuyenUser(String quyenUser) {
        this.quyenUser = quyenUser;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @return the khachHang
     */
    public KhachHang getKhachHang() {
        return khachHang;
    }

    /**
     * @param khachHang the khachHang to set
     */
    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    /**
     * @return the datPhong
     */
    public Set<HoaDonDat> getDatPhong() {
        return datPhong;
    }

    /**
     * @param datPhong the datPhong to set
     */
    public void setDatPhong(Set<HoaDonDat> datPhong) {
        this.datPhong = datPhong;
    }

    /**
     * @return the avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }


}
