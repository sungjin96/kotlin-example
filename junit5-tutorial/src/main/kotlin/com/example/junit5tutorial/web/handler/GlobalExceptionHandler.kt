package com.example.junit5tutorial.web.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.HashMap
import java.util.function.Consumer

/**
 * Created by marathoner on 2022/10/05
 */
@RestControllerAdvice
class GlobalExceptionHandler {

//    @ExceptionHandler(MethodArgumentNotValidException::class)
//    fun handleValidationExceptions(ex: MethodArgumentNotValidException): Map<String, String?> {
//
//        return errors
//    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleApiException(e: MethodArgumentNotValidException): ResponseEntity<Map<String, String?>> {
        val errors: MutableMap<String, String?> = HashMap()
        e.bindingResult.allErrors.forEach(Consumer { error: ObjectError ->
            val fieldName = (error as FieldError).field
            val errorMessage = error.getDefaultMessage()
            errors[fieldName] = errorMessage
        })
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors)
    }
}
