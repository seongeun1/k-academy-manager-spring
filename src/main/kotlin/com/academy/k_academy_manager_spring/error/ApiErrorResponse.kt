package com.academy.k_academy_manager_spring.error

import java.time.LocalDateTime

data class ApiErrorResponse(
    val timestamp: LocalDateTime = LocalDateTime.now(), //when the error happens
    val status: Int,  //HTTP info
    val error: String, //HTTP info
    val path: String, //the request URL
    val fieldErrors: List<FieldError>? = null, //list for validation failures
    val message: String //my own message for error
)

data class FieldError(
    val field: String,
    val message: String
)