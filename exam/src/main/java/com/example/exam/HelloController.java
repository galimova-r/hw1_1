package com.example.exam;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField mainText;


    @FXML
    protected void onHelloButtonClick() {

        String[] words = mainText.getText().split(" ");//превращаем в список
        Map<String, Integer> counts = new HashMap<>();//сччитаем слова
        for(String word :words) {
            if (counts.containsKey(word)) {
                counts.put(word, counts.get(word) + 1);
            } else {
                counts.put(word, 1);
            }
        }
        for (String word :counts.keySet()){//выводим слова для пользователя
            welcomeText.setText(word + ": " + counts.get(word));
        }






    }
}
