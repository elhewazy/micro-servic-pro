package com.genspark.user.Controller;

import com.genspark.user.Entity.User;
import com.genspark.user.Repository.UserRepository;
import com.genspark.user.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/newUser")
    public User addUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

}
