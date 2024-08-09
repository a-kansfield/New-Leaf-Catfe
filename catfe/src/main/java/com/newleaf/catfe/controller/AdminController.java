package com.newleaf.catfe.controller;

import com.newleaf.catfe.database.dao.CatDAO;
import com.newleaf.catfe.database.dao.EventDAO;
import com.newleaf.catfe.database.dao.UserDAO;
import com.newleaf.catfe.database.entity.Cat;
import com.newleaf.catfe.database.entity.Event;
import com.newleaf.catfe.form.CreateCatFormBean;
import com.newleaf.catfe.form.CreateEventFormBean;
import com.newleaf.catfe.service.CatService;
import com.newleaf.catfe.service.EventService;
import com.newleaf.catfe.util.ConversionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private CatService catService;

    @Autowired
    private EventService eventService;

    @Autowired
    private ConversionUtil conversionUtil;

    private String dir = "../../../pub/assets/imgs/";

    // ######### Cats ######### //
    @GetMapping("/cats")
    public ModelAndView cats() {
        ModelAndView response = new ModelAndView("admin/cats");

        List<Cat> cats = catDAO.findAll();
        response.addObject("cats", cats);
        
        return response;
    }

    @GetMapping("/cats/new")
    public ModelAndView newCats() {
        ModelAndView response = new ModelAndView("admin/create-cat");

        response.addObject("imgURL", catService.getDir());

        return response;
    }

    @GetMapping("/cats/{id}/edit")
    public ModelAndView editCat(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("admin/create-cat");

        Cat cat = catService.findOrCreateCat(id);
        CreateCatFormBean form = catService.populateCatForm(cat);

        response.addObject("form", form);
        return response;
    }
    @PostMapping("/cats/new")
    public ModelAndView catSubmit(CreateCatFormBean form) {
        ModelAndView response = new ModelAndView("admin/create-cat");

        response.addObject("form", form);

        Cat cat = catService.findOrCreateCat(form.getId());
        cat = catService.saveCat(form, cat);

        return response;
    }

    // ######### Events ######### //
    @GetMapping("/events")
    public ModelAndView events() {
        ModelAndView response = new ModelAndView("admin/events");
        List<Event> events = eventDAO.findAll();
        response.addObject("events", events);

        return response;
    }

    @GetMapping("/events/new")
    public ModelAndView newEvent() {
        ModelAndView response = new ModelAndView("admin/create-event");

        List<Cat> cats = catDAO.findAll();
        response.addObject("cats", cats);

        return response;
    }
    @PostMapping("/events/new")
    public ModelAndView eventSubmit(/*@Valid*/ CreateEventFormBean form/*, BindingResult bindingResult*/) {
        ModelAndView response = new ModelAndView("admin/create-event");

        //Error Checking
//        if(bindingResult.hasErrors()) {
//            for (ObjectError error : bindingResult.getAllErrors()) {
//                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
//            }
//            // Still Within error statement
//
//            response.addObject("bindingResult", bindingResult); // Adds error to view to use in JSP page.
//
//
//        }

        Event event = eventService.findOrCreateEvent(form.getId());
        event = eventService.saveEvent(event, form);

        response.addObject("form", form);
        return response;
    }

    @GetMapping("/events/{id}/edit")
    public ModelAndView editEvent(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("admin/create-event");

        List<Cat> cats = catDAO.findAll();

        Event event = eventService.findOrCreateEvent(id);
        CreateEventFormBean form = eventService.populateEventForm(event);

        response.addObject("form", form);
        response.addObject("cats", cats);
        response.addObject("eventCatId", event.getCat().getId()); //Attempt to get select to autopopulate correctly

        return response;
    }
}
