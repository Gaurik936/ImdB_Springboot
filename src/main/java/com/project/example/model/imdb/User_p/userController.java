package com.project.example.model.imdb.User_p;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@RestController
public class userController implements Serializable {

    @Autowired
    public userRepository userrepository;

    @GetMapping("/user")
    public List<user> getAllUsers(){
        return userrepository.findAll();
    }

    @GetMapping("/user/{id}")
    public user getUser(@PathVariable Integer id){
        return userrepository.findById(id).orElseThrow(() -> new imdbException("User", "id", id));
    }

    @PostMapping("/user/")
    public void createUser(@Valid @RequestBody user user){
        userrepository.save(user);
    }

    @PutMapping("/user/{id}")
    public user updateUser(@PathVariable Integer id, @Valid @RequestBody user user_new){
        user temp = userrepository.findById(id).orElseThrow(() -> new imdbException("User", "id", id));
        temp.setUser_name(user_new.getUser_name());
        temp.setPassword(user_new.getPassword());
        user new_user = userrepository.save(temp);
        return new_user;

    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id){
        userrepository.deleteById(id);
    }
}
