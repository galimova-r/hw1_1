package com.todolist.todoproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categories {
    private Integer id;
    private String category;
    private Date date_create;
    private Date date_update;
}
