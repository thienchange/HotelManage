/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.service.impl;

import com.qlks.pojos.BoPhan;
import com.qlks.repository.BoPhanRepository;
import com.qlks.service.BoPhanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class BoPhanServiceImpl implements BoPhanService{
    @Autowired
    private BoPhanRepository boPhanRepository;
    
    @Override
    public List<BoPhan> getBoPhan() {
        return this.boPhanRepository.getBoPhan();
    }
    
}
