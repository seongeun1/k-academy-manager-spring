package com.academy.k_academy_manager_spring.dto

/**
* DTO that maps one-to-one with the StdClssRegInfo entity.
 * Used in the API layer for JSON input/output.
 */


data class StdClssRegInfoDto(
    val clssNo: Int, //Class Number
    val stdNo: String, //Student Number
    val erolDt: String, //Enrollment Date (YYYYMMDD)
    val abndDt: String //Abandant Dt
)