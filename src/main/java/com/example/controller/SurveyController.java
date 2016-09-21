package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SurveyController {
     private String emailToSend;

    public String getEmailToSend() {
        return emailToSend;
    }

    public void setEmailToSend(String emailToSend) {
        this.emailToSend = emailToSend;
    }

    @RequestMapping(value = "/survey", method = {RequestMethod.GET})
    public ModelAndView viewMainPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("email", emailToSend);
        modelAndView.setViewName("survey");
        return modelAndView;
    }
    @RequestMapping(value = "/survey/receive", method = {RequestMethod.POST})
    public ModelAndView viewMainPage(@RequestParam("nameSelectedWhisky")String email) {
        emailToSend=email;

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("survey");
        return modelAndView;
    }

}
