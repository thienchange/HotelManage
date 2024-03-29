/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.service.impl;

import com.qlks.pojos.LoaiDichVu;
import com.qlks.repository.LoaiDichVuRepository;
import com.qlks.service.LoaiDichVuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class LoaiDichVuServiceImpl implements LoaiDichVuService{
    @Autowired
    private LoaiDichVuRepository loaiDichVuRepository;

    @Override
    public List<LoaiDichVu> getLoaiDichVu() {
        return this.loaiDichVuRepository.getLoaiDichVu();
    }
}
