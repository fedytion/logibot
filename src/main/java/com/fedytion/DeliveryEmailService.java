package com.fedytion;

import com.fedytion.calculator.DeliveryPriceCalculator;
import com.fedytion.calculator.GoogleApiDistanceService;
import com.fedytion.parser.RecipientInfo;
import com.fedytion.parser.RecipientInfoParser;
import com.fedytion.parser.RouteInfo;
import com.fedytion.parser.RouteParser;
import com.fedytion.postman.EmailService;
import com.fedytion.postman.HtmlFormatter;
import com.fedytion.postman.MailUtil;

import javax.mail.Session;
import java.io.IOException;

public class DeliveryEmailService {
    private final RouteParser routeParser;
    private final RecipientInfoParser recipientParser;
    private final DeliveryPriceCalculator calculator;
    private static final String SENDER_EMAIL = "Fnatalo4ka@gmail.com";

    public DeliveryEmailService() {
        this.routeParser = new RouteParser();
        this.recipientParser = new RecipientInfoParser();
        this.calculator = new DeliveryPriceCalculator(new GoogleApiDistanceService());
    }

    public void sendEmail() throws IOException {
        RouteInfo route = routeParser.getRoute();
        RecipientInfo recipient = recipientParser.getRecipient();

        String price = calculator.calculatePrice(route.fromCity(), route.toCity());
        String html = HtmlFormatter.getInstance().getFormattedHtml(price, route, recipient.name());
        Session session = MailUtil.getInstance().getSession(SENDER_EMAIL);

        EmailService emailService = new EmailService(session, html);
        emailService.sendEmail(recipient.email());
    }
}

