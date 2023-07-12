package com.example.capstoneproject.groceries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class GroceryService {
    @Autowired
    private GroceryRepository groceries;
    public List<Groceries> listEveryThing(){
        return (List<Groceries>) groceries.findAll();
    }
}