package com.todolist.todoproject.config;

public class constants {
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "12345";
    public static final String DB_NAME = "tododb";
    public static final String DB_PATH = "jdbc:mysql://localhost:3306/" + DB_NAME;
    public static final String DB_TABLE_USERS = DB_NAME + ".users";
    public static final String DB_TABLE_CATEGORIES = DB_NAME + ".categories";
    public static final String DB_TABLE_TASKS = DB_NAME + ".tasks";
    public static final String DB_TABLE_TASKS_HAS_CATEGORIES = DB_NAME + ".tasks_has_categories";
}
