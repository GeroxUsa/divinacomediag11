/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.websag11.divinacomedia.controllers;

import com.websag11.divinacomedia.models.User;
import com.websag11.divinacomedia.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gerox
 */
@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    private UserService service;
    
    @GetMapping("/all")
    public List<User> getUsers(){return service.getAll();}
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){ return service.save(user);}
    
    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email") String email){
        return service.getUserByEmail(email);
    }
    
    @GetMapping("/{email}/{password}")
     public User authUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return service.getUserByEmailAndPassword(email, password);
    }
}
