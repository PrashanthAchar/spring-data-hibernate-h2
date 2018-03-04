package com.mpa.data.controller;

import com.mpa.data.domain.User;
import com.mpa.data.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> userDetails() {

        List<User> userDetails = userRepository.findAll();
        return new ResponseEntity<List<User>>(userDetails, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> user(@PathVariable Integer userId) {

        User userDetails = userRepository.findOne(userId);
        return new ResponseEntity<User>(userDetails, HttpStatus.OK);
    }
}
