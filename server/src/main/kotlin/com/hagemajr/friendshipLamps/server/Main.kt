package com.hagemajr.friendshipLamps.server

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.header
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.hagemajr.friendshipLamps.server.test

fun main(args: Array<String>) {
    test().forEach { print("Row: ${it.one} | ${it.two}") }
    val server = embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                val name = call.request.header("X-Api-Name")
                val key = call.request.header("X-Api-Key")
                val test = call.request
                call.respondText("Hello World! ($name) ($key)", ContentType.Text.Plain)
                
            }
            get("/demo") {
                call.respondText("HELLO WORLD!")
            }
        }
    }
    server.start(wait = true)
}