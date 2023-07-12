package com.example.capstoneproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired private UserService user;

    @GetMapping("/users.html")
    public String showUserList(Model model){
        List<User> listUsers = user.listEveryThing();
        model.addAttribute("listusers",listUsers);
        return "userList";

    }
}
