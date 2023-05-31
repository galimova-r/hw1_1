package com.example.appex;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;

/**
 * Контроллер для всех поездок.
 */
public class allRideController {

    @FXML
    private Button allRide;
    @FXML
    private Button addRide;
    @FXML
    private Button addTrain;
    @FXML
    private Button allTrain;

    /**
     * Инициализация контроллера.
     */

    @FXML
    void initialize() {
        if (allRide != null) {
            allRide.setCursor(Cursor.HAND);
        }


        allRide.setCursor(Cursor.HAND);
        allRide.setPickOnBounds(true);
        allRide.setOnMouseClicked((e) -> {
            addRideController.openNewScene("allRide.fxml", allRide);
        });

        addRide.setCursor(Cursor.HAND);
        addRide.setPickOnBounds(true);
        addRide.setOnMouseClicked((e) -> {
            addRideController.openNewScene("addRide.fxml", allRide);
        });

        addTrain.setCursor(Cursor.HAND);
        addTrain.setPickOnBounds(true);
        addTrain.setOnMouseClicked((e) -> {
            addRideController.openNewScene("addTrain.fxml", allRide);
        });

        allTrain.setCursor(Cursor.HAND);
        allTrain.setPickOnBounds(true);
        allTrain.setOnMouseClicked((e) -> {
            addRideController.openNewScene("allTrain.fxml", allRide);
        });


    }



}
