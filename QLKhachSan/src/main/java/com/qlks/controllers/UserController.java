/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.controllers;

import com.qlks.pojos.KhachHang;
import com.qlks.pojos.User;
import com.qlks.service.UserService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
public class UserController {
    @Autowired
    private UserService userDetailsService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupView(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(Model model, @ModelAttribute(value = "user") @Valid User user, BindingResult result) {
        String errMsg = "";
        try {
            if (!result.hasErrors()) {
                if (user.getPass().equals(user.getConfirmPassword())) {
                    if (this.userDetailsService.addUser(user) == true) {
                        model.addAttribute("err", "Đăng kí tài khoản thành công !!!");
                        return "login";
                    } else {
                        errMsg = "Lỗi đăng kí người dùng";
                    }
                } else {
                    errMsg = "Mật khẩu xác nhận không chính xác";
                }

            } else {
                return "signup";
            }
        } catch (Exception e) {
            errMsg = "Tài khoản đã tồn tại hoặc thông tin đăng kí không hợp lệ !!!";
        }

        model.addAttribute("err", errMsg);
        return "signup";

    }

    @RequestMapping("/user-info")
    public String info(Model model, HttpSession session,
            @RequestParam(value="id", required = false, defaultValue = "102")int id) {
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        model.addAttribute("kh", this.userDetailsService.getKhachHangById(id));
        
        return "user-info";
    }

    @GetMapping("/user-info/updateuser/{userId}")
    public String updUser(Model model, @PathVariable(value = "userId") int id) {
        KhachHang khachHang = this.userDetailsService.getKhachHangById(id);
        model.addAttribute("kh", khachHang);

        return "user-update";
    }

    @PostMapping("/user-info/updateuser/{userId}")
    public String updateUser(Model model,
            @ModelAttribute("kh") @Valid KhachHang khachHang, BindingResult result) {
        try {
            if (!result.hasErrors()) {
                if (this.userDetailsService.updateKhachHang(khachHang) == true) {
                    model.addAttribute("updateUser", "Cập nhật thông tin thành công !!!");
                } else {
                    model.addAttribute("updateUser", "Error !!!");
                }
            } else {
                model.addAttribute("updateUser", "Lỗi thông tin người dùng !!!");
                return "user-update";
            }

        } catch (Exception ex) {
            System.err.println("== UPDATE USER ERROR" + ex.getMessage());
            ex.printStackTrace();
            model.addAttribute("updateUser", "Error !!!");
        }

        return "user-info";
    }

}
