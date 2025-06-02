package com.fedytion.postman;

import com.fedytion.config.Constants;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
    private final Session session;
    private final String formattedHtml;

    public EmailService(Session session, String formattedHtml) {
        this.session = session;
        this.formattedHtml = formattedHtml;
    }

    public void sendEmail(String recipientEmail) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Constants.SENDER_EMAIL));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject(Constants.EMAIL_SUBJECT);
            message.setContent(formattedHtml, "text/html; charset=utf-8");

            Transport.send(message);
            System.out.println("Message sent successfully!");
        } catch (Exception e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }
}
