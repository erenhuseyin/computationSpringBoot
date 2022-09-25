package com.huseyineren.account.service;

import com.huseyineren.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    /*
    @Autowired
    private AccountRepository accountRepository;
    */

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //autowired ile immutable reposiorymiz olmaz
    //tester için mock ayarı yapmayı gerektirir, bu da gereksiz uğraş demektir
    //final kullanmamızın sebebi, nesnemize değiştirilemez default initialize değerini başlangıçte vermektir.


}
