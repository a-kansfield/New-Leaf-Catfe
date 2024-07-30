package com.newleaf.catfe.form;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
public class EventSignUpFormBean {


    private String firstName;

    private String lastName;

    private String email;

    private String adoptionInterest;


}
