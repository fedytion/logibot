package com.fedytion.parser;

import org.jsoup.nodes.Document;

public class HtmlParser {
    private final Document doc;

    public HtmlParser(Document doc) {
        this.doc = doc;
    }

    public ParsedInfo parseHtml() {
        ContactsParser contactsParser = new ContactsParser();
        RouteParser routeParser = new RouteParser();
        Contacts contacts = contactsParser.getContacts(doc);
        RouteInfo routeInfo = routeParser.getRoute(doc);
        PriceParser priceParser = new PriceParser();
        Price price = priceParser.getPrice(doc);

        return new ParsedInfo(contacts, routeInfo, price);
    }
}
