/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.repository;

import com.qlks.pojos.NhanVien;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ACER
 */
public interface NhanVienRepository {
    List<NhanVien> getNhanVien(String kw);
    boolean addOrUpdate(NhanVien nhanVien);
    boolean deleteById(int id);
    NhanVien getNhanVienById(int id);
}
