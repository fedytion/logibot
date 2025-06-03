package com.fedytion.postman;

import com.fedytion.parser.RouteInfo;

import static com.fedytion.postman.HtmlTemplateEngine.generateEmail;

public class HtmlFormatter {

    private static final HtmlFormatter INSTANCE = new HtmlFormatter(); //

    private HtmlFormatter() {}

    public static HtmlFormatter getInstance() {
        return INSTANCE;
    }

    public String getFormattedHtml(String price, RouteInfo route) {
        return generateEmail(price, route);
    }
}
