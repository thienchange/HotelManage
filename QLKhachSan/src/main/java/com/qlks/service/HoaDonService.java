/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.service;

import com.qlks.pojos.ChiTietDichVu;
import com.qlks.pojos.ChiTietPhong;
import com.qlks.pojos.HoaDonDat;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface HoaDonService {
    List<HoaDonDat> getHoaDonDat(String kw);
    boolean Update(HoaDonDat hoaDonDat);
    boolean deleteById(int id);
    HoaDonDat getHoaDonDatById(int id);
    List<ChiTietPhong> getChiTietPhong(int id);
    List<ChiTietDichVu> getChiTietDichVu(int id);
    ChiTietPhong getChiTietPhongById(int id);
}
