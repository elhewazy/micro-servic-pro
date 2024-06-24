package com.genspark.user.Client;

import com.genspark.user.Entity.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.*;

import java.util.List;

@HttpExchange
public interface CustomerClient {

    @GetExchange("/Customer/getAllCustomer")
    List<Customer> getAllCustomers();

    @PostExchange("/Customer/addCustomer")
    Customer addNewCustomer(@RequestBody Customer customer);

    @PutExchange("/Customer")
    Customer updateCustomer(@RequestBody Customer customer);

    @DeleteExchange("/Customer/delete/{id}")
    String deleteCustomer(@PathVariable long id);

}
