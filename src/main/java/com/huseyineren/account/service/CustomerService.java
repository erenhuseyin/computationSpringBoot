package com.huseyineren.account.service;

import com.huseyineren.account.exception.CustomerNotFoundException;
import com.huseyineren.account.model.Customer;
import com.huseyineren.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer could not found by id: " + id));
    }//protected kullanarak encapsulation yapıyoruz

}
