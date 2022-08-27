package com.example.junit5tutorial.web.dto

import com.example.junit5tutorial.domain.Book

/**
 * Created by marathoner on 2022/08/24
 */
class BookCreateRequestDto(
    private var title: String,
    private var author: String,
) {
    fun toEntity(): Book {
        return Book(title, author)
    }
}