package com.newleaf.catfe.form;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@ToString
public class CreateAccountFormBean {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

}