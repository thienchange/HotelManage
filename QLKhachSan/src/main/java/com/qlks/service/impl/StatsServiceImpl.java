/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.service.impl;

import com.qlks.repository.StatsRepository;
import com.qlks.service.StatsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class StatsServiceImpl implements StatsService{
    @Autowired
    private StatsRepository statsRepository;    
    
    @Override
    public List<Object[]> loaiStats() {
        return this.statsRepository.loaiStats();
    }

    @Override
    public List<Object[]> phongStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.phongStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object[]> phongMonthStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.phongMonthStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object[]> MonthStats() {
        return this.statsRepository.MonthStats();
    }

    @Override
    public List<Object[]> dichVuStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.dichVuStats(kw, fromDate, toDate);
    }
    
    @Override
    public List<Object[]> dichVuMonthStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.dichVuMonthStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object[]> KhachHangStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.KhachHangStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object[]> KhachHangPhongStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.KhachHangPhongStats(kw, fromDate, toDate);
    }
    
}
