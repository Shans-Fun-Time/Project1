package com.example.capstoneproject.groceries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class GroceryService {
    @Autowired
    private GroceryRepository groceries;
    public List<Groceries> listEveryThing(){
        return (List<Groceries>) groceries.findAll();
    }

    public void save(Groceries g1) {
        groceries.save(g1);
    }

    public Groceries get(Integer id) throws GroceryNotFoundException {
        Optional<Groceries> byId = groceries.findById(id);
        if (byId.isPresent()){
            return  byId.get();
        }
        throw new GroceryNotFoundException("Grocery ID not in list yet: " + id);
    }

    public void takeOffGrocery(Integer id) throws GroceryNotFoundException {
        Integer c = groceries.countById(id);
         if (c == null || c ==0)
             throw new GroceryNotFoundException("Grocery ID not in list yet: " + id);
        groceries.deleteById(id);
    }
}