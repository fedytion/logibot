package com.fedytion.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ContactsParser {

    public Contacts getContacts(Document document) {
        Element email = document.select("a[data-testid=CustomerDetails/email]").getFirst();

        Element phoneNumber = document.select("a[data-testid=EV_contactperson-phone]").getFirst();
        return new Contacts(email.text(), phoneNumber.text());
    }
}
