package com.example.appex;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.IOException;


/**
 * Контроллер для добавления поездок.
 */
public class addRideController {
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


    /**
     * Открыть новую сцену.
     *
     * @param window имя файла сцены
     * @param button кнопка, вызвавшая событие
     */

    @FXML
    public static void openNewScene(String window, Button button) {
        button.getScene().getWindow().hide();//берем сцену и окно закрываем окошко

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(addRideController.class.getResource(window));
        //     позволяет указать место нужного файла
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(new Scene(root));//устанавливаем необходимое окно
        stage.show();
    }

}