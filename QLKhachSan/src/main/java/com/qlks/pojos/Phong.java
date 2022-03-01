/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "phong")
public class Phong implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 4, max = 10, message="{phong.soPhong.lenErr}")
    @Column(name = "so_phong")
    private String soPhong;
    @Min(value= 650000, message = "{phong.gia.minErr}")
    @Max(value= 10000000, message = "{phong.gia.maxErr}")
    @NotNull(message = "{phong.gia.nullErr}")
    private BigDecimal gia;
    @Column(name = "hinh_anh")
    private String hinhanh;
    @Transient
    @Column(name = "trang_thai")
    private boolean trangThai;
    @NotNull(message = "{phong.mota.nullErr}")
    @Column(name = "mo_ta")
    private String mota;
    @ManyToOne()
    @JoinColumn(name = "loai_id")
    @NotNull(message = "{phong.loaiphong.nullErr}")
    private LoaiPhong loaiPhong;
    @OneToMany(mappedBy = "phong", fetch = FetchType.EAGER)
    private Set<ChiTietPhong> chiTietPhong;
    @Transient
    private MultipartFile file;
    
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
     * @return the loaiPhong
     */
    public LoaiPhong getLoaiPhong() {
        return loaiPhong;
    }

    /**
     * @param loaiPhong the loaiPhong to set
     */
    public void setLoaiPhong(LoaiPhong loaiPhong) {
        this.loaiPhong = loaiPhong;
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

    /**
     * @return the gia
     */
    public BigDecimal getGia() {
        return gia;
    }

    /**
     * @param gia the gia to set
     */
    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    /**
     * @return the hinhanh
     */
    public String getHinhanh() {
        return hinhanh;
    }

    /**
     * @param hinhanh the hinhanh to set
     */
    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    /**
     * @return the mota
     */
    public String getMota() {
        return mota;
    }

    /**
     * @param mota the mota to set
     */
    public void setMota(String mota) {
        this.mota = mota;
    }

    /**
     * @return the chiTietPhong
     */
    public Set<ChiTietPhong> getChiTietPhong() {
        return chiTietPhong;
    }

    /**
     * @param chiTietPhong the chiTietPhong to set
     */
    public void setChiTietPhong(Set<ChiTietPhong> chiTietPhong) {
        this.chiTietPhong = chiTietPhong;
    }

    /**
     * @return the trangThai
     */
    public boolean isTrangThai() {
        return trangThai;
    }

    /**
     * @param trangThai the trangThai to set
     */
    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}
