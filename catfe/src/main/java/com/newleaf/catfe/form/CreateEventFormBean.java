package com.newleaf.catfe.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class CreateEventFormBean {



    private Integer id;

    @NotEmpty(message = "Title is required.")
    @Length(max = 80, message = "Title must be less than 80 characters.")
    private String title;

    private String description;


    @NotNull(message="Start Date required.")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date startDate;

    @NotNull(message="End Date required.")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date endDate;

    private Integer capacity;

    private String servesAlcohol;

    private String imageURL;

    @NotNull(message = "Cat is required.")
    private Integer featuredCat;
}
