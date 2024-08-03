package com.newleaf.catfe.controller;

import com.newleaf.catfe.database.entity.User;
import com.newleaf.catfe.database.dao.UserDAO;
import com.newleaf.catfe.form.CreateAccountFormBean;
import com.newleaf.catfe.security.AuthenticatedUserUtilities;
import com.newleaf.catfe.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(required = false) String error){
        ModelAndView response = new ModelAndView("auth/login");

        return response;

    }
    @PostMapping("/login")
    public ModelAndView loginSubmit(){
        ModelAndView response = new ModelAndView("auth/login");
        response.setViewName("redirect:/");
        return response;

    }

    @GetMapping("/sign-up")
    public ModelAndView signUp(){
        ModelAndView response = new ModelAndView("auth/sign-up");
        return response;
    }

    @PostMapping("/sign-up")
    public ModelAndView signUpSubmit(CreateAccountFormBean form, HttpSession session){
        ModelAndView response = new ModelAndView("auth/sign-up");
        response.addObject("form", form);

        // save the user to the database
        User user = userService.createUser(form);
        authenticatedUserUtilities.manualAuthentication(session, form.getEmail(), form.getPassword());
        response.setViewName("redirect:/");


        return response;

    }
}
