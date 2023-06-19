package com.example.services

import com.example.model.Book

/**
 * API Service to preload Book information
 */

class BookService {

    private val books = mutableListOf<Book>()


//    init {
//        books.add(Book(1,"Kotlin programming","Steve","1st Edition"))
//        books.add(Book(2,"Android development","Philip lackner","4th Edition"))
//        books.add(Book(3,"Intro to Coroutines","Juma Allan","2nd Edition"))
//        books.add(Book(4,"Android Mpesa SDK Book","Carrieukie","1st Edition"))
//        books.add(Book(5,"Kotlin basics","Jackson","2nd Edition"))
//    }


    fun getBooks() : List<Book> = books

    fun addBook(book: Book): Book? {
        books.add(book)
        return book
    }

    fun getBook(id:Int): Book? {
        return books.find { book->
            book.id == id
        }
    }

    fun deleteBook(id: Int) {
        books.removeAll {book->
            book.id == id
        }
    }

}