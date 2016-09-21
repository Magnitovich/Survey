package com.example.service;

import com.example.controller.SurveyController;
import com.itextpdf.text.*;
import com.sun.javafx.text.TextLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SendEmailService {

    @Value("${img.imageMail.path}")
    private String imagePath;

//    @Value("${img.yachtMail.path}")
//    private String imagePathYacht;
//
//    @Value("${img.carMail.path}")
//    private String imagePathCar;

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    SurveyController surveyController;

    @Autowired
    TextService textService;



    public void sendingMessage( ) throws MessagingException {

        MimeMessage mimeMessage =  javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        String emailFromUI = surveyController.getEmailToSend();

        String toAddress = "newbrain31@gmail.com";
        String[] emailAdressArrays = new String[]{toAddress, emailFromUI};
        helper.setCc(emailAdressArrays);


        String subject = "Your survey:";
        helper.setSubject(subject);

        ByteArrayOutputStream outputStream = null;
        try{
            //now write the PDF content to the output stream
            outputStream = new ByteArrayOutputStream();
            writePdf(outputStream);
            byte[] bytes = outputStream.toByteArray();

            //construct the pdf body part
            DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
            MimeBodyPart pdfBodyPart = new MimeBodyPart();
            pdfBodyPart.setDataHandler(new DataHandler(dataSource));
            pdfBodyPart.setFileName("survey.pdf");

            //construct the mime multi part
            MimeMultipart mimeMultipart = new MimeMultipart();
//            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart);

            mimeMessage.setContent(mimeMultipart);
            helper.setFrom(emailFrom);

            javaMailSender.send(mimeMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //clean off
            if(null != outputStream) {
                try { outputStream.close(); outputStream = null; }
                catch(Exception ex) { }
            }
        }
    }
    public void writePdf(OutputStream outputStream) throws Exception {

        Paragraph paragraph = new Paragraph();
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);

        document.open();

        document.addTitle("Survey PDF");

        ArrayList nameArrays = new ArrayList();
        StringBuffer sb = new StringBuffer();
        int i = -1;

        for (String properties : textService.getAnswer()) {

            nameArrays.add(properties);
            i++;
        }
        for (int a= 0; a<=i; a++){
            System.out.println("nameArrays.get(a) -"+nameArrays.get(a));
            sb.append(nameArrays.get(a)+"\n");

        }
        paragraph.add(sb.toString());
        document.add(paragraph);

        document.close();
    }
}
