/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.service;


import com.qlks.pojos.DichVu;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface DichVuService{
    List<DichVu> getDichVu(String kw);
    boolean addOrUpdate(DichVu dichVu);
    boolean deleteById(int id);
    DichVu getDichVuById(int id);
}
