package com.traintrip.traintripproject.components;

import com.traintrip.traintripproject.model.Trip;
import com.traintrip.traintripproject.model.Train;
import com.traintrip.traintripproject.config.constants;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Компонент для работы с базой данных.
 */
@Component
public class DataBase {
    private static final Logger log = Logger.getLogger(DataBase.class.getName());
    /**
     * Выполняет SQL-запрос для обновления данных в базе данных.
     *
     * @param query SQL-запрос
     * @return true, если запрос был выполнен успешно, в противном случае - false
     */
    public static Boolean statementExecute(String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(constants.DB_PATH, constants.DB_USER, constants.DB_PASSWORD)) {
                PreparedStatement statement = conn.prepareStatement(query);
                statement.execute();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            log.log(Level.WARNING, "Запрос не был выполнен.\nПричина: ", ex.fillInStackTrace());
            return false;
        }
        return true;
    }
    /**
     * Выполняет SQL-запрос для получения данных о поездах из базы данных.
     *
     * @param query  SQL-запрос
     * @param trains список, в который будут добавлены полученные поезда
     * @return true, если запрос был выполнен успешно, в противном случае - false
     */
    public static Boolean statementExecuteTrain(String query, List<Train> trains) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(constants.DB_PATH, constants.DB_USER, constants.DB_PASSWORD)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    trains.add(new Train(resultSet.getInt("id"), resultSet.getString("name"),
                            resultSet.getString("type"), resultSet.getString("number_v"),
                            resultSet.getString("number_sit")));
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            log.log(Level.WARNING, "Запрос не был выполнен.\nПричина: ", ex.fillInStackTrace());
            return false;
        }
        return true;
    }
    /**
     * Выполняет SQL-запрос для получения данных о поездках из базы данных.
     *
     * @param query SQL-запрос
     * @param trips список, в который будут добавлены полученные поездки
     * @return true, если запрос был выполнен успешно, в противном случае - false
     */
    public static boolean statementExecuteTrip(String query, List<Trip> trips) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(constants.DB_PATH, constants.DB_USER, constants.DB_PASSWORD)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    trips.add(new Trip(resultSet.getInt("id"), resultSet.getString("where_from"),
                            resultSet.getString("where"), resultSet.getInt("id_train"),
                            resultSet.getDate("date_start"), resultSet.getDate("date_end"),
                            resultSet.getInt("price")));
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            log.log(Level.WARNING, "Запрос не был выполнен.\nПричина: ", ex.fillInStackTrace());
            return false;
        }
        return true;
    }
}
