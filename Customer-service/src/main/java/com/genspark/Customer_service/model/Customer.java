package com.genspark.Customer_service.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    long phone;
    int bookid;
    String firstName;
    String lastName;
    String email;
    String address;
    String jobtitle;

    public Customer(long phone, String firstName, String lastName, String email, String address, String jobtitle) {
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.jobtitle = jobtitle;
    }

}
