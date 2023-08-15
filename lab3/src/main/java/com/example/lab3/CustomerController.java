package com.example.lab3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    private List<Customer> customers;

    public CustomerController() {
        this.customers = new ArrayList<>();
        this.customers.add(new Customer("1010","John","Male",25));
        this.customers.add(new Customer("1018","Peter","Male",24));
        this.customers.add(new Customer("1019","Sara","Female",23));
        this.customers.add(new Customer("1110","Rose","Female",23));
        this.customers.add(new Customer("1001","Emma","Female",30));
    }

//    public List<Customer> getCustomers()

}
