package com.VijayProject.FullStack_Backend.controller;


import com.VijayProject.FullStack_Backend.exception.UserNotFoundException;
import com.VijayProject.FullStack_Backend.model.User;
import com.VijayProject.FullStack_Backend.repository.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin("http://localhost:3000/")

public class UserController {


    @Autowired
    private UserRepositary userRepositary;


    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepositary.save(newUser);
    }

    @GetMapping("/users")
    List<User>getAllUsers(){
        return  userRepositary.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepositary.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return userRepositary.findById(id)
                .map(user ->{
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepositary.save(user);
                }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepositary.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepositary.deleteById(id);
        return "user with id"+id+"has been delete success. ";
    }

}

