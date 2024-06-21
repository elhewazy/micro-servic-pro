package com.genspark.Customer_service.Dao;

import com.genspark.Customer_service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
    public List<Customer> findByEmail(String email);
    public List<Customer> getCustmorByLastName(String lastName);
    public Customer getCustmorByPhone(long phone);

}
