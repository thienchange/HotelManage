/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.pojos;

import java.math.BigDecimal;
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
@Table(name ="dich_vu")
public class DichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Size(min = 5, max = 100, message="{dichvu.ten.lenErr}")
    private String ten;
    @Min(value= 50000, message = "{dichvu.gia.minErr}")
    @Max(value= 10000000, message = "{dichvu.gia.maxErr}")
    private BigDecimal gia;
    @Column(name="mo_ta")
    private String mota;
    @Column(name="hinh_anh")
    private String hinhanh;
    @ManyToOne() // fetch = lấy luôn tên dv, cascade xóa luôn dv
    @JoinColumn(name = "loai_id")
    @NotNull(message = "{dichvu.loaidv.nullErr}")
    private LoaiDichVu loaiDichVu;
    @Transient
    private MultipartFile file;
    @OneToMany(mappedBy = "dichVu", fetch = FetchType.EAGER)
    private Set<ChiTietDichVu> chiTietDichVu;
    
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
     * @return the khachHang
     */
//    public Set<KhachHang> getKhachHang() {
//        return khachHang;
//    }
//
//    /**
//     * @param khachHang the khachHang to set
//     */
//    public void setKhachHang(Set<KhachHang> khachHang) {
//        this.khachHang = khachHang;
//    }

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
     * @return the loaiDichVu
     */
    public LoaiDichVu getLoaiDichVu() {
        return loaiDichVu;
    }

    /**
     * @param loaiDichVu the loaiDichVu to set
     */
    public void setLoaiDichVu(LoaiDichVu loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    /**
     * @return the chiTietDichVu
     */
    public Set<ChiTietDichVu> getChiTietDichVu() {
        return chiTietDichVu;
    }

    /**
     * @param chiTietDichVu the chiTietDichVu to set
     */
    public void setChiTietDichVu(Set<ChiTietDichVu> chiTietDichVu) {
        this.chiTietDichVu = chiTietDichVu;
    }

}
