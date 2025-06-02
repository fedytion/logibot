package com.fedytion.postman;

import com.fedytion.config.Constants;
import com.fedytion.parser.RouteInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HtmlTemplateEngine {
    public static String generateEmail(String price, RouteInfo route, String name) {
        try {
            return Files.readString(Paths.get(Constants.EMAIL_TEMPLATE_PATH))
                    .replace("{{price}}", String.valueOf(price))
                    .replace("{{route}}", route.fromCity() + " → " + route.toCity())
                    .replace("{{name}}", name);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read template", e);
        }
    }
}
