package com.todolist.todoproject.controller;

import com.todolist.todoproject.api.RequestByLoginUsers;
import com.todolist.todoproject.dao.UsersDAO;
import com.todolist.todoproject.model.Users;
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
@RequestMapping(value = "/user/")
public class UsersController extends DefaultController {
    private UsersDAO userDAO;

    @RequestMapping(value = "create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createUser(@RequestBody Users user) {
        Boolean result = userDAO.createUser(user);
        return responseEntity(result);
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> editUser(@RequestBody Users users) {
        Boolean result = userDAO.chooseParamToEditUser(users);
        return responseEntity(result);
    }

    @RequestMapping(value = "get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Users>> editUser(@RequestBody RequestByLoginUsers request) {
        List<Users> users = userDAO.getUser(request);
        HttpHeaders headers = setHeaders();
        if (!users.equals(new ArrayList<Users>())) {
            return new ResponseEntity<>(users, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
