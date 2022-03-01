/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.repository;

import com.qlks.pojos.KhachHang;
import com.qlks.pojos.User;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface UserRepository {
    boolean addUser(User user);
    List<User> getUsers(String username);
    User getUserById(int id);
    boolean deleteById(int id);
    boolean updateKhachHang(KhachHang kh);
    List<KhachHang> getKhachHangs(int id);
    KhachHang getKhachHangById(int id);
}
