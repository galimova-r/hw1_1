package com.todolist.todoproject.controller;

import com.todolist.todoproject.api.RequestByIdInTask;
import com.todolist.todoproject.api.RequestByIdUserInTasks;
import com.todolist.todoproject.dao.CategoriesDAO;
import com.todolist.todoproject.dao.TasksDAO;
import com.todolist.todoproject.model.Categories;
import com.todolist.todoproject.model.Tasks;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
@RestController
@RequestMapping(value = "/task/")
public class TasksController extends DefaultController {
    private TasksDAO tasksDAO;
    private CategoriesDAO categoriesDAO;

    @RequestMapping(value = "create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createTask(@RequestBody Tasks task) {
        Boolean result = tasksDAO.createTask(task);
        return responseEntity(result);
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> editTask(@RequestBody Tasks task) {
        Boolean result = tasksDAO.chooseParamToEditTask(task);
        return responseEntity(result);
    }

    @RequestMapping(value = "get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tasks>> editTask(@RequestBody RequestByIdUserInTasks request) {
        List<Tasks> tasks = tasksDAO.getTasks(request);
        HttpHeaders headers = setHeaders();
        if (!tasks.equals(new ArrayList<Tasks>())) {
            return new ResponseEntity<>(tasks, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteTask(@RequestBody RequestByIdInTask request) {
        Boolean result = tasksDAO.deleteTasks(request);
        return responseEntity(result);
    }

    @RequestMapping(value = "category/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createTask(@RequestBody Categories category) {
        Boolean result = categoriesDAO.createCategory(category);
        return responseEntity(result);
    }

    @RequestMapping(value = "category/edit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> editTask(@RequestBody Categories category) {
        Boolean result = categoriesDAO.editCategory(category);
        return responseEntity(result);
    }
}
