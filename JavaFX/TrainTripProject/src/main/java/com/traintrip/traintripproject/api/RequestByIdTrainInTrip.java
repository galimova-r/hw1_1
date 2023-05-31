package com.traintrip.traintripproject.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Класс, представляющий запрос по идентификатору поезда в поездке.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestByIdTrainInTrip {
    private Integer id_train;

}
