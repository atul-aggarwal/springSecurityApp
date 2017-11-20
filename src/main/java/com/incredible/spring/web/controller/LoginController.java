package com.incredible.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping( method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("welcomePage");

        return model;
    }

    @RequestMapping(value = {"/homePage"}, method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("homePage");

        return model;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView loginPage(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();

        Optional.of(error)
                .ifPresent(e -> model.addObject("error", "Invalid Credentials Provided"));

        Optional.of(logout)
                .ifPresent(l -> model.addObject("message", "logged out from site"));

        model.setViewName("loginPage");

        return model;
    }

}
