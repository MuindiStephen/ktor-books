package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * Stephen Muindi
 * @2023 Ktor Backend
 * Created on 19-06-2023
 *
 * Netty - Engine
 *
 * Host and port running: 127.0.0.1:8080
 */
fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
//    intercept(ApplicationCallPipeline.Fallback) {
//        if (call.isHandled) return@intercept
//        val status = call.response.status() ?: HttpStatusCode.NotFound
//        call.respond(status)
//    }
    configureSerialization()
    configureRouting()
}
