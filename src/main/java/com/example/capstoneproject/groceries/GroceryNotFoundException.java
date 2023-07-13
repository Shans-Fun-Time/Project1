package com.example.capstoneproject.groceries;

public class GroceryNotFoundException extends Throwable {
    public GroceryNotFoundException(String message) {
        super(message);
    }
}
