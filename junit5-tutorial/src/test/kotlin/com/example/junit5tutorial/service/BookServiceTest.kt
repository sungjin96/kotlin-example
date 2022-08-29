package com.example.junit5tutorial.service

import com.example.junit5tutorial.domain.BookRepository
import com.example.junit5tutorial.util.MailSender
import com.example.junit5tutorial.web.dto.BookCreateRequestDto
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.any
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

/**
 * Created by marathoner on 2022/08/23
 */
@ExtendWith(MockitoExtension::class)
internal class BookServiceTest {

    @InjectMocks
    private lateinit var bookService: BookService
    @Mock
    private lateinit var bookRepository: BookRepository
    @Mock
    private lateinit var mailSender: MailSender

    @Test
    fun `should 책 등록하기 테스트`() {
        // given
        val bookDto = BookCreateRequestDto("Title", "Author")

        // stub
        Mockito.`when`(bookRepository.save(any())).thenReturn(bookDto.toEntity())
        Mockito.`when`(mailSender.send()).thenReturn(true)

        // when
        val newBook = bookService.create(bookDto)

        // then
        assertThat(bookDto.title).isEqualTo(newBook.title)
        assertThat(bookDto.author).isEqualTo(newBook.author)
    }
}
