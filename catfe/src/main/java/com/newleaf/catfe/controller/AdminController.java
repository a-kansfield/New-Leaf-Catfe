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
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
        response.setViewName("redirect:/admin/cats");
        return response;
    }
    // Note: Currently, deleting a cat that is associated with an event will also delete the event. Unaffiliate cat with event before deletion
    @PostMapping("/cats/delete")
    public ModelAndView deleteEvent(CreateCatFormBean form) {
        ModelAndView response = new ModelAndView();

        response.addObject("form", form);
        Cat cat = catService.findOrCreateCat(form.getId());
        log.debug("Deleting " + cat.getName() + " from cat database.");
        catDAO.delete(cat);
        response.setViewName("redirect:/admin/cats");
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
    public ModelAndView eventSubmit(@Valid CreateEventFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView("admin/create-event");

       // Error Checking
        if(bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            // Still Within error statement
            response.addObject("bindingResult", bindingResult); // Adds error to view to use in JSP page.

            //Copied from edit and create, as this needs to be repopulated as a result of an error.
            List<Cat> cats = catDAO.findAll();

            response.addObject("cats", cats);
            response.setViewName("admin/create-event");

            return response;

        } else {

            Event event = eventService.findOrCreateEvent(form.getId());
            event = eventService.saveEvent(event, form);

            response.addObject("form", form);
            response.setViewName("redirect:/admin/events");
            return response;

        }
    }

    @GetMapping("/events/{id}/edit")
    public ModelAndView editEvent(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("admin/create-event");

        List<Cat> cats = catDAO.findAll();

        Event event = eventService.findOrCreateEvent(id);                   // Checks to see if event already exists. If not, create new event
        CreateEventFormBean form = eventService.populateEventForm(event);   // Fills the event form based on event values.

        response.addObject("form", form);
        response.addObject("cats", cats);

        return response;
    }

    @PostMapping("/events/delete")
    public ModelAndView deleteEvent(CreateEventFormBean form) {
        ModelAndView response = new ModelAndView();

        response.addObject("form", form);
        Event event = eventService.findOrCreateEvent(form.getId());
        log.debug("Deleting " + event.getTitle() + " from event database.");
        eventDAO.delete(event);
        response.setViewName("redirect:/admin/events");
        return response;
    }

}

