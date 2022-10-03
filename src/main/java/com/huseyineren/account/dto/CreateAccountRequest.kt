package com.huseyineren.account.dto

import java.math.BigDecimal
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank


data class CreateAccountRequest(
    @field:NotBlank//stringin boş olmaması için notBlank kullanıyoruz
    val customerId: String,
    @field:Min(0)//eksi değer almaması için min0 değeri verdik
    val initialCredit: BigDecimal
)