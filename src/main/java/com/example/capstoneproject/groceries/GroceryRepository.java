package com.example.capstoneproject.groceries;

import org.springframework.data.repository.CrudRepository;

public interface GroceryRepository extends CrudRepository<Groceries, Integer> {
    public Integer countById(Integer id);


}
