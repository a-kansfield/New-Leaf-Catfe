package com.newleaf.catfe.service;

import com.newleaf.catfe.database.dao.CatDAO;
import com.newleaf.catfe.database.entity.Cat;
import com.newleaf.catfe.form.CreateCatFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CatService {

    @Autowired
    private CatDAO catDAO;

    private String dir = "../../../pub/assets/imgs/cats/";

    public Cat saveCat(CreateCatFormBean form, Cat cat) {



        cat.setName(form.getName());
        cat.setAge(form.getAge());
        cat.setDescription(form.getDescription());
        cat.setGender(form.getGender());
        cat.setImageURL(dir + form.getImageURL());
        cat.setAdoptionStatus("open");

        cat = catDAO.save(cat);
        return cat;
    }

    private Cat findOrCreateCat(Integer id) {
        Cat cat = catDAO.findById(id);
        if (cat == null) {
            cat = new Cat();
        }
        return cat;
    }
//    public CreateCatFormBean populateCatForm() {
//
//    }
}
