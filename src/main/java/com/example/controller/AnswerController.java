package com.example.controller;

import com.example.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import java.util.List;

@Controller
public class AnswerController {
    @Autowired
    SurveyController surveyController;
    @Autowired
    TextService textService;

    @RequestMapping(value = "/deleteYacht/DELETE", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView deleteSelectedYacht(@RequestBody List<String> list,
                                            Model model) throws MessagingException {
//        System.out.println("surveyController.getEmailToSend(); "+emailToSend);
//        System.out.println(list.toString());
        textService.answerSurvey(list);
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("viewSelectedYacht", all);
        modelAndView.setViewName("succeed");
        return  modelAndView;
    }
}
