/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.service.impl;

import com.qlks.pojos.ChiTietDichVu;
import com.qlks.pojos.ChiTietPhong;
import com.qlks.pojos.HoaDonDat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qlks.repository.HoaDonRepository;
import com.qlks.service.HoaDonService;

/**
 *
 * @author ACER
 */
@Service
public class HoaDonServiceImpl implements HoaDonService{
    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Override
    public List<HoaDonDat> getHoaDonDat(String kw) {
        return this.hoaDonRepository.getHoaDonDat(kw);
    }

    @Override
    public boolean Update(HoaDonDat hoaDonDat) {
        return this.hoaDonRepository.Update(hoaDonDat);
    }

    @Override
    public boolean deleteById(int id) {
        return this.hoaDonRepository.deleteById(id);
    }

    @Override
    public HoaDonDat getHoaDonDatById(int id) {
        return this.hoaDonRepository.getHoaDonDatById(id);
    }

    @Override
    public List<ChiTietPhong> getChiTietPhong(int id) {
        return this.hoaDonRepository.getChiTietPhong(id);
    }

    @Override
    public ChiTietPhong getChiTietPhongById(int id) {
        return this.hoaDonRepository.getChiTietPhongById(id);
    }

    @Override
    public List<ChiTietDichVu> getChiTietDichVu(int id) {
        return this.hoaDonRepository.getChiTietDichVu(id);
    }
    
    
    
}
