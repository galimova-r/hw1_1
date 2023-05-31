package com.traintrip.traintripproject.dao;

import com.traintrip.traintripproject.api.RequestByNameTrain;
import com.traintrip.traintripproject.components.DataBase;
import com.traintrip.traintripproject.model.Train;
import com.traintrip.traintripproject.config.constants;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс для работы с данными о поездах в базе данных.
 */
@Service
public class TrainDAO {
    /**
     * Создать новый поезд.
     *
     * @param train информация о поезде
     * @return true, если создание успешно, иначе false
     */
    public Boolean createTrain(Train train) {
        String query = String.format("INSERT INTO %s (name, type, number_v, number_sit) VALUES ('%s','%s','%s','%s');",
                constants.DB_TABLE_TRAINS, train.getName(), train.getType(), train.getNumber_v(), train.getNumber_sit());
        return DataBase.statementExecute(query);
    }
    /**
     * Редактировать информацию о поезде.
     *
     * @param train информация о поезде
     * @return true, если редактирование успешно, иначе false
     */
    public Boolean chooseParamToEditTrain(Train train) {
        if (train == null) return false;
        if (train.getType() != null) editTrain("type", train.getType(), train.getId());
        if (train.getName() != null) editTrain("name", train.getName(), train.getId());
        if (train.getNumber_v() != null) editTrain("number_v", train.getNumber_v(), train.getId());
        if (train.getNumber_sit() != null) editTrain("number_sit", train.getNumber_sit(), train.getId());
        return true;
    }
    /**
     * Редактировать информацию о поезде в заданном поле.
     *
     * @param field       поле, которое нужно отредактировать
     * @param information новое значение
     * @param id          идентификатор поезда
     * @return true, если редактирование успешно, иначе false
     */
    public Boolean editTrain(String field, String information, Integer id) {

        return DataBase.statementExecute(String.format("UPDATE %s SET %s='%s', WHERE id=%d;",
                constants.DB_TABLE_TRAINS, field, information, id));
    }
    /**
     * Получить список поездов по заданному имени.
     *
     * @param request запрос с именем поезда
     * @return список поездов
     */
    public List<Train> getTrain(RequestByNameTrain request) {
        String query = String.format("SELECT * FROM %s WHERE name='%s'", constants.DB_TABLE_TRAINS, request.getName());
        List<Train> trains = new ArrayList<>();
        if (DataBase.statementExecuteTrain(query, trains)) return trains;
        else return new ArrayList<>();
    }
}
