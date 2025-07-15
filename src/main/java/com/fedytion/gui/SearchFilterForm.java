//package com.fedytion.gui;
//
//import com.fedytion.selenium.SeleniumLoginService;
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.*;
//import javafx.stage.Stage;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class SearchFilterForm extends Application {
//
//    @Override
//    public void start(Stage primaryStage) {
//        // === From Section ===
//        ComboBox<String> fromCountry = new ComboBox<>();
//        fromCountry.getItems().addAll("CH", "DE", "FR");
//        fromCountry.setValue("CH");
//
//        TextField fromCity = new TextField("1202 - Genève");
//        TextField fromRadius = new TextField("125");
//
//        HBox fromBox = new HBox(10, new Label("From:"), fromCountry, fromCity, fromRadius, new Label("km"));
//        fromBox.setAlignment(Pos.CENTER_LEFT);
//
//        // === To Section ===
//        RadioButton toAll = new RadioButton("All countries");
//        toAll.setSelected(true);
//        RadioButton toCountry = new RadioButton("Country selection");
//        RadioButton toRadius = new RadioButton("Radius");
//        ToggleGroup toGroup = new ToggleGroup();
//        toAll.setToggleGroup(toGroup);
//        toCountry.setToggleGroup(toGroup);
//        toRadius.setToggleGroup(toGroup);
//
//        HBox toBox = new HBox(10, new Label("To:"), toAll, toCountry, toRadius);
//        toBox.setAlignment(Pos.CENTER_LEFT);
//
//        // === Vehicle Requirements ===
//        ComboBox<String> bodyType = new ComboBox<>();
//        bodyType.getItems().addAll("Box", "Flatbed", "Curtain");
//        bodyType.setPromptText("Body types");
//
//        TextField length = new TextField("4.00");
//        TextField weight = new TextField("1.00");
//
//        HBox vehicleBox = new HBox(10, new Label("Vehicle:"), bodyType, new Label("Length:"), length, new Label("m"), new Label("Weight:"), weight, new Label("t"));
//        vehicleBox.setAlignment(Pos.CENTER_LEFT);
//
//        // === Loading Date ===
//        RadioButton indivDays = new RadioButton("Individual days");
//        RadioButton period = new RadioButton("Period");
//        period.setSelected(true);
//        ToggleGroup dateGroup = new ToggleGroup();
//        indivDays.setToggleGroup(dateGroup);
//        period.setToggleGroup(dateGroup);
//
//        DatePicker dateFrom = new DatePicker();
//        DatePicker dateTo = new DatePicker();
//
//        HBox dateBox = new HBox(10, new Label("Loading date:"), indivDays, period, dateFrom, new Label("-"), dateTo);
//        dateBox.setAlignment(Pos.CENTER_LEFT);
//
//        // === Company Section ===
//        CheckBox excludeList = new CheckBox("Apply exclusion list");
//
//        // === Buttons ===
//        Button searchBtn = new Button("Search");
//        Button resetBtn = new Button("Reset search filter");
//        CheckBox newOffers = new CheckBox("New offers only");
//        CheckBox hideDuplicates = new CheckBox("Hide duplicates");
//
//        HBox buttonBox = new HBox(10, searchBtn, resetBtn, newOffers, hideDuplicates);
//        buttonBox.setAlignment(Pos.CENTER_LEFT);
//
//        VBox layout = new VBox(15, fromBox, toBox, vehicleBox, dateBox, excludeList, buttonBox);
//        layout.setPadding(new Insets(20));
//
//        Scene scene = new Scene(layout, 1000, 300);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Search Filter");
//        primaryStage.show();
//        searchBtn.setOnAction(e -> {
//            FilterData filters = new FilterData();
//
//            filters.setFromCountry(fromCountry.getValue());
//            filters.setFromCity(fromCity.getText());
//            filters.setFromRadius(fromRadius.getText());
//
//            if (toAll.isSelected()) filters.setToMode("All");
//            else if (toCountry.isSelected()) filters.setToMode("Country");
//            else if (toRadius.isSelected()) filters.setToMode("Radius");
//
//            filters.setVehicleBodyType(bodyType.getValue());
//            filters.setVehicleLength(length.getText());
//            filters.setVehicleWeight(weight.getText());
//
//            filters.setDateFrom(dateFrom.getValue() != null ? dateFrom.getValue().toString() : "");
//            filters.setDateTo(dateTo.getValue() != null ? dateTo.getValue().toString() : "");
//
//            filters.setExcludeList(excludeList.isSelected());
//            filters.setOnlyNewOffers(newOffers.isSelected());
//            filters.setHideDuplicates(hideDuplicates.isSelected());
//
//            new Thread(() -> {
//                WebDriver driver = SeleniumLoginService.initDriver();
//                if (driver != null) {
//                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//                    MessagePageParser.applyFiltersAndSearch(driver, wait, filters);
//                }
//            }).start();
//        });
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    public FilterData getFilters() {
//        FilterData data = new FilterData();
//
//        data.setFromCountry(fromCountry.getValue());
//        data.setFromCity(fromCity.getText());
//        data.setFromRadius(fromRadius.getText());
//
//        if (toAll.isSelected()) data.setToMode("All");
//        else if (toCountry.isSelected()) data.setToMode("Country");
//        else if (toRadius.isSelected()) data.setToMode("Radius");
//
//        data.setVehicleBodyType(bodyType.getValue());
//        data.setVehicleLength(length.getText());
//        data.setVehicleWeight(weight.getText());
//
//        data.setDateFrom(dateFrom.getValue() != null ? dateFrom.getValue().toString() : "");
//        data.setDateTo(dateTo.getValue() != null ? dateTo.getValue().toString() : "");
//
//        data.setExcludeList(excludeList.isSelected());
//        data.setOnlyNewOffers(newOffers.isSelected());
//        data.setHideDuplicates(hideDuplicates.isSelected());
//
//        return data;
//    }
//
//
//}
