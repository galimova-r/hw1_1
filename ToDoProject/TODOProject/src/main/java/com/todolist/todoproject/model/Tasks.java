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
public class Tasks {
    private Integer id;
    private String name;
    private String description;
    private Date date_to_execute;
    private Integer is_done;
    private Integer id_user;
    private Date date_create;
    private Date date_update;
}
