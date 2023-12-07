package com.example.demo.controller;

import com.example.demo.entities.Customer;
import com.example.demo.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/customers")
public class AddCustomerController {

    private CustomerRepository customerRepository;

    @Autowired
    public AddCustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @PostMapping("/addcustomer")
    public void AddCustomer(@RequestBody Customer customer){

        customerRepository.save(customer);

    }

}