/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.validator;

import com.qlks.pojos.DichVu;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author ACER
 */
@Component
public class TenDichVuValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return DichVu.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DichVu d = (DichVu) target;
        if (!d.getTen().contains("DV"))
            errors.rejectValue("ten", "dichvu.ten.myErr");
    }
}
