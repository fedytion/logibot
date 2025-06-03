package com.fedytion.parser;

public record ParsedInfo(
        Contacts contacts,
        RouteInfo routeInfo,
        Price originalPrice
) {
}