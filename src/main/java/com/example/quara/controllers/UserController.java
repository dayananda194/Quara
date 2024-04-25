package com.example.quara.controllers;

import com.example.quara.models.User;
import com.example.quara.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/{users}")
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user) {

       if(userService.findById(user.getId()).isEmpty()) { // if the user with the given id not present then only we will save the data
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
       }

        return new ResponseEntity<>("User is Already Present with ID " + user.getId(), HttpStatus.CONFLICT);
    }

}
