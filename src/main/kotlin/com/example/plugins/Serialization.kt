package com.example.plugins

import com.example.model.Book
import io.ktor.serialization.gson.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*

fun Application.configureSerialization() {

    install(ContentNegotiation) {
        json()
    }

    /**
     * Basic GET/POST Requests with Ktor Serialization
     */
    //val books = mutableListOf<Book>()

    routing {

        get("/json-kotlinx-serialization") {
            call.respond(mapOf("Hello" to "ktor"))
        }
//        get("/") {
//            call.respondText("Hello World!")
//        }
//        get("/books") {
//            call.respond(books)
//        }
//        post("/add-a-book") {
//            val book = call.receive<Book>()
//            books.add(book)
//            call.respond("A New Book Added successfully")
//        }
    }
}
