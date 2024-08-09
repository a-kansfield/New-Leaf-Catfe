package com.newleaf.catfe.controller;

import com.newleaf.catfe.database.dao.CatDAO;
import com.newleaf.catfe.database.dao.EventDAO;
import com.newleaf.catfe.database.dao.UserDAO;
import com.newleaf.catfe.database.entity.Cat;
import com.newleaf.catfe.database.entity.Event;
import com.newleaf.catfe.form.CreateCatFormBean;
import com.newleaf.catfe.form.CreateEventFormBean;
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
        response.addObject("imgURL", dir + "cats/");

        return response;
    }

    @GetMapping("/cats/{id}/edit")
    public ModelAndView editCat(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("admin/create-cat");
        Cat cat = catDAO.findById(id);
        String toRemove = dir +"cats/";
        String url = conversionUtil.truncateURL(cat.getImageURL(), toRemove);
        CreateCatFormBean form = new CreateCatFormBean();
        form.setId(id);


        form.setName(cat.getName());
        form.setAge(cat.getAge());
        form.setGender(cat.getGender());
        form.setDescription(cat.getDescription());
        form.setImageURL(url);

        response.addObject("form", form);
        return response;
    }
    @PostMapping("/cats/new")
    public ModelAndView catSubmit(CreateCatFormBean form) {
        ModelAndView response = new ModelAndView("admin/create-cat");

        response.addObject("form", form);
        String url = dir + "cats/" + form.getImageURL();

        Cat cat = catDAO.findById(form.getId());
        if (cat == null) {
            cat = new Cat();
        }
        cat.setName(form.getName());
        cat.setAge(form.getAge());
        cat.setDescription(form.getDescription());
        cat.setGender(form.getGender());
        cat.setImageURL(url);
        cat.setAdoptionStatus("open");

        cat = catDAO.save(cat);

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



        response.addObject("form", form);
        String url = dir + "events/" + form.getImageURL();

        Event event = eventDAO.findById(form.getId());
        if (event == null) {
            event = new Event();
        }
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
    public ModelAndView editEvent(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("admin/create-event");
        List<Cat> cats = catDAO.findAll();
        response.addObject("cats", cats);
        CreateEventFormBean form = new CreateEventFormBean();


        Event event = eventDAO.findById(id);

        form.setId(id);

        form.setTitle(event.getTitle());
        form.setStartDate(event.getStartDate());
        form.setEndDate(event.getEndDate());
        form.setDescription(event.getDescription());
        form.setCapacity(event.getCapacity());

        form.setFeaturedCat(event.getCat().getId());
        form.setServesAlcohol(conversionUtil.boolToString(event.isServesAlcohol()));

        String toRemove = dir +"events/";
        String url = conversionUtil.truncateURL(event.getImageURL(), toRemove);
        form.setImageURL(url);

        response.addObject("form", form);
        response.addObject("eventCatId", event.getCat().getId());

        return response;
    }
}
