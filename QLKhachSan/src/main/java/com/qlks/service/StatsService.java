/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.service;

import java.util.Date;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface StatsService {
    List<Object[]> loaiStats();
    List<Object[]> phongStats(String kw, Date fromDate, Date toDate);
    List<Object[]> phongMonthStats(String kw, Date fromDate, Date toDate);
    List<Object[]> MonthStats();
    List<Object[]> dichVuStats(String kw, Date fromDate, Date toDate);
    List<Object[]> dichVuMonthStats(String kw, Date fromDate, Date toDate);
    List<Object[]> KhachHangStats(String kw, Date fromDate, Date toDate);
    List<Object[]> KhachHangPhongStats(String kw, Date fromDate, Date toDate);
}
