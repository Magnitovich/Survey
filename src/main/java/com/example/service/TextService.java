package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TextService {

    @Autowired
    SendEmailService sendEmailService;

    private String questionOneYes = "1. You say YES on answer one ";
    private String questionOneNo = "1. You say NO on answer one ";
    private String questionTwoYes = "2. You say YES on answer two ";
    private String questionTwoNo = "2. You say NO on answer two ";
    private String questionThreeYes = "3. You say YES on answer three ";
    private String questionThreeNo = "3. You say NO on answer three ";
    private String questionFourYes = "4. You say YES on answer four ";
    private String questionFourNo = "4. You say NO on answer four ";
    private String questionFiveYes = "5. You say YES on answer five ";
    private String questionFiveNo = "5. You say NO on answer five ";

    public ArrayList<String> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList answer) {
        this.answer = answer;
    }

    private ArrayList<String> answer = new ArrayList<String>();

    String addText;

    public void answerSurvey(List<String> list) throws MessagingException {
        String[] split;

        for(String properties:list){
           split = properties.split(",");

//                System.out.println(split[0]);

            switch (split[0]){
                case "questionOneYes": addText=questionOneYes;
                    break;
                case "questionOneNo": addText=questionOneNo;
                    break;
                case "questionTwoYes": addText=questionTwoYes;
                    break;
                case "questionTwoNo": addText=questionTwoNo;
                    break;
                case "questionThreeYes": addText=questionThreeYes;
                    break;
                case "questionThreeNo": addText=questionThreeNo;
                    break;
                case "questionFourYes": addText=questionFourYes;
                    break;
                case "questionFourNo": addText=questionFourNo;
                    break;
                case "questionFiveYes": addText=questionFiveYes;
                    break;
                case "questionFiveNo": addText=questionFiveNo;
                    break;
                default: new Exception();
            }
           answer.add(addText);
//            System.out.println(answer);
        }

//        for (String k:answer) {
//            System.out.println("K:= "+k);
//        }

    sendEmailService.sendingMessage();

    }


}
