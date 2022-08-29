package com.example.junit5tutorial.service

import com.example.junit5tutorial.domain.BookRepository
import com.example.junit5tutorial.util.MailSenderStub
import com.example.junit5tutorial.web.dto.BookCreateRequestDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by marathoner on 2022/08/23
 */
@DataJpaTest
internal class BookServiceTest @Autowired constructor(
    private val bookRepository: BookRepository,
) {

    @Test
    fun `should 책 등록하기 테스트`() {
        // given
        val bookDto = BookCreateRequestDto("Title", "Author")

        // stub
        val mailSenderStub = MailSenderStub()

        // when
        val bookService = BookService(bookRepository, mailSenderStub)
        val newBook = bookService.create(bookDto)

        // then
        assertThat(newBook.title).isGreaterThanOrEqualTo(bookDto.title)
        assertThat(newBook.author).isGreaterThanOrEqualTo(bookDto.author)
    }
}
