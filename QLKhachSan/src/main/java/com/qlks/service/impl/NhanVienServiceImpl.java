/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.service.impl;

import com.qlks.pojos.NhanVien;
import com.qlks.repository.NhanVienRepository;
import com.qlks.service.NhanVienService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Service
public class NhanVienServiceImpl implements NhanVienService{
    @Autowired
    private NhanVienRepository nhanVienRepository;
    
    @Override
    public List<NhanVien> getNhanVien(String kw) {
        return this.nhanVienRepository.getNhanVien(kw);
    }

    @Override
    public boolean addOrUpdate(NhanVien nhanVien) {
        return this.nhanVienRepository.addOrUpdate(nhanVien);
    }

    @Override
    public boolean deleteById(int id) {
        return this.nhanVienRepository.deleteById(id);
    }

    @Override
    public NhanVien getNhanVienById(int id) {
        return this.nhanVienRepository.getNhanVienById(id);
    }

}
