package com.fedytion.gui;

public class FilterData {
    private String fromCountry;
    private String fromCity;
    private String fromRadius;

    private String toMode; // All, Country, Radius

    private String vehicleBodyType;
    private String vehicleLength;
    private String vehicleWeight;

    private String dateFrom;
    private String dateTo;

    private boolean excludeList;
    private boolean onlyNewOffers;
    private boolean hideDuplicates;

    public String getFromCountry() {
        return fromCountry;
    }

    public void setFromCountry(String fromCountry) {
        this.fromCountry = fromCountry;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getFromRadius() {
        return fromRadius;
    }

    public void setFromRadius(String fromRadius) {
        this.fromRadius = fromRadius;
    }

    public String getToMode() {
        return toMode;
    }

    public void setToMode(String toMode) {
        this.toMode = toMode;
    }

    public String getVehicleBodyType() {
        return vehicleBodyType;
    }

    public void setVehicleBodyType(String vehicleBodyType) {
        this.vehicleBodyType = vehicleBodyType;
    }

    public String getVehicleLength() {
        return vehicleLength;
    }

    public void setVehicleLength(String vehicleLength) {
        this.vehicleLength = vehicleLength;
    }

    public String getVehicleWeight() {
        return vehicleWeight;
    }

    public void setVehicleWeight(String vehicleWeight) {
        this.vehicleWeight = vehicleWeight;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public boolean isExcludeList() {
        return excludeList;
    }

    public void setExcludeList(boolean excludeList) {
        this.excludeList = excludeList;
    }

    public boolean isOnlyNewOffers() {
        return onlyNewOffers;
    }

    public void setOnlyNewOffers(boolean onlyNewOffers) {
        this.onlyNewOffers = onlyNewOffers;
    }

    public boolean isHideDuplicates() {
        return hideDuplicates;
    }

    public void setHideDuplicates(boolean hideDuplicates) {
        this.hideDuplicates = hideDuplicates;
    }
}
