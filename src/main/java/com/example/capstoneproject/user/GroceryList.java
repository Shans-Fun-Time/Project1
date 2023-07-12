package com.example.capstoneproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryList {
    @Autowired private UserProfiles profiles;

    public List<User> listEveryThing(){
        return (List<User>) profiles.findAll();
    }
}