/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.formatter;

import com.qlks.pojos.ChucVu;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ACER
 */
public class ChucVuFormatter implements Formatter<ChucVu>{

    @Override
    public String print(ChucVu object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public ChucVu parse(String chucvuId, Locale locale) throws ParseException {
        ChucVu c = new ChucVu();
        c.setId(Integer.parseInt(chucvuId));
        
        return c;
    }
    
}
