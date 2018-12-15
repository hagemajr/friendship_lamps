package com.hagemajr.friendshipLamps.server

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection
import java.sql.ResultSet
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.core.kotlin.mapTo
import org.jdbi.v3.core.kotlin.withHandleUnchecked
import org.jdbi.v3.core.result.ResultIterable
import org.jdbi.v3.sqlite3.SQLitePlugin
import sun.misc.Signal.handle
import org.sqlite.JDBC

data class SampleTable (val one: String, val two: Int)

fun test() : MutableList<SampleTable> {
    Class.forName("org.sqlite.JDBC")
    val jdbi = Jdbi.create("jdbc:sqlite:C:/Users/johnr/code/friendship_lamps/server/lamps.db")
    jdbi.installPlugin(SQLitePlugin())
    jdbi.installPlugin(KotlinPlugin())
    return jdbi.withHandleUnchecked {handle ->
        handle.createQuery("select * from sample_table").mapTo<SampleTable>().list()
    }
}

