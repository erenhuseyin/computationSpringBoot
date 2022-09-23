package com.huseyineren.account.model

import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.temporal.TemporalAmount
import javax.persistence.*

@Entity
data class Transaction(

    @Id
    @GeneratedValue(generator = "UUID")//tahmin edilemeyen id'ler olması icin hashcode üretir
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String?,
    val transactionType: TransactionType? = TransactionType.INITIAL,
    val amount: BigDecimal?,
    var transactionDate: LocalDateTime?,

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "acoount_id", nullable = false)
    val account: Account
){

}

enum class TransactionType {
    INITIAL, TRANSFER
}
