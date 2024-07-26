package com.newleaf.catfe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menu")
public class MenuController {


    @GetMapping("/")
    public ModelAndView eventHome(){
        ModelAndView response = new ModelAndView("menu/menu");
        return response;
    }
}