package com.newleaf.catfe.controller;
//ily
import com.newleaf.catfe.database.dao.CatDAO;
import com.newleaf.catfe.database.dao.EventDAO;
import com.newleaf.catfe.database.entity.Cat;
import com.newleaf.catfe.database.entity.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/cats")
public class CatController {

    @Autowired
    private CatDAO catDAO;

    @Autowired
    private EventDAO eventDAO;
    @GetMapping("/")
    public ModelAndView catHome(){
        ModelAndView response = new ModelAndView("cats/cats");
        List<Cat> cats = catDAO.findAll();
        response.addObject("cats", cats);


        // Java Stream iteration example
        cats.stream().forEach(cat -> {
            log.debug("Cat: " + cat.getName());
        });

        return response;
    }

    @GetMapping("/{id}")
    public ModelAndView catDetails(@PathVariable Integer id){
        ModelAndView response = new ModelAndView("cats/cat-details");
        Cat cat = catDAO.findById(id);
        response.addObject("cat", cat);

        List<Event> events = eventDAO.findByCat(cat);
        response.addObject("events", events);

        return response;
    }
}
