package com.newleaf.catfe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/events")
public class EventController {


    @GetMapping("/")
    public ModelAndView eventHome(){
        ModelAndView response = new ModelAndView("events/events");
        return response;
    }

    @GetMapping("/details")
    public ModelAndView eventDetails(){
        ModelAndView response = new ModelAndView("events/event-details");
        return response;
    }
}
