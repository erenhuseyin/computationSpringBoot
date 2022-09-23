package com.huseyineren.account.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class AccountDto(
    /*Dto, api responseların daha esnek olmasını, kontrolün elimizde olmasını sağlar
    dto amacı responselarda artık göstermek istemediğimiz verilerin entity içerisinden değil de
    dto içerisinden değiştirmemizi ve entityleri bozmamamızı sağlar (solid open closed özelliği)*/
    val id: String?,
    val balance: BigDecimal?,
    val creationDate: LocalDateTime,
    val customer: AccountCustomerDto?,//account ile customer bilgilerini de vermek amaçlandı
    //customerDto yerine accountCustomerDto oluşturulup yazılmasının sebebi kodun anlaşılırlığıdır
    val transactions: Set<TransactionDto>
)
