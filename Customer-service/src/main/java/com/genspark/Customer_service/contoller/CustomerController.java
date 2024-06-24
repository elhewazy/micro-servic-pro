package com.genspark.Customer_service.contoller;

import com.genspark.Customer_service.client.Bookclient;
import com.genspark.Customer_service.model.Book;
import com.genspark.Customer_service.model.Customer;
import com.genspark.Customer_service.servic.CustmorServicImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customer")
@Slf4j
public class CustomerController {
    @Autowired
    CustmorServicImp cs;
    @Autowired
    Bookclient bookclient;
    @PutMapping
    public Customer updateCustomer(Customer c){
        return cs.updateCustmor(c);
    }
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer c){
        Customer returCustomer = this.cs.addCustmor(c);
        if(returCustomer == null){
            log.debug("the customer did not added"+ c.toString());
        }else {log.debug("adding new custmor "+ c.toString());}

        return returCustomer;
    }
    @GetMapping
    public Customer getCustomer(){
        return null;
    }
    @GetMapping("/getAllCustomer")
    public List<Customer> getAllCustomer(){

        return cs.getAll();
    }
    @GetMapping("/findByPhone/{phone}")
    public Customer getCustomerByPhone(@PathVariable long phone){
        log.debug("getting customer by phone  "+ phone );
        return this.cs.getCustmorByPhone(phone);
    }
    @GetMapping("/findByemail/{email}")
    public List<Customer> getCustomerByEmail(@PathVariable String email){
        List<Customer> listReturning = cs.getCustmorByEmail(email);
        if(listReturning.get(0) == null){
            log.info("the email not founding "+ email);
        }else {
            log.info("we found the eamil " + email);
        }
        return listReturning;
    }
    @DeleteMapping("/delete/{id}")
    public String deletCustomer(@PathVariable int id){
        return this.cs.deletCustmor(id);
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooksFromBookService(){

       return bookclient.getBooks();
    }

}
