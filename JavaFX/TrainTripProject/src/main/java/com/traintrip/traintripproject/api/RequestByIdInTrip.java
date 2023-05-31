package com.traintrip.traintripproject.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Класс, представляющий запрос по идентификатору в поездке.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestByIdInTrip {
    private String id;
}
