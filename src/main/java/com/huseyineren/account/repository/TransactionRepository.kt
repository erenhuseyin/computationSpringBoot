package com.huseyineren.account.repository

import com.huseyineren.account.model.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository : JpaRepository<Transaction?, String?>