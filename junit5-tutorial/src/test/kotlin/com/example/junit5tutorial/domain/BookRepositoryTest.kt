package com.example.junit5tutorial.domain

import com.example.junit5tutorial.web.dto.BookCreateRequestDto
import com.example.junit5tutorial.web.dto.BookUpdateRequestDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * Created by marathoner on 2022/08/23
 */
@DataJpaTest // DB 와 관련된 컴포넌트만 메모리에 로딩
internal class BookRepositoryTest @Autowired constructor(private val bookRepository: BookRepository) {


    //    @BeforeAll // 테스트 시작전에 한번만 실행
    @BeforeEach // 각 테스트 시작전에 한번씩 실행
    fun `데이터준비`() {
    }

    @Test
    fun `should 책 등록`() {
        // given / when
        val (book, newBook) = saveBook()

        // then (검증)
        assertThat(newBook).isNotNull
        assertThat(newBook.title).isGreaterThanOrEqualTo(book.title)
        assertThat(newBook.author).isGreaterThanOrEqualTo(book.author)
    }

    @Test
    fun `should 책 전체 조회`() {
        // given
        val (book) = saveBook()

        // when
        val books = bookRepository.findAll()

        // then
        assertThat(books[0].title).isGreaterThanOrEqualTo(book.title)
        assertThat(books[0].author).isGreaterThanOrEqualTo(book.author)

    }

    @Test
    fun `should 책 단일 조회`() {
        // given
        val (book, newBook) = saveBook()

        // when
        val findBook = bookRepository.findById(newBook.id).get()

        // then
        assertThat(findBook.title).isGreaterThanOrEqualTo(book.title)
        assertThat(findBook.author).isGreaterThanOrEqualTo(book.author)
    }

    @Test
    fun `should 책 삭제`() {
        // given
        val (_, newBook) = saveBook()

        // when
        bookRepository.deleteById(newBook.id)

        // then
        assertThat(bookRepository.findById(newBook.id).isPresent).isEqualTo(true)
    }

    @Test
    fun `should 책 수정`() {
        // given
        val (_, newBook) = saveBook()
        val updateBookDto = BookUpdateRequestDto(newBook.id, "title", "author")

        // when
        newBook.update(updateBookDto)

        // then
        val findBook = bookRepository.findById(newBook.id).get()
        assertThat(findBook.title).isGreaterThanOrEqualTo("title")
        assertThat(findBook.author).isGreaterThanOrEqualTo("author")

    }

    fun saveBook(): Pair<Book, Book> {
        val title = "junit5";
        val author = "test";
        val book = BookCreateRequestDto(title, author).toEntity()
        val newBook = bookRepository.save(book)

        return Pair(book, newBook)
    }
}
