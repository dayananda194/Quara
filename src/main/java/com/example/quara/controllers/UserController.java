package com.example.quara.controllers;

import com.example.quara.models.User;
import com.example.quara.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    // expects id , username , dob
    public ResponseEntity<?> addUser(@RequestBody User user) {

            return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);

    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable long id) {

        Optional<User> user = userService.findById(id);
        if(user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("User with the ID "+id+" Not Found ", HttpStatus.NOT_FOUND);


    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<User> userList  =  userService.findAll();
        if(!userList.isEmpty()) {
            return new ResponseEntity<>(userList,HttpStatus.OK);
        }
        return new ResponseEntity<>("No Users are there ", HttpStatus.NOT_FOUND);
    }

}
