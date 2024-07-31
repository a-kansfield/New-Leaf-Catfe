package com.newleaf.catfe.controller;

import com.newleaf.catfe.database.entity.User;
import com.newleaf.catfe.database.dao.UserDAO;
import com.newleaf.catfe.form.CreateAccountFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Slf4j
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView response = new ModelAndView("auth/login");
        return response;

    }


    @GetMapping("/sign-up")
    public ModelAndView signUp(){
        ModelAndView response = new ModelAndView("auth/sign-up");
        return response;
    }

    @PostMapping("/sign-up")
    public ModelAndView signUpSubmit(CreateAccountFormBean form){
        ModelAndView response = new ModelAndView("auth/sign-up");
        response.addObject("form", form);

        User user = new User();
        user.setEmail(form.getEmail());
        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encryptedPassword);

        log.debug(user.toString());
        userDAO.save(user);

        // save the user to the database



        return response;

    }
}
