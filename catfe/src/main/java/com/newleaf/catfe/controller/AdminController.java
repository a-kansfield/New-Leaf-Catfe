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
        ModelAndView response = new ModelAndView("create-event");
        List<Cat> cats = catDAO.findAll();
        response.addObject("cats", cats);

        return response;
    }
    @PostMapping("/events/new")
    public ModelAndView newEventSubmit(CreateEventFormBean form) {
        ModelAndView response = new ModelAndView("create-event");
        response.addObject("form", form);
        String url = "../../../pub/assets/imgs/events/" + form.getImageURL();
        Event event = new Event();
        event.setTitle(form.getTitle());
        event.setStartDate(form.getStartDate());
        event.setEndDate(form.getEndDate());
        event.setDescription(form.getDescription());
        event.setCapacity(form.getCapacity());
        event.setImageURL(url);
        Cat cat = catDAO.findById(form.getFeaturedCat());
        event.setCat(cat);
        event.setFeaturedCat(cat.getId());

        if (form.getServesAlcohol() != null) {
            event.setServesAlcohol(true);
        } else {
            event.setServesAlcohol(false);
        }

        log.debug(event.toString());

        event = eventDAO.save(event);
        return response;
    }

    @GetMapping("/events/{id}/edit")
    public ModelAndView editEvent() {
        ModelAndView response = new ModelAndView("admin/edit-event");
        return response;
    }
}
