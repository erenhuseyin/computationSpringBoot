package com.huseyineren.account.model

import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class Account(

    @Id
    @GeneratedValue(generator = "UUID")//tahmin edilemeyen id'ler olması icin hashcode üretir
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",//hibernate bizim için id oluşturucak
    val balance: BigDecimal? = BigDecimal.ZERO,
    val creationDate: LocalDateTime,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "customer_id", nullable = false)
    val customer: Customer?,//? bu alan boş olabilir anlamına denk geliyor
    //FetchType.LAZY-> yalnızca customer çağırmak için kullanılır, customer çağırıldığı vakit account verilerinin gelmesini engeller
    //CascadeType.ALL -> bu ilişkiye ait yapılan işlemlerde account tablosunda customer değişikliklerinde customer tablolarında da değişikliği uygular
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    val transaction: Set<Transaction>? = HashSet()
    //
){

    constructor(customer: Customer, balance: BigDecimal, creationDate: LocalDateTime): this(
        "",
        customer = customer,
        balance = balance,
        creationDate = creationDate//kotlin ile constructorlarımızı direk ismi ile çağırabiliyoruz
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Account

        if (id != other.id) return false
        if (balance != other.balance) return false
        if (creationDate != other.creationDate) return false
        if (customer != other.customer) return false
        if (transaction != other.transaction) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (balance?.hashCode() ?: 0)
        result = 31 * result + creationDate.hashCode()
        result = 31 * result + (customer?.hashCode() ?: 0)
        return result
    }
}