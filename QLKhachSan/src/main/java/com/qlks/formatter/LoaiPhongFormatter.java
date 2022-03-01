/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.formatter;

import com.qlks.pojos.LoaiPhong;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ACER
 */
public class LoaiPhongFormatter implements Formatter<LoaiPhong>{
    @Override
    public String print(LoaiPhong object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public LoaiPhong parse(String loaiId, Locale locale) throws ParseException {
        LoaiPhong l = new LoaiPhong();
        l.setId(Integer.parseInt(loaiId));
        
        return l;
    }
    
}
