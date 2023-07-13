package com.example.capstoneproject.groceries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/groceries/new") // link in GroceryList.html
    public String addGrocery(Model model){
        model.addAttribute("groceries", new Groceries());
        model.addAttribute("pageTitle", "Add groceries");
        return "AddingGroceries"; //AddingGroceries is a html
    }

    @PostMapping("/groceries/save")
    public String saveGrocery(Groceries groceries, RedirectAttributes ra){
        grocery.save(groceries); //created method in groceryService class
        ra.addFlashAttribute("message", "Grocery Added to list!");
        return "redirect:/GroceryList.html";
    }

    @GetMapping("/groceries/edit/{id}")
    public String editList(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            Groceries g1 = grocery.get(id);
            model.addAttribute("groceries", g1);
            model.addAttribute("pageTitle", "Edit grocery ID: " + id);
            return "AddingGroceries.html";
        } catch (GroceryNotFoundException e) {
            ra.addFlashAttribute("message", "Grocery was Edited ID: " + id);
            return "redirect:/GroceryList.html";
        }
    }

    @GetMapping("/groceries/delete/{id}")
    public String deleteGrocery(@PathVariable("id") Integer id, RedirectAttributes ra){
        try {
            grocery.takeOffGrocery(id);
            ra.addFlashAttribute("message", "Grocery has been taken off ID: " + id);
        } catch (GroceryNotFoundException e) {
            ra.addFlashAttribute("message", "Grocery was not deleted ID: " + id);
        }
        return "redirect:/GroceryList.html";
    }

}



