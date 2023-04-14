package com.todolist.todoproject.dao;

import com.todolist.todoproject.api.RequestByLoginUsers;
import com.todolist.todoproject.components.DataBase;
import com.todolist.todoproject.model.Users;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.todolist.todoproject.config.constants.DB_TABLE_USERS;

@Service
public class UsersDAO {

    public Boolean createUser(Users user) {
        String dateCreate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String query = String.format("INSERT INTO %s (login, surname, name, patronymic, birthday, date_create) VALUES ('%s','%s','%s','%s','%s','%s');",
                DB_TABLE_USERS, user.getLogin(), user.getSurname(), user.getName(), user.getPatronymic(), user.getBirthday(), dateCreate);
        return DataBase.statementExecute(query);
    }

    public Boolean chooseParamToEditUser(Users users) {
        if (users == null) return false;
        if (users.getSurname() != null) editUser("surname", users.getSurname(), users.getId());
        if (users.getName() != null) editUser("name", users.getName(), users.getId());
        if (users.getPatronymic() != null) editUser("patronymic", users.getPatronymic(), users.getId());
        if (users.getBirthday() != null) editUser("birthday", String.valueOf(users.getBirthday()), users.getId());
        return true;
    }

    public Boolean editUser(String field, String information, Integer id) {
        String dateUpdate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        return DataBase.statementExecute(String.format("UPDATE %s SET %s='%s', date_update='%s' WHERE id=%d;",
                DB_TABLE_USERS, field, information, dateUpdate, id));
    }

    public List<Users> getUser(RequestByLoginUsers request) {
        String query = String.format("SELECT * FROM %s WHERE login='%s'", DB_TABLE_USERS, request.getLogin());
        List<Users> users = new ArrayList<>();
        if (DataBase.statementExecuteUsers(query, users)) return users;
        else return new ArrayList<>();
    }
}
