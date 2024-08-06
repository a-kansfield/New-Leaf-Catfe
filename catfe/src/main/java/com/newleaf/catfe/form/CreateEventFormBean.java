package com.newleaf.catfe.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class CreateEventFormBean {


//    id int AI PK
    private Integer id;
//    title varchar(80)
    private String title;
//    description text
    private String description;
//    start_date datetime
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date startDate;
//    end_date datetime
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date endDate;
//    capacity int
    private Integer capacity;
//    serves_alcohol tinyint(1)
    private Boolean servesAlcohol;
//    image_url varchar(70)
    private String imageURL;
//    featured_cat int
    private Integer featuredCat;
}
