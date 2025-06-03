package com.fedytion.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class PriceParser {

    public Price getPrice(Document document) {
        Element price = document.select("span[data-testid=FreightPriceView/price]").getFirst();
        String priceText = price.text();

        if (priceText.equals("Price: -")) {
            return new Price("0");
        } else {
            return new Price(priceText);
        }
    }
}
