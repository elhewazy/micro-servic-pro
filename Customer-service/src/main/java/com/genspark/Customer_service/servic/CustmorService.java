package com.genspark.Customer_service.servic;

import com.genspark.Customer_service.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustmorService {
    public List<Customer> getAll();
    public Customer addCustmor(Customer u);
    public List<Customer> getCustmorByEmail(String email);
    public List<Customer> getCustmorByLastName(String lastName);
    public Customer getCustmorByPhone(long phone);
    public Customer updateCustmor(Customer s);
    public String deletCustmor(int id);

}
