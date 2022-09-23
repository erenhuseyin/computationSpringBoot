package com.huseyineren.account.model

import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Account(

    @Id
    @GeneratedValue(generator = "UUID")//tahmin edilemeyen id'ler olması icin hashcode üretir
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String?,//? bu alan boş olabilir anlamına denk geliyor
    val balance: BigDecimal? = BigDecimal.ZERO,
    val creationDate: LocalDateTime,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "customer_id", nullable = false)
    val customer: Customer?,
    //FetchType.LAZY-> yalnızca customer çağırmak için kullanılır, customer çağırıldığı vakit account verilerinin gelmesini engeller
    //CascadeType.ALL -> bu ilişkiye ait yapılan işlemlerde account tablosunda customer değişikliklerinde customer tablolarında da değişikliği uygular
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    val transaction: Set<Transaction>?
    //
){

}