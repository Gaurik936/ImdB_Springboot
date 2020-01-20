package com.project.example.model.imdb.User_p;

import com.project.example.model.imdb.imdbException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@RestController
public class userController implements Serializable {

    @Autowired
    public userRepository userrepository;

    @GetMapping("/user")                                                   //GET ALL USERS
    public List<user> getAllUsers(){
        return userrepository.findAll();
    }

    @GetMapping("/user/{id}")                                              //GET USER BY ID
    public user getUser(@PathVariable Integer id){
        return userrepository.findById(id).orElseThrow(() -> new imdbException("User", "id", id));
    }

    @PostMapping("/user")                                                  //INSERT USER
    public void createUser(@Valid @RequestBody user user){
        userrepository.save(user);
    }

    @PutMapping("/user/{id}")                                              //EDIT USER DETAILS
    public user updateUser(@PathVariable Integer id, @Valid @RequestBody user user_new){
        user temp = userrepository.findById(id).orElseThrow(() -> new imdbException("User", "id", id));
        temp.setUser_name(user_new.getUser_name());
        temp.setPassword(user_new.getPassword());
        user new_user = userrepository.save(temp);
        return new_user;

    }

    @DeleteMapping("/user/{id}")                                           //DELETE USER
    public void deleteUser(@PathVariable Integer id){
        userrepository.deleteById(id);
    }
}
