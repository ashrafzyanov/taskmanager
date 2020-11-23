package com.ashrafzyanov.taskmanager.server;

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>) {
    Database.connect("jdbc:h2:mem:test")
    transaction {
        addLogger(StdOutSqlLogger)
        SchemaUtils.create(Cities)
        val stPeteId = Cities.insert {
            it[name] = "St. Peterburg"
        } get Cities.id

        println("Cities: ${Cities.selectAll()}")
    }
}

object Cities: IntIdTable() {
    val name = varchar("name", 50)
}