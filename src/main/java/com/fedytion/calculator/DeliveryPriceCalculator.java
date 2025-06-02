package com.fedytion.calculator;

import java.io.IOException;

public class DeliveryPriceCalculator {
    private static final double COEFFICIENT = 0.6;
    private final DistanceService distanceService;

    public DeliveryPriceCalculator(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    public String calculatePrice(String from, String to) throws IOException {
        double distance = distanceService.getDistance(from, to);
        return (int) (distance * COEFFICIENT) + "";
    }
}
