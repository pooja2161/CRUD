package com.example.FirstTask.controller;

import com.example.FirstTask.entity.User;
import com.example.FirstTask.service.UserService;
import com.example.response.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<StatusResponse<User>> createUser(@RequestBody User user) {
        StatusResponse response =new StatusResponse();
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<StatusResponse<User>> getAllUsers() {
        StatusResponse response = new StatusResponse();

        List<User> users = userService.getAllUsers();
        if(users.size() <= 0){
            response.setStatusMessage("No data found");
            response.setStatusCode(400);
            response.setSuccess(true);

        }else {
            response.setData(users);
            response.setTotalCount((long) users.size());
            response.setSuccess(true);
            response.setStatusMessage("User Found");
            response.setStatusCode(HttpStatus.OK.value());
        };
        // // StatusResponse<User> response = new StatusResponse<>(HttpStatus.OK.value(), "Users retrieved successfully", true, (long) users.size(), null, users);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusResponse<User>> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        StatusResponse response =new StatusResponse();

        if (user.isPresent()) {
            // // StatusResponse<User> response = new StatusResponse<>(HttpStatus.OK.value(), "User found", true, null, null, List.of(user.get()));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            // // StatusResponse<User> response = new StatusResponse<>(HttpStatus.NOT_FOUND.value(), "User not found", false, null, null, null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusResponse<User>> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        StatusResponse response =new StatusResponse();

        if (updatedUser != null) {
            // // StatusResponse<User> response = new StatusResponse<>(HttpStatus.OK.value(), "User updated successfully", true, null, null, List.of(updatedUser));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            // // StatusResponse<User> response = new StatusResponse<>(HttpStatus.NOT_FOUND.value(), "User not found", false, null, null, null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StatusResponse<Void>> deleteUser(@PathVariable Long id) {
        StatusResponse response =new StatusResponse();
        userService.deleteUser(id);
//        StatusResponse<Void> response = new StatusResponse<>(HttpStatus.NO_CONTENT.value(), "User deleted successfully", true, null, null, null);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}


