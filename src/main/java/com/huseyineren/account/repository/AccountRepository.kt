package com.huseyineren.account.repository

import com.huseyineren.account.model.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account?, String?> { /*CrudRepository yerine JpaRepository secmemizin sebebi, findAll dendiğinde
    JpaRepository liste dönerken CrudRepository iterator döner. Liste dönmesi bizi
    sorgu esnasında kolaylık sağlar lakin crudRepo daha hızlı ve daha güvenlidir*/
}