package com.example.routing

import com.example.model.Book
import com.example.services.BookService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * GET/POST via API Service for preloading Book information
 */
@Suppress("unused")
fun Route.bookRoutes() {

    // Calling the API BookService
    val bookService = BookService()

    route("/books") {
        get {
            call.respond(bookService.getBooks())
        }
        get("/{id}") {
            val bookIdFromQuery = call.parameters["id"] ?: kotlin.run {
                throw Exception("Please provide a valid id")
            }
            val book = bookIdFromQuery.toIntOrNull()?.let { it1 -> bookService.getBook(it1) }

            if (book == null) {
                call.respond(HttpStatusCode.NotFound, "Book Not Found")
            } else {
                call.respond(HttpStatusCode.OK, book)
            }

        }

        accept(ContentType.Any) {
            post {
                val bookRequest = call.receive(Book::class)
                bookService.addBook(bookRequest)
                call.respond(bookRequest)
            }
        }

        delete("/{id}") {
            val bookIdQuery = call.parameters["id"] ?: "Please provide a valid id"
            bookIdQuery.toIntOrNull()?.let { it1 -> bookService.deleteBook(it1) }

            call.respond(HttpStatusCode.OK, "Book Deleted Successfully")
        }
    }
}


