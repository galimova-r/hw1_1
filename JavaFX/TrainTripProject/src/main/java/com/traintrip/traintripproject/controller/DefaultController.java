package com.traintrip.traintripproject.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


/**
 * Контроллер по умолчанию.
 */
@Controller
public class DefaultController {

    /**
     * Возвращает ResponseEntity в зависимости от результата.
     *
     * @param result результат операции
     * @return ResponseEntity
     */
    protected ResponseEntity<Boolean> responseEntity(Boolean result) {
        HttpHeaders headers = new HttpHeaders();
        if (result) {
            return new ResponseEntity<>(headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * Устанавливает заголовки HttpHeaders.
     *
     * @return HttpHeaders
     */
    protected HttpHeaders setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
