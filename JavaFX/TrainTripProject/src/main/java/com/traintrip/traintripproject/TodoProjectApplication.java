package com.traintrip.traintripproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Основной класс приложения для запуска.
 */
@SpringBootApplication
public class TodoProjectApplication {
    /**
     * Метод main для запуска приложения.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SpringApplication.run(TodoProjectApplication.class, args);
    }

}
