package com.example.capstoneproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired private GroceryList grocery;

//    @GetMapping("/users")
    @GetMapping("/GroceryList.html")
    public String showGroceryList(Model model){
        List<User> listGroceries = grocery.listEveryThing();
        model.addAttribute("listGroceries",listGroceries);
        return "GroceryList";

    }
}
