package com.newleaf.catfe.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@Controller
@ControllerAdvice       // Used to define a class as an exception handler
public class ErrorController {

    private String getHTMLStackTrace(String[] stack) {
        StringBuffer result = new StringBuffer();
        for (String frame : stack) {
            // Change this to be your package name
            if (frame.contains("com.newleaf.catfe")) {
                result.append(" &nbsp; &nbsp; &nbsp;" + frame.trim().substring(3) + "<br>\n");
            } else if (frame.contains("Caused by:")) {
                result.append("Caused By:<br>");
            }
        }
        return result.toString();
    }

}
