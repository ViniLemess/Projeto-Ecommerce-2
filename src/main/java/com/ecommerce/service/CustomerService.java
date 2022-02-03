package com.ecommerce.service;

import com.ecommerce.infra.repository.CustomerRepository;
import com.ecommerce.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {this.customerRepository = customerRepository;}

    public void registerCustomer(Customer customer) {

        validateDuplicatedRegister(customer.getName(), customer.getId());
        this.customerRepository.save(customer);
    }
    public Customer searchByName(String name) {

        if(name == null || name.isBlank()) {

            throw new IllegalArgumentException("Nome inválido!");
        }
        return customerRepository.searchCustomerByName(name);
    }
    public List<Customer> listByName(String name) {

        if(name == null || name.isBlank()) {

            throw new IllegalArgumentException("Nome inválido!");
        }
        return customerRepository.searchAllCustomers(name);
    }
    private void validateDuplicatedRegister(String name, Long id) {

        var quantity = customerRepository.countByNameAndDifferentId(name, id);
        if (quantity != 0) {
            throw new IllegalArgumentException("Registro já cadastrado");
        }
    }
}
