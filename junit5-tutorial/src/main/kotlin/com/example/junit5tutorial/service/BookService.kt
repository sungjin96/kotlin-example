package com.example.junit5tutorial.service

import com.example.junit5tutorial.domain.BookRepository
import com.example.junit5tutorial.web.dto.BookCreateRequestDto
import com.example.junit5tutorial.web.dto.BookResponseDto
import com.example.junit5tutorial.web.dto.BookUpdateRequestDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID
import javax.persistence.EntityNotFoundException

/**
 * Created by marathoner on 2022/08/23
 */
@Service
class BookService(private val bookRepository: BookRepository) {

    fun createNewBook(bookDto: BookCreateRequestDto): BookResponseDto {
        val newBook = bookRepository.save(bookDto.toEntity())
        return BookResponseDto.from(newBook)
    }

    fun findAll(): List<BookResponseDto> {
        return bookRepository.findAll().map { BookResponseDto.from(it) }
    }

    fun findById(id: UUID): BookResponseDto {
        val findBook = bookRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Not Found Entity By id ( $id )") }

        return BookResponseDto.from(findBook)
    }

    @Transactional(rollbackFor = [EntityNotFoundException::class])
    fun update(id: UUID, bookDto: BookUpdateRequestDto) {
        bookRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Not Found Entity By id ( $id )") }
            .update(bookDto)
    }

    @Transactional(rollbackFor = [RuntimeException::class])
    fun delete(id: UUID) {
        bookRepository.deleteById(id)
    }
}
