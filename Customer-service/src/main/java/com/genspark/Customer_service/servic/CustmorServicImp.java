package com.genspark.Customer_service.servic;

import com.genspark.Customer_service.Dao.CustomerDao;
import com.genspark.Customer_service.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class CustmorServicImp implements CustmorService{
    @Autowired
    CustomerDao cd;
    @Override
    public List<Customer> getAll() {
        //log.debug("getting all customer servic layer ");
        return this.cd.findAll();
    }

    @Override
    public Customer addCustmor(Customer u) {
        log.debug("adding customer from  "+u.toString());
        return cd.save(u);
    }

    @Override
    public List<Customer> getCustmorByEmail(String email) {
        log.debug("getting customer by email servic layer "+ email);
        return this.cd.findByEmail(email);
    }

    @Override
    public List<Customer> getCustmorByLastName(String lastName) {
        //log.debug("getting customer by lastName servic layer "+ lastName);
        return this.cd.getCustmorByLastName(lastName);
    }

    @Override
    public Customer getCustmorByPhone(long phone) {
        //log.debug("getting customer by phone servic layer "+ phone);

        return this.cd.getCustmorByPhone(phone);
    }


    @Override
    public Customer updateCustmor(Customer s) {
        //log.debug("update custmer servic layer " + s.toString());
        return this.cd.save(s);
    }

    @Override
    public String deletCustmor(int id) {
        this.cd.deleteById(id);
        //log.debug("servic layer deleting a customer");
        return "deleted successfully";

    }

}
