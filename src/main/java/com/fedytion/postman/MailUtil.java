package com.fedytion.postman;

import com.fedytion.config.Env;

import javax.mail.Session;
import java.util.Properties;

public class MailUtil {

    private static final Properties PROPS = new Properties();
    private static final MailUtil INSTANCE = new MailUtil(); // static instance

    private MailUtil() {
        PROPS.put("mail.smtp.host", "smtp.gmail.com");
        PROPS.put("mail.smtp.port", "587");
        PROPS.put("mail.smtp.auth", "true");
        PROPS.put("mail.smtp.starttls.enable", "true");
        PROPS.put("mail.smtp.ssl.protocols", "TLSv1.2 TLSv1.3");
    }

    public static MailUtil getInstance() {
        return INSTANCE;
    }

    public Session getSession(String senderEmail) {
        return Session.getInstance(PROPS, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(senderEmail, Env.get("SMTP_PASSWORD"));
            }
        });
    }
}
