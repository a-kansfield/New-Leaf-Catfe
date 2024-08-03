package com.newleaf.catfe.controller;
//ily
import com.newleaf.catfe.database.dao.CatDAO;
import com.newleaf.catfe.database.entity.Cat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/cats")
public class CatController {

    @Autowired
    private CatDAO catDAO;

    @GetMapping("/")
    public ModelAndView catHome(){
        ModelAndView response = new ModelAndView("cats/cats");
        List<Cat> cats = catDAO.findAll();
        response.addObject("cats", cats);

        return response;
    }
}
