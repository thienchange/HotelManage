/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.formatter;

import com.qlks.pojos.LoaiDichVu;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ACER
 */
public class LoaiDVuFormatter implements Formatter<LoaiDichVu>{

    @Override
    public String print(LoaiDichVu object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public LoaiDichVu parse(String loaiId, Locale locale) throws ParseException {
        LoaiDichVu l = new LoaiDichVu();
        l.setId(Integer.parseInt(loaiId));
        
        return l;
    }
    
}
