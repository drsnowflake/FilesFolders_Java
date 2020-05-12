package com.codeclan.example.filesfolders.controllers;

import com.codeclan.example.filesfolders.models.User;
import com.codeclan.example.filesfolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> putUser(@PathVariable Long id, @RequestBody User newUser){
        userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    userRepository.save(user);
                    return(user);
                });
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
