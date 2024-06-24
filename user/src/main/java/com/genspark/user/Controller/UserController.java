package com.genspark.user.Controller;

import com.genspark.user.Client.BookClient;
import com.genspark.user.Client.CatalogClient;
import com.genspark.user.Client.CustomerClient;
import com.genspark.user.Entity.Book;
import com.genspark.user.Entity.Catalog;
import com.genspark.user.Entity.Customer;
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

    @Autowired
    private CatalogClient catalogClient;

    @Autowired
    private CustomerClient customerClient;

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

    @PostMapping("/books/add")
    public Book addNewBook(@RequestBody Book book) {
        return bookClient.addNewBook(book);
    }

    @PutMapping("/books/update")
    public Book updateBook(@RequestBody Book book) {
        return bookClient.updateBook(book);
    }

    @DeleteMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        return bookClient.deleteBook(id);
    }

    @GetMapping("/catalogs")
    public List<Catalog> getAllCatalogs() {
        return catalogClient.findAllCatalogs();
    }

    @PostMapping("/catalogs/add")
    public Catalog addNewCatalog(@RequestBody Catalog catalog) {
        return catalogClient.addNewCatalog(catalog);
    }

    @PutMapping("/catalogs/update")
    public Catalog updateCatalog(@RequestBody Catalog catalog) {
        return catalogClient.updateCatalog(catalog);
    }

    @DeleteMapping("/catalogs/delete/{id}")
    public String deleteCatalog(@PathVariable long id) {
        return catalogClient.deleteCatalog(id);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerClient.getAllCustomers();
    }

    @PostMapping("/customers/add")
    public Customer addNewCustomer(@RequestBody Customer customer){
        return customerClient.addNewCustomer(customer);
    }

    @PutMapping("/customers/update")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerClient.updateCustomer(customer);
    }

    @DeleteMapping("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable long id){
        return customerClient.deleteCustomer(id);
    }
}
