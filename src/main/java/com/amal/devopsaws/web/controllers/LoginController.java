package com.amal.devopsaws.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    /** The login view name */
    public static final String LOGIN_VIEW_NAME = "user/login";

    @RequestMapping("/login")
    public String login(){
        return LoginController.LOGIN_VIEW_NAME;
    }

}
