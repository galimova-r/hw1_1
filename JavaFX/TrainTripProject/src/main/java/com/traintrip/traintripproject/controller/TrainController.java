package com.traintrip.traintripproject.controller;

import com.traintrip.traintripproject.api.RequestByNameTrain;
import com.traintrip.traintripproject.dao.TrainDAO;
import com.traintrip.traintripproject.model.Train;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
/**
 * Контроллер для работы с поездами.
 */
@AllArgsConstructor
@Controller
@RestController
@RequestMapping(value = "/train/")
public class TrainController extends DefaultController {
    private TrainDAO trainDAO;
    /**
     * Создать новый поезд.
     *
     * @param train информация о поезде
     * @return ResponseEntity<Boolean>
     */
    @RequestMapping(value = "create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createTrain(@RequestBody Train train) {
        Boolean result = trainDAO.createTrain(train);
        return responseEntity(result);
    }
    /**
     * Редактировать информацию о поезде.
     *
     * @param train информация о поезде
     * @return ResponseEntity<Boolean>
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> editTrain(@RequestBody Train train) {
        Boolean result = trainDAO.chooseParamToEditTrain(train);
        return responseEntity(result);
    }
    /**
     * Получить список поездов по заданным критериям.
     *
     * @param request запрос для фильтрации поездов
     * @return ResponseEntity<List<Train>>
     */
    @RequestMapping(value = "get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Train>> editTrain(@RequestBody RequestByNameTrain request) {
        List<Train> trains = trainDAO.getTrain(request);
        HttpHeaders headers = setHeaders();
        if (!trains.equals(new ArrayList<Train>())) {
            return new ResponseEntity<>(trains, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
