package com.example.capstoneproject;

import com.example.capstoneproject.user.User;
import com.example.capstoneproject.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.*;



//import org.apache.commons.collections4.IterableUtils;



import java.util.Optional;

//import static org.junit.jupiter.api.Assertions.assert;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserTest {
    @Autowired private UserRepository profiles;
    @Test
    public void testAddNewUser(){
        User user = new User();
        user.setEmail("agg3212@lalaland.gov");
        user.setPassword("justyou");
        user.setFirstName("koiemd");
        user.setLastName("kosls");

        User user1 = profiles.save(user);
        Assertions.assertNotNull(user1);
        assertTrue(user1.getId() > 0);



    }
    @Test
    public void testDisplayAllUsers(){
        Iterable<User> all = profiles.findAll();
        int size = 0;
        for (User users : all) {
            size++;
        }
        assertTrue(size > 0);
        for (User users : all) {
            System.out.println(users);
        }
    }

    @Test
    public void testUpdateFields(){
        Integer userID = 1;
        Optional<User> optionalUser = profiles.findById(userID);
        User user1 = optionalUser.get();

        user1.setPassword("smow93dk030");
        profiles.save(user1);
        User updatedUser= profiles.findById(userID).get();
        assertEquals("smow93dk030", updatedUser.getPassword());

    }

    @Test
    public void testGetUser(){
        Integer userID = 2;
        Optional<User> optionalUser = profiles.findById(userID);
        assertTrue(optionalUser.isPresent());
        System.out.println(optionalUser.get());

    }

    @Test
    public void testDeleteUser(){
        Integer userID = 9;
        profiles.deleteById(userID);
        Optional<User> optionalUser = profiles.findById(userID);
        assertFalse(optionalUser.isPresent());
    }


}
