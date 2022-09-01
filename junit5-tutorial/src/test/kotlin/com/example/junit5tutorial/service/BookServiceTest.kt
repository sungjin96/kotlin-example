package com.example.junit5tutorial.service

import com.example.junit5tutorial.domain.Book
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
import java.util.*

/**
 * Created by marathoner on 2022/08/23
 */
@ExtendWith(MockitoExtension::class)
internal class BookServiceTest {

    lateinit var a: String

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

    @Test
    fun `should 책 목록보기 테스트`() {
        // stub
        val books = arrayListOf<Book>(
            Book(title = "title", author = "author"),
            Book(title = "title2", author = "author2")
        )
        Mockito.`when`(bookRepository.findAll()).thenReturn(books)

        // when
        val findBooks = bookService.findAll()

        // then
        assertThat("title").isEqualTo(findBooks[0].title)
        assertThat("author").isEqualTo(findBooks[0].author)
        assertThat("title2").isEqualTo(findBooks[1].title)
        assertThat("author2").isEqualTo(findBooks[1].author)

    }

    @Test
    fun `should 책 한권보기 테스트`() {
        // given

        // stub
        val book: Optional<Book> = Optional.of(Book(title = "title", author = "author"))

        Mockito.`when`(bookRepository.findById(any())).thenReturn(book)

        //when
        val findBook = bookService.findById(book.get().id)

        // then
        assertThat(book.get().title).isEqualTo(findBook.title)
        assertThat(book.get().author).isEqualTo(findBook.author)

    }

}
