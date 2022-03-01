/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.formatter;

import com.qlks.pojos.BoPhan;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ACER
 */
public class BoPhanFormatter implements Formatter<BoPhan>{

    @Override
    public String print(BoPhan object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public BoPhan parse(String bophanId, Locale locale) throws ParseException {
        BoPhan b = new BoPhan();
        b.setId(Integer.parseInt(bophanId));
        
        return b;
    }
    
}
