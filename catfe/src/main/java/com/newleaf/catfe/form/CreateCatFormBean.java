package com.newleaf.catfe.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCatFormBean {

    private Integer id;

    private String name;

    private Integer age;

    private String description;

    private String gender;

    private String imageURL;

    //Note: Don't include adoption status and adopted by for now - I can add this after the course!

}
