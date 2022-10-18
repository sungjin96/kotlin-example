package com.example.junit5tutorial.web

import com.example.junit5tutorial.service.BookService
import com.example.junit5tutorial.web.dto.BookCreateRequestDto
import com.example.junit5tutorial.web.dto.BookResponseDto
import com.example.junit5tutorial.web.dto.BookUpdateRequestDto
import com.example.junit5tutorial.web.dto.CommonResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.function.Consumer
import javax.validation.Valid


/**
 * Created by marathoner on 2022/08/23
 */
@RestController
@RequestMapping("/api/v1/book")
class BookApiController(private val bookService: BookService) {

    @PostMapping
    fun saveBook(@Valid @RequestBody dto: BookCreateRequestDto): ResponseEntity<CommonResponseDto<BookResponseDto>> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(
                CommonResponseDto(code = 1, msg = "글 저장 성공", body = bookService.create(dto))
            )
    }

    @GetMapping
    fun getBookList(): ResponseEntity<List<BookResponseDto>> =
        ResponseEntity.status(HttpStatus.OK).body(bookService.findAll())

    @GetMapping("/{id}")
    fun getBook(@PathVariable id: UUID): ResponseEntity<BookResponseDto> =
        ResponseEntity.status(HttpStatus.OK).body(bookService.findById(id))

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: UUID) =
        ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookService.delete(id))

    @PutMapping("/{id}")
    fun updateBook(@PathVariable id: UUID, @RequestBody dto: BookUpdateRequestDto) =
        ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookService.update(id, dto))
}
