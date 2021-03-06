/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.websag11.divinacomedia.repositories;

import com.websag11.divinacomedia.models.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.websag11.divinacomedia.repositories.crud.UserCrudRepositoryx;

/**
 *
 * @author Gerox
 */
@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepositoryx repository;

    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }
    
    public Optional<User>  getById(Integer id){
        return repository.findById(id);
    }
    
    public Optional<User> getUserByName(String name){
        return repository.findByName(name);
    }
    
    public Optional<User> getUserByEmail(String email){
        return repository.findByEmail(email);
    }
    
    public List<User>  getUsserByNameOrByEmail(String name, String email){
        return repository.findByNameOrEmail(name, email);
    }
    
    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }
    
    public User save(User user){
        return repository.save(user);
    }
}
