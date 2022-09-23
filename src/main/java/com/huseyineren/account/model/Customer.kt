package com.huseyineren.account.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
data class Customer(

    @Id
    @GeneratedValue(generator = "UUID")//tahmin edilemeyen id'ler olması icin hashcode üretir
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String?,

    val name: String?,
    val surname: String?,

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    val accounts: Set<Account>?
)
