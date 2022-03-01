/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.service.impl;

import com.qlks.pojos.LoaiPhong;
import com.qlks.repository.LoaiPhongRepository;
import com.qlks.service.LoaiPhongService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class LoaiPhongServiceImpl implements LoaiPhongService{
    @Autowired
    private LoaiPhongRepository loaiPhongRepository;
    
    @Override
    public List<LoaiPhong> getLoaiPhong() {
        return this.loaiPhongRepository.getLoaiPhong();
    }
}
