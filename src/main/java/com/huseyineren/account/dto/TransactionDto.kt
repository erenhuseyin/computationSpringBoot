package com.huseyineren.account.dto

import com.huseyineren.account.model.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime

data class TransactionDto(
    val id: String?,
    val transactionType: TransactionType? = TransactionType.INITIAL,
    val amount: BigDecimal?,
    var transactionDate: LocalDateTime?
)