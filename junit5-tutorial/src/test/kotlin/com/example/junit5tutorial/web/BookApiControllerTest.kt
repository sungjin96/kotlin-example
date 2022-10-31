package com.example.junit5tutorial.web

import com.example.junit5tutorial.service.BookService
import com.example.junit5tutorial.web.dto.BookCreateRequestDto
import com.example.junit5tutorial.web.dto.BookResponseDto
import com.fasterxml.jackson.databind.ObjectMapper
import com.jayway.jsonpath.JsonPath
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.*

/**
 * Created by marathoner on 2022/08/23
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class BookApiControllerTest {

    @Autowired
    private lateinit var rt: TestRestTemplate

    @Autowired
    private lateinit var om: ObjectMapper

    @Test
    fun `should book save test`() {
        // given
        val bookCreateRequestDto = BookCreateRequestDto(
            title = "Spring",
            author = "Jang",
        )

        val body = om.writeValueAsString(bookCreateRequestDto)
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val httpEntity = HttpEntity(body, headers);

        // when
        val response = rt.exchange(
            "/api/v1/book",
            HttpMethod.POST,
            httpEntity,
            String::class.java
        )

        // then
        val dc = JsonPath.parse(response.body)
        val title = dc.read<String>("$.body.title")
        val author = dc.read<String>("$.body.author")

        assertThat(bookCreateRequestDto.title).isEqualTo(title)
        assertThat(bookCreateRequestDto.author).isEqualTo(author)
    }

    @Test
    fun `책 목록보기`() {
        // given
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val httpEntity = HttpEntity(null, headers);

        // when
        val response = rt.exchange(
            "/api/v1/book",
            HttpMethod.GET,
            httpEntity,
            String::class.java
        )

        // then
        val dc = JsonPath.parse(response.body)
        val code = dc.read<Int>("$.code")

        assertThat(1).isEqualTo(code)

    }
}
