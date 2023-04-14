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
public class Users {
    private Integer id;
    private String login;
    private String surname;
    private String name;
    private String patronymic;
    private Date birthday;
    private Date date_create;
    private Date date_update;
}
