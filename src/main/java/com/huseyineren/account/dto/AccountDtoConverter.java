package com.huseyineren.account.dto;

import com.huseyineren.account.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoConverter {

    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDto transactionDtoConverter;

    public AccountDtoConverter(CustomerDtoConverter customerDtoConverter) {
        this.customerDtoConverter = customerDtoConverter;
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public AccountDto convert(Account from){
        return new AccountDto(from.getId(),
                              from.getBalance(),
                              from.getCreationDate(),
                              customerDtoConverter.convertToAccountCustomer(from.getCustomer(), from.getTransaction().stream().map(->transactionDtoConverter


