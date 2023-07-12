package com.example.capstoneproject.groceries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GroceryController {
    @Autowired
    private GroceryService grocery;

    @GetMapping("/GroceryList.html")
    public String showGroceryList(Model model) {
        List<Groceries> listGroceries = grocery.listEveryThing();
        model.addAttribute("listGroceries", listGroceries);
        return "GroceryList";

    }
}



