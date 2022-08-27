package com.example.junit5tutorial.domain

import com.example.junit5tutorial.web.dto.BookUpdateRequestDto
import javax.persistence.Column
import javax.persistence.Entity

/**
 * Created by marathoner on 2022/08/23
 */
@Entity
class Book(
    title: String,
    author: String,
) : PrimaryKeyEntity() {
    @Column(nullable = false, length = 50)
    var title: String = title
        protected set

    @Column(nullable = false, length = 20)
    var author: String = author
        protected set

    fun update(data: BookUpdateRequestDto) {
        data.title.let { if (it.isNotBlank()) title = it }
        data.author.let { if (it.isNotBlank()) author = it }
    }
}
