package com.example.appex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Главный класс приложения.
 */
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addRide.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Поезда");
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Метод для запуска приложения.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        launch();
    }
}