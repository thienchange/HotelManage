/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.validator;

import com.qlks.pojos.DichVu;
import com.qlks.pojos.LoaiDichVu;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author ACER
 */
@Component
public class WebAppValidator implements Validator{
    @Autowired
    private javax.validation.Validator beanValidator;
    
    private Set<Validator> springValidators;
    
    @Override
    public boolean supports(Class<?> clazz) {
        return DichVu.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Set<ConstraintViolation<Object>> beans = this.beanValidator.validate(target);
        for (ConstraintViolation<Object> obj:beans)
            errors.rejectValue(obj.getPropertyPath().toString(), 
                    obj.getMessageTemplate(), obj.getMessage());
        
        for(Validator v: this.springValidators)
            v.validate(target, errors);
        
    }

    /**
     * @param springValidators the springValidators to set
     */
    public void setSpringValidators(Set<Validator> springValidators) {
        this.springValidators = springValidators;
    }
}
