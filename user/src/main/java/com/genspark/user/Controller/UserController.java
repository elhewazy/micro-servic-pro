package com.genspark.user.Controller;

import com.genspark.user.Client.BookClient;
import com.genspark.user.Entity.Book;
import com.genspark.user.Entity.User;
import com.genspark.user.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookClient bookClient;

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/newUser")
    public User addUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable long id) {
        return userService.deleteUserById(id);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookClient.findAllBooks();
    }

//    @DeleteMapping("/deleteBook/{id}")
//    public String deleteBook(@PathVariable long id) {
//        return userService.
//    }


}
