package com.newleaf.catfe.controller;

import com.newleaf.catfe.database.entity.Cat;
import com.newleaf.catfe.database.entity.Event;
import com.newleaf.catfe.form.CreateEventFormBean;
import com.newleaf.catfe.service.EventService;
import lombok.extern.slf4j.Slf4j;
import com.newleaf.catfe.database.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private CatDAO catDAO;

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private EventService eventService;
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

    @GetMapping("/events/new")
    public ModelAndView newEvent() {
        ModelAndView response = new ModelAndView("admin/new-event");
        List<Cat> cats = catDAO.findAll();
        response.addObject("cats", cats);

        return response;
    }
    @PostMapping("/events/new")
    public ModelAndView newEventSubmit(CreateEventFormBean form) {
        ModelAndView response = new ModelAndView("admin/new-event");
//        log.debug(form.getTitle());
//        log.debug(form.getCapacity().toString());
//        log.debug(form.getDescription());
        log.debug(form.getStartDate().toString());
        log.debug(form.getEndDate().toString());
//        Date startDate = eventService.convertDate(form.getStartDate());
//        log.debug(startDate.toString());
//        log.debug(form.getServesAlcohol().toString());

        return response;
    }

    @GetMapping("/events/{id}/edit")
    public ModelAndView editEvent() {
        ModelAndView response = new ModelAndView("admin/edit-event");
        return response;
    }
}
