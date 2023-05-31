package com.traintrip.traintripproject.config;
/**
 * Класс, содержащий константы для конфигурации проекта.
 */
public class constants {
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "12345";
    public static final String DB_NAME = "trains";
    public static final String DB_PATH = "jdbc:mysql://localhost:3306/" + DB_NAME;
    public static final String DB_TABLE_TRAINS = DB_NAME + ".trains";
    public static final String DB_TABLE_TRIPS = DB_NAME + ".trips";

}
