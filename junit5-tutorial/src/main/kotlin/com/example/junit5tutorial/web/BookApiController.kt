package com.example.junit5tutorial.web

import com.example.junit5tutorial.service.BookService
import com.example.junit5tutorial.web.dto.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid


/**
 * Created by marathoner on 2022/08/23
 */
@RestController
@RequestMapping("/api/v1/book")
class BookApiController(private val bookService: BookService) {

    @PostMapping
    fun saveBook(@Valid @RequestBody dto: BookCreateRequestDto): ResponseEntity<CommonResponseDto<BookResponseDto>> {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                CommonResponseDto.success(msg = "글 저장 성공", body = bookService.create(dto))
            )
    }

    @GetMapping
    fun getBooks(): ResponseEntity<CommonResponseDto<BookListResponseDto>> =
        ResponseEntity.status(HttpStatus.OK).body(
            CommonResponseDto.success(msg = "글 저장 성공", body = bookService.findAll())
        )

    @GetMapping("/{id}")
    fun getBook(@PathVariable id: UUID): ResponseEntity<CommonResponseDto<BookResponseDto>> =
        ResponseEntity.status(HttpStatus.OK).body(
            CommonResponseDto.success(msg = "글 저장 성공", body = bookService.findById(id))
        )

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: UUID): ResponseEntity<Unit> =
        ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookService.delete(id))

    @PutMapping("/{id}")
    fun updateBook(@PathVariable id: UUID, @Valid @RequestBody dto: BookUpdateRequestDto): ResponseEntity<Unit> =
        ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookService.update(id, dto))
}
