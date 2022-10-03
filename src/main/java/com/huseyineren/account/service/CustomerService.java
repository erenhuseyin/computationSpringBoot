package com.huseyineren.account.service;

import com.huseyineren.account.dto.CustomerDto;
import com.huseyineren.account.dto.CustomerDtoConverter;
import com.huseyineren.account.exception.CustomerNotFoundException;
import com.huseyineren.account.model.Customer;
import com.huseyineren.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer could not found by id: " + id));
    }//protected kullanarak encapsulation yapıyoruz

    public CustomerDto getCustomerById(String customerId) {

        return converter.convertToCustomerDto(findCustomerById(customerId));
    }
}
