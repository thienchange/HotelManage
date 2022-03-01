/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.qlks.pojos.DichVu;
import com.qlks.pojos.LoaiPhong;
import com.qlks.repository.DichVuRepository;
import com.qlks.service.DichVuService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class DichVuServiceImpl implements DichVuService{
    @Autowired
    private DichVuRepository dichVuRepository;
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<DichVu> getDichVu(String kw) {
        return this.dichVuRepository.getDichVu(kw);
    }
    
    @Override
    public boolean addOrUpdate(DichVu dichVu) {
        try {
            Map r = this.cloudinary.uploader().upload(dichVu.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            dichVu.setHinhanh((String) r.get("secure_url"));
            
            return this.dichVuRepository.addOrUpdate(dichVu);
            
        }catch (IOException ex) {
            System.err.println("== ADD DICH VU ==" + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return this.dichVuRepository.deleteById(id);
    }

    @Override
    public DichVu getDichVuById(int id) {
        return this.dichVuRepository.getDichVuById(id);
    }
}
