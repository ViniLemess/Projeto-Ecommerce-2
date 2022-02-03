package com.ecommerce.controller;

import com.ecommerce.model.Customer;
import com.ecommerce.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService service;

    public CustomerController(CustomerService customerService) {
        this.service = customerService;
    }

    @GetMapping(params = {"filter"})
    public List<Customer> getCustomers(@RequestParam("filter") String filter) {

        return service.listByName(filter);
    }
    @GetMapping
    public Customer getCustomer(@RequestParam("name") String name) {

        return service.searchByName(name);
    }
    @PostMapping
    public void createCustomer(@RequestBody @Valid Customer customer) {

        service.registerCustomer(customer);
    }
}
