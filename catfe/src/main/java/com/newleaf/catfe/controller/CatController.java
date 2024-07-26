package com.newleaf.catfe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cats")
public class CatController {


    @GetMapping("/")
    public ModelAndView catHome(){
        ModelAndView response = new ModelAndView("cats/cats");
        return response;
    }
}