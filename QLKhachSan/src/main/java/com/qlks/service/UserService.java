/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.service;

import com.qlks.pojos.KhachHang;
import com.qlks.pojos.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author ACER
 */
public interface UserService extends UserDetailsService{
    boolean addUser(User user);
    List<User> getUsers(String username);
    User getUserById(int id);
    boolean deleteById(int id);
    boolean updateKhachHang(KhachHang kh);
    KhachHang getKhachHangById(int id);
}
