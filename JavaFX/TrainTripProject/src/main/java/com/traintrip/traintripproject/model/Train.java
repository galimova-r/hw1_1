package com.traintrip.traintripproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Train {
    private Integer id;
    private String name;
    private String type;
    private String number_v;
    private String number_sit;

}
