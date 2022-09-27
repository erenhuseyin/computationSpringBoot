package com.huseyineren.account.service;

import com.huseyineren.account.model.Account;
import com.huseyineren.account.model.Transaction;
import com.huseyineren.account.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    private Logger logger = LoggerFactory.getLogger(TransactionService.class);
    //log, yazılımcıyı hata durumlarında bilgilendirmek amaçlı yazılır

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    protected Transaction initiateMoney(final Account account, BigDecimal amount){
        return transactionRepository.save(
                new Transaction(amount, account)
        );
    }
}
