/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.repository;

import com.qlks.pojos.Phong;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface PhongRepository {
    List<Phong> getPhong(String kw, int page);
    boolean addOrUpdate(Phong phong);
    long countPhong();
    Phong getPhongById(int id);
}
