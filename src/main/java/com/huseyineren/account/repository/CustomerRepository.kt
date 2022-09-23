package com.huseyineren.account.repository

import com.huseyineren.account.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer?, String?>