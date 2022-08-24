package com.example.junit5tutorial.domain

import com.example.junit5tutorial.web.dto.BookCreateRequestDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by marathoner on 2022/08/23
 */
@DataJpaTest // DB 와 관련된 컴포넌트만 메모리에 로딩
internal class BookRepositoryTest @Autowired constructor(private val bookRepository: BookRepository) {

    @Test
    fun `책등록_TEST`() {
        // given (데이터 준비)
        val title = "junit5";
        val author = "test";
        val book = BookCreateRequestDto(title, author).toEntity()

        // when (테스트 실행)
        val result = bookRepository.save(book)

        // then (검증)
        assertThat(result).isNotNull
        assertThat(result.title).isGreaterThanOrEqualTo(book.title)
        assertThat(result.author).isGreaterThanOrEqualTo(book.author)
    }
}
