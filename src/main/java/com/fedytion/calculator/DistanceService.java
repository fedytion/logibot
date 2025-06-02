package com.fedytion.calculator;

import java.io.IOException;

public interface DistanceService {
    double getDistance(String from, String to) throws IOException;
}
