package com.traintrip.traintripproject.dao;

import com.traintrip.traintripproject.api.RequestByIdTrainInTrip;
import com.traintrip.traintripproject.components.DataBase;
import com.traintrip.traintripproject.model.Trip;
import com.traintrip.traintripproject.config.constants;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/**
 * Класс для работы с данными о поездках в базе данных.
 */
@Service
public class TripDAO {
    /**
     * Создать новую поездку.
     *
     * @param trip информация о поездке
     * @return true, если создание успешно, иначе false
     */
    public Boolean createTrip(Trip trip) {
        String date_end = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String query = String.format("INSERT INTO %s (name, where, date_start, is_done, id_user, date_end) VALUES ('%s','%s','%s','%s','%s','%s');",
                constants.DB_TABLE_TRIPS, trip.getWhere_from(), trip.getWhere(), trip.getDate_start(), trip.getWhere_from(), trip.getId_train(), date_end);
        return DataBase.statementExecute(query);
    }
    /**
     * Редактировать информацию о поездке.
     *
     * @param trip информация о поездке
     * @return true, если редактирование успешно, иначе false
     */
    public Boolean chooseParamToEditTrip(Trip trip) {
        if (trip == null) return false;
        if (trip.getWhere_from() != null) editTrip("name", trip.getWhere_from(), trip.getId());
        if (trip.getWhere() != null) editTrip("where", trip.getWhere(), trip.getId());
        if (trip.getDate_start() != null) editTrip("date_start", String.valueOf(trip.getDate_start()), trip.getId());
        if (trip.getWhere_from() != null) editTrip("where_from", String.valueOf(trip.getWhere_from()), trip.getId());
        return true;
    }
    /**
     * Редактировать информацию о поездке в заданном поле.
     *
     * @param field       поле, которое нужно отредактировать
     * @param information новое значение
     * @param id          идентификатор поездки
     * @return true, если редактирование успешно, иначе false
     */
    public Boolean editTrip(String field, String information, Integer id) {
        return DataBase.statementExecute(String.format("UPDATE %s SET %s='%s', WHERE id=%d;",
                constants.DB_TABLE_TRIPS, field, information, id));
    }
    /**
     * Получить список поездок по заданному идентификатору поезда.
     *
     * @param request запрос с идентификатором поезда
     * @return список поездок
     */
    public List<Trip> getTrip(RequestByIdTrainInTrip request) {
        String query = String.format("SELECT * FROM %s WHERE id_train='%d'", constants.DB_TABLE_TRIPS, request.getId_train());
        List<Trip> trips = new ArrayList<>();
        if (DataBase.statementExecuteTrip(query, trips)) return trips;
        else return new ArrayList<>();
    }
    /**
     * Удалить поездку по заданному идентификатору поезда.
     *
     * @param request запрос с идентификатором поезда
     * @return true, если удаление успешно, иначе false
     */
    public Boolean deleteTrip(RequestByIdTrainInTrip request) {
        return DataBase.statementExecute(String.format("DELETE FROM %s WHERE id='%s'", constants.DB_TABLE_TRIPS, request.getId_train()));
    }
}
