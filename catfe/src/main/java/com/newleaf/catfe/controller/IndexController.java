package com.newleaf.catfe.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class IndexController {

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView response = new ModelAndView("home/index");
        return response;
    }

    @GetMapping("/about")
    public ModelAndView about() {
        ModelAndView response = new ModelAndView("about/about");
        return response;
    }
}
