package com.example.week3;

import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = {"/customers"}, method = {RequestMethod.GET})
    public List<Customer> getCustomers(){
        return this.customers;
    }

    @RequestMapping(value = {"/customerbyid/{id}"}, method = {RequestMethod.GET})
    public Customer getCustomerByID(@PathVariable("id") String ID){
        for (int i = 0; i < this.customers.size(); i++){
            if (this.customers.get(i).getID().equals(ID)){
                return this.customers.get(i);
            }
        }
        return null;
    }

    @RequestMapping(value = {"/customerbyname/{n}"}, method = {RequestMethod.GET})
    public Customer getCustomerByName(@PathVariable("n") String n){
        for (int i = 0; i < this.customers.size(); i++){
            if (this.customers.get(i).getName().equals(n)){
                return this.customers.get(i);
            }
        }
        return null;
    }

    @RequestMapping(value = {"/customerDelByid/{id}"}, method = {RequestMethod.DELETE})
    public boolean DelCustomerByID(@PathVariable("id") String ID){
        for (int i = 0; i < this.customers.size(); i++){
            if (this.customers.get(i).getID().equals(ID)){
                this.customers.remove(i);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = {"/customerDelByname/{n}"}, method = {RequestMethod.DELETE})
    public boolean DelCustomerByName(@PathVariable("n") String name){
        for (int i = 0; i < this.customers.size(); i++){
            if (this.customers.get(i).getName().equals(name)){
                this.customers.remove(i);
                return true;
            }
        }
        return false;
    }


    @RequestMapping(value = {"/addCustomer"}, method = {RequestMethod.GET})
    public boolean addCustomer(@RequestParam("id") String ID, @RequestParam("name") String n, @RequestParam("sex") String s, @RequestParam("age") int a){
        this.customers.add(new Customer(ID, n, s, a));
        return true;
    }

    @RequestMapping(value = {"/addCustomer2"}, method = {RequestMethod.POST})
    public boolean addCustomer2(@RequestParam("id") String ID, @RequestParam("name") String n, @RequestParam("sex") String s, @RequestParam("age") int a){
        this.customers.add(new Customer(ID, n, s, a));
        return true;
    }

//    7. เหมือนกัน
//    8.RequestMethod ที่ใส่ในpostman ไม่ตรงกับที่เขียน java


}