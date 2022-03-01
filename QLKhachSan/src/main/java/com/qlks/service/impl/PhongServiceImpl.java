/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.qlks.pojos.Phong;
import com.qlks.repository.PhongRepository;
import com.qlks.service.PhongService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Service
@Transactional
public class PhongServiceImpl implements PhongService{
    @Autowired
    private PhongRepository phongRepository;
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<Phong> getPhong(String kw, int page) {
        return this.phongRepository.getPhong(kw, page);
    }
    @Override
    public boolean addOrUpdate(Phong phong) {
        try {
            Map r = this.cloudinary.uploader().upload(phong.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            phong.setHinhanh((String) r.get("secure_url"));
            
            return this.phongRepository.addOrUpdate(phong);
        }catch (IOException ex) {
            System.err.println("== ADD PHONG ==" + ex.getMessage());
        }
        return false;
    }

    @Override
    public long countPhong() {
        return this.phongRepository.countPhong();
    }

    @Override
    public Phong getPhongById(int id) {
        return this.phongRepository.getPhongById(id);
    }
}
