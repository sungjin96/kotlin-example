package com.example.junit5tutorial.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

/**
 * Created by marathoner on 2022/08/23
 */
@DataJpaTest // DB 와 관련된 컴포넌트만 메모리에 로딩
internal class BookRepositoryTest @Autowired constructor(private val bookRepository: BookRepository) {

    @Test
    fun `책등록_TEST`() {
        println("책등록 테스트 실행")
    }
}
