/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.qlks.pojos.KhachHang;
import com.qlks.pojos.User;
import com.qlks.repository.UserRepository;
import com.qlks.service.UserService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Service("userDetailsService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean addUser(User user) {
        try {
            String pass = user.getPass();
            user.setPass(this.passwordEncoder.encode(pass));
            user.setQuyenUser(User.USER);
            Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            user.setAvatar((String) r.get("secure_url"));
            return this.userRepository.addUser(user);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getUsers(String username) {
        return this.userRepository.getUsers(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUsers(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("Tên người dùng không tồn tại");
        }

        User user = users.get(0);
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getQuyenUser()));

        return new org.springframework.security.core.userdetails.User(user.getUser(), user.getPass(), auth);
    }

    @Override
    public User getUserById(int id) {
        return this.userRepository.getUserById(id);
    }

    @Override
    public boolean updateKhachHang(KhachHang kh) {
        return this.userRepository.updateKhachHang(kh);
    }

    @Override
    public boolean deleteById(int id) {
        return this.userRepository.deleteById(id);
    }

    @Override
    public KhachHang getKhachHangById(int id) {
        return this.userRepository.getKhachHangById(id);
    }

}
