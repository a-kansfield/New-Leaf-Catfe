package com.newleaf.catfe.controller;

import com.newleaf.catfe.database.entity.Cat;
import com.newleaf.catfe.database.entity.Event;
import lombok.extern.slf4j.Slf4j;
import com.newleaf.catfe.database.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CatDAO catDAO;

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/cats")
    public ModelAndView cats() {
        ModelAndView response = new ModelAndView("admin/cats");
        List<Cat> cats = catDAO.findAll();
        response.addObject("cats", cats);

        return response;
    }

    @GetMapping("/events")
    public ModelAndView events() {
        ModelAndView response = new ModelAndView("admin/events");
        List<Event> events = eventDAO.findAll();
        response.addObject("events", events);

        return response;
    }

}
