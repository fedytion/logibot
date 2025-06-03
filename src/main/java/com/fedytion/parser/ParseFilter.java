package com.fedytion.parser;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ParseFilter {

    private final Document doc;

    public ParseFilter(Document doc) {
        this.doc = doc;
    }

    public boolean shouldSkip() {
        return checkFreightDescription(doc.select("a.main"))
                && checkTypeOfGoods(doc.select("a[href]"))
                && checkAdditionalInformation(doc.select("a[href]"))
                && checkVehicleType(doc.select("a[href]"))
                && checkBodyType(doc.select("a[href]"));
    }

    private boolean checkFreightDescription(Elements elements) {
//        <span data-testid="FreightDescriptionView/freightLength">2.4 m</span>
//        <span data-testid="FreightDescriptionView/freightWeight">0.49 t</span>
        return false;
    }

    private boolean checkTypeOfGoods(Elements elements) {
//        <span class="Ellipsis_root__yfxcLh" data-testid="FreightDescriptionView/typeOfGoods">-</span>
        return false;
    }

    private boolean checkAdditionalInformation(Elements elements) {
//        <span data-testid="FreightDescriptionView/additionalInformation">Part load</span>
        return false;
    }

    private boolean checkVehicleType(Elements elements) {
//        <span data-testid="VehicleRequirementsView/vehicleType">Articulated truck, Rigid truck</span>
        return false;
    }

    private boolean checkBodyType(Elements elements) {
//        <span data-testid="VehicleRequirementsView/vehicleBody">Curtain</span>
        return false;
    }










}
