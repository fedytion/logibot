package com.fedytion.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class RouteParser {

    public RouteInfo getRoute(Document document) {
        Element fromCity = document.select("span[data-testid=LoadingPlacesView/loadingPlaceCity_0]").getFirst();
        Element toCity = document.select("span[data-testid=LoadingPlacesView/loadingPlaceCity_1]").getFirst();


        String fromCityIndex = fromCity.text().substring(2, 7);
        String toCityIndex = toCity.text().substring(2, 7);
        String fromCityName = fromCity.text().substring(8);
        String toCityName = toCity.text().substring(8);

        return new RouteInfo(fromCityName, toCityName, fromCityIndex, toCityIndex);
    }
}
