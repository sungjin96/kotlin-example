package com.example.junit5tutorial.web.dto

import com.example.junit5tutorial.domain.Book
import java.util.*

/**
 * Created by marathoner on 2022/08/23
 */
class BookResponseDto(val id: UUID, val title: String, val author: String) {
    constructor(book: Book) : this(book.id, book.title, book.author)

    companion object {
        fun from(book: Book): BookResponseDto {
            return BookResponseDto(book)
        }
    }
}
