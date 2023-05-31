package com.traintrip.traintripproject.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Класс, представляющий запрос по имени поезда.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestByNameTrain {
    private String name;
}
