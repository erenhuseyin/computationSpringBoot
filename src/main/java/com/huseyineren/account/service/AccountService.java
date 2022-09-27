package com.huseyineren.account.service;

import com.huseyineren.account.dto.AccountDto;
import com.huseyineren.account.dto.AccountDtoConverter;
import com.huseyineren.account.dto.CreateAccountRequest;
import com.huseyineren.account.model.Account;
import com.huseyineren.account.model.Customer;
import com.huseyineren.account.model.Transaction;
import com.huseyineren.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    /*
    @Autowired
    private AccountRepository accountRepository;
    */

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final AccountDtoConverter converter;
    //customer repository çağırmıyoruz çünkü her repository kendi servisinden çağırılmalı, katmanlar arası iletişimde sıkıntı olmamalı
    //repo yerine customer service'i kullanmalıyız

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          TransactionService transactionService,
                          AccountDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.transactionService = transactionService;
        this.converter = converter;
    }

    //autowired ile immutable reposiorymiz olmaz
    //tester için mock ayarı yapmayı gerektirir, bu da gereksiz uğraş demektir
    //final kullanmamızın sebebi, nesnemize değiştirilemez default initialize değerini başlangıçte vermektir.

    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());
        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now());

        if(createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0){
            Transaction transaction = transactionService.initiateMoney(account, createAccountRequest.getInitialCredit());
            account.getTransaction().add(transaction);
        }

        return converter.convert(accountRepository.save(account));
    }

}
