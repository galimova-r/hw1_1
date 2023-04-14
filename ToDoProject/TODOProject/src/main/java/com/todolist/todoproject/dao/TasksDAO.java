package com.todolist.todoproject.dao;

import com.todolist.todoproject.api.RequestByIdInTask;
import com.todolist.todoproject.api.RequestByIdUserInTasks;
import com.todolist.todoproject.components.DataBase;
import com.todolist.todoproject.model.Tasks;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.todolist.todoproject.config.constants.DB_TABLE_TASKS;

@Service
public class TasksDAO {
    public Boolean createTask(Tasks task) {
        String dateCreate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String query = String.format("INSERT INTO %s (name, description, date_to_execute, is_done, id_user, date_create) VALUES ('%s','%s','%s','%s','%s','%s');",
                DB_TABLE_TASKS, task.getName(), task.getDescription(), task.getDate_to_execute(), task.getIs_done(), task.getId_user(), dateCreate);
        return DataBase.statementExecute(query);
    }

    public Boolean chooseParamToEditTask(Tasks task) {
        if (task == null) return false;
        if (task.getName() != null) editTask("name", task.getName(), task.getId());
        if (task.getDescription() != null) editTask("description", task.getDescription(), task.getId());
        if (task.getDate_to_execute() != null) editTask("date_to_execute", String.valueOf(task.getDate_to_execute()), task.getId());
        if (task.getIs_done() != null) editTask("is_done", String.valueOf(task.getIs_done()), task.getId());
        return true;
    }

    public Boolean editTask(String field, String information, Integer id) {
        String dateUpdate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        return DataBase.statementExecute(String.format("UPDATE %s SET %s='%s', date_update='%s' WHERE id=%d;",
                DB_TABLE_TASKS, field, information, dateUpdate, id));
    }

    public List<Tasks> getTasks(RequestByIdUserInTasks request) {
        String query = String.format("SELECT * FROM %s WHERE id_user='%d'", DB_TABLE_TASKS, request.getId_user());
        List<Tasks> tasks = new ArrayList<>();
        if (DataBase.statementExecuteTasks(query, tasks)) return tasks;
        else return new ArrayList<>();
    }

    public Boolean deleteTasks(RequestByIdInTask request) {
        return DataBase.statementExecute(String.format("DELETE FROM %s WHERE id='%s'", DB_TABLE_TASKS, request.getId()));
    }
}
