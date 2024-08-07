package com.newleaf.catfe.controller;

import com.newleaf.catfe.database.dao.CatDAO;
import com.newleaf.catfe.database.dao.EventDAO;

import com.newleaf.catfe.database.entity.Event;
import com.newleaf.catfe.form.EventSignUpFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/events")
public class EventController {
    @Autowired
    private CatDAO catDAO;

    @Autowired
    private EventDAO eventDAO;


    @GetMapping("/")
    public ModelAndView eventHome(){
        ModelAndView response = new ModelAndView("events/events");
        List<Event> events = eventDAO.findAll();
        response.addObject("events", events);

        String datePattern = "MMMM dd";
        DateFormat dateFormat = new SimpleDateFormat(datePattern);
        response.addObject(datePattern);

        return response;
    }

    @GetMapping("/{id}")
    public ModelAndView eventDetails(@PathVariable Integer id){
        ModelAndView response = new ModelAndView("events/event-details");

        response.addObject("id", id);

        Event event = eventDAO.findById(id);
        response.addObject("event", event);
        Map<String,Object> eventDetails = eventDAO.getEventDetails(id);
        response.addObject("eventDetails", eventDetails);



        EventSignUpFormBean form = new EventSignUpFormBean();
        response.addObject("form", form);
        log.debug(form.getFirstName());

        return response;
    }

    @PostMapping("/{id}")
    public ModelAndView eventDetailsSubmit(@PathVariable Integer id, EventSignUpFormBean form){
        ModelAndView response = new ModelAndView();
        response.addObject("id", id);
        response.addObject("form", form);
        log.debug(form.getFirstName());
        response.setViewName("redirect:/events/" + id);
        return response;


    }
}
