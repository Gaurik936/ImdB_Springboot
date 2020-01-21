package com.project.example.model.imdb.UserNew;

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
    public List<User> getAllUsers(){
        return userrepository.findAll();
    }

    @GetMapping("/user/{id}")                                              //GET USER BY ID
    public User getUser(@PathVariable Integer id){
        return userrepository.findById(id).orElseThrow(() -> new imdbException("User", "id", id));
    }

    @PostMapping("/user")                                                  //INSERT USER
    public void createUser(@Valid @RequestBody User user){
        userrepository.save(user);
    }

    @PutMapping("/user/{id}")                                              //EDIT USER DETAILS
    public User updateUser(@PathVariable Integer id, @Valid @RequestBody User userNew){
        User temp = userrepository.findById(id).orElseThrow(() -> new imdbException("User", "id", id));
        temp.setUserName(userNew.getUserName());
        temp.setPwd(userNew.getPwd());
        User newUser = userrepository.save(temp);
        return newUser;
    }

    @DeleteMapping("/user/{id}")                                           //DELETE USER
    public void deleteUser(@PathVariable Integer id){
        userrepository.deleteById(id);
    }
}
