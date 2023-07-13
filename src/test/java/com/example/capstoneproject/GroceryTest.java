package com.example.capstoneproject;

import com.example.capstoneproject.groceries.Groceries;
import com.example.capstoneproject.groceries.GroceryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.*;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class GroceryTest {
    @Autowired private GroceryRepository profiles;
    @Test
    public void testAddNewGrocery(){
        Groceries g1 = new Groceries();
        g1.setProduct("avocado II");
        g1.setPrice(1.67);
        g1.setStore("Safeway");
        g1.setBought(true);

        Groceries user1 = profiles.save(g1);
        Assertions.assertNotNull(user1);
        assertTrue(user1.getId() > 0);

    }
}
