package com.academy.k_academy_manager_spring.error


import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.context.request.WebRequest
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

import org.springframework.validation.FieldError


import com.academy.k_academy_manager_spring.error.ApiErrorResponse
import jakarta.persistence.EntityNotFoundException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(
        ex: MethodArgumentNotValidException,
        request: WebRequest
    ): ResponseEntity<ApiErrorResponse>{
        val fieldErrors = ex.bindingResult
        .fieldErrors
        .map{ FieldError(it.field, it.defaultMessage ?: "Invalid value")}

        val body = ApiErrorResponse(
            status       = HttpStatus.BAD_REQUEST.value(),
            error        = HttpStatus.BAD_REQUEST.reasonPhrase,
            path         = request.getDescription(false).removePrefix("uri="),
            fieldErrors  = fieldErrors,
            message       = "MethodArgumentNotValidException"

        )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body)
    }

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleNotFound(
        ex: MethodArgumentNotValidException,
        request: WebRequest
    ): ResponseEntity<ApiErrorResponse>{

        val body = ApiErrorResponse(
            status       = HttpStatus.BAD_REQUEST.value(),
            error        = HttpStatus.BAD_REQUEST.reasonPhrase,
            path         = request.getDescription(false).removePrefix("uri="),
            message      = "EntityNotFoundException"
        )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body)
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    fun handleHttpVerbError(
        ex: HttpRequestMethodNotSupportedException,
        request: WebRequest
    ): ResponseEntity<ApiErrorResponse>{

        val body = ApiErrorResponse(
            status = HttpStatus.BAD_REQUEST.value(),
            error  = HttpStatus.BAD_REQUEST.reasonPhrase,
            path = request.getDescription(false).removePrefix("uri="),
            message = "HttpRequestMethodNotSupportedException"

        )
        return ResponseEntity.badRequest().body(body)
    }
    
}