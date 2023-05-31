package com.traintrip.traintripproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    private Integer id;
    private String where_from;
    private String where;
    private Integer id_train;
    private Date date_start;
    private Date date_end;
    private Integer price;

}
