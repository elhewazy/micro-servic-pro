package com.genspark.user.Client;

import com.genspark.user.Entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange
public interface CustomerClient {

    @GetExchange("/Customer/getAllCustomer")
    List<Customer> getAllCustomers();

    @PostExchange("/Customer/addCustomer")
    Customer addNewCustomer(@RequestBody Customer customer);

}
