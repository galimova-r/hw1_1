package com.todolist.todoproject.components;

import com.todolist.todoproject.model.Tasks;
import com.todolist.todoproject.model.Users;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.todolist.todoproject.config.constants.*;

@Component
public class DataBase {
    private static final Logger log = Logger.getLogger(DataBase.class.getName());

    public static Boolean statementExecute(String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(DB_PATH, DB_USER, DB_PASSWORD)) {
                PreparedStatement statement = conn.prepareStatement(query);
                statement.execute();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            log.log(Level.WARNING, "Запрос не был выполнен.\nПричина: ", ex.fillInStackTrace());
            return false;
        }
        return true;
    }

    public static Boolean statementExecuteUsers(String query, List<Users> users) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(DB_PATH, DB_USER, DB_PASSWORD)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    users.add(new Users(resultSet.getInt("id"), resultSet.getString("login"),
                            resultSet.getString("surname"), resultSet.getString("name"),
                            resultSet.getString("patronymic"), resultSet.getDate("birthday"),
                            resultSet.getDate("date_create"), resultSet.getDate("date_update")));
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            log.log(Level.WARNING, "Запрос не был выполнен.\nПричина: ", ex.fillInStackTrace());
            return false;
        }
        return true;
    }

    public static boolean statementExecuteTasks(String query, List<Tasks> tasks) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(DB_PATH, DB_USER, DB_PASSWORD)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    tasks.add(new Tasks(resultSet.getInt("id"), resultSet.getString("name"),
                            resultSet.getString("description"), resultSet.getDate("date_to_execute"),
                            resultSet.getInt("is_done"), resultSet.getInt("id_user"),
                            resultSet.getDate("date_create"), resultSet.getDate("date_update")));
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            log.log(Level.WARNING, "Запрос не был выполнен.\nПричина: ", ex.fillInStackTrace());
            return false;
        }
        return true;
    }
}
