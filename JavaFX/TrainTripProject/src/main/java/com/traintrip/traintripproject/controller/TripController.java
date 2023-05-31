package com.traintrip.traintripproject.controller;


import com.traintrip.traintripproject.api.RequestByIdTrainInTrip;
import com.traintrip.traintripproject.dao.TripDAO;
import com.traintrip.traintripproject.model.Trip;
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
 * Контроллер для работы с поездками.
 */
@AllArgsConstructor
@Controller
@RestController
@RequestMapping(value = "/trip/")
public class TripController extends DefaultController {
    private TripDAO tripDAO;

    /**
     * Создать новую поездку.
     *
     * @param trip информация о поездке
     * @return ResponseEntity<Boolean>
     */
    @RequestMapping(value = "create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createTrip(@RequestBody Trip trip) {
        Boolean result = tripDAO.createTrip(trip);
        return responseEntity(result);
    }
    /**
     * Редактировать информацию о поездке.
     *
     * @param trip информация о поездке
     * @return ResponseEntity<Boolean>
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> editTrip(@RequestBody Trip trip) {
        Boolean result = tripDAO.chooseParamToEditTrip(trip);
        return responseEntity(result);
    }
    /**
     * Получить список поездок по заданному идентификатору поезда.
     *
     * @param request запрос с идентификатором поезда
     * @return ResponseEntity<List<Trip>>
     */
    @RequestMapping(value = "get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trip>> editTrip(@RequestBody RequestByIdTrainInTrip request) {
        List<Trip> trips = tripDAO.getTrip(request);
        HttpHeaders headers = setHeaders();
        if (!trips.equals(new ArrayList<Trip>())) {
            return new ResponseEntity<>(trips, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * Удалить поездку.
     *
     * @param request запрос с идентификатором поездки
     * @return ResponseEntity<Boolean>
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteTrip(@RequestBody RequestByIdTrainInTrip request) {
        Boolean result = tripDAO.deleteTrip(request);
        return responseEntity(result);
    }

}
