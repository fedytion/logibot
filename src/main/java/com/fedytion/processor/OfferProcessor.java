package com.fedytion.processor;


import com.fedytion.calculator.DeliveryPriceCalculator;
import com.fedytion.calculator.GoogleApiDistanceService;
import com.fedytion.emaillog.EmailLogService;
import com.fedytion.parser.*;
import com.fedytion.postman.EmailService;
import com.fedytion.postman.HtmlFormatter;
import com.fedytion.postman.MailUtil;
import com.fedytion.webdriver.WebPageParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import javax.mail.Session;
import java.io.File;
import java.io.IOException;
import static com.fedytion.config.Constants.SENDER_EMAIL;

public class OfferProcessor {
    WebPageParser parser = new WebPageParser();

    private final Document doc;
    private final DeliveryPriceCalculator CALCULATOR = new DeliveryPriceCalculator(new GoogleApiDistanceService());

    public OfferProcessor() {
        try {
            File file = new File(parser.getHtmlPage());
            this.doc = Jsoup.parse(file, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processOffer() {

        HtmlParser htmlParser = new HtmlParser(doc);
        ParseFilter parseFilter = new ParseFilter(doc);
        ParsedInfo parsedInfo = htmlParser.parseHtml();

        if (EmailLogService.alreadySent("natalia.test.recipient@gmail.com")) { // parsedInfo.contacts().email()
            System.out.println("Користувач вже існує");

        } else if (!parseFilter.shouldSkip()) {
            EmailLogService.addEmail("natalia.test.recipient@gmail.com"); // parsedInfo.contacts().email()
            String price = parsedInfo.originalPrice().price();

            if (price.equals("0")) {
                try {
                    price = CALCULATOR.calculatePrice(
                            parsedInfo.routeInfo().fromCityIndex(),
                            parsedInfo.routeInfo().toCityIndex());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            Session session = MailUtil.getInstance().getSession(SENDER_EMAIL);
            String formattedHtml = HtmlFormatter.getInstance().getFormattedHtml(price, parsedInfo.routeInfo());
            EmailService emailService = new EmailService(session, formattedHtml);
            System.out.println(formattedHtml);
            emailService.sendEmail("natalia.test.recipient@gmail.com");

        }
    }
}
