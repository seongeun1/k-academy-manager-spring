package com.academy.k_academy_manager_spring.dto
import jakarta.validation.constraints.*


/**
 * DTO that maps one-to-one with the StdClssRegInfo entity.
 * Used in the API layer for JSON input/output (Thin contract boundary)
 * DTO models exactly what my controller expects from the client.
 * DTO avoids invalid paylode ever reaches my sevice layer
 * When you read data in  : Incoming JSON → [@Valid] → Request DTO → Service → Entity → Repository → Database
 * When you read data out : Entity → map → Response DTO → JSON → HTTP client
 */


data class StdClssRegInfoDto(
    
    @field:NotNull(message = "Class Number is required")
    val clssNo: Int, //Class Number 

    @field:NotNull(message = "Student Number is required")
    @field:Size(min=5, max=5, message="Stuent Number length is 5")
    val stdNo: String, //Student Number

    @field:Pattern(
        regexp="\\d{8}",
        message = "Enrollment Date must be in YYYYMMDD format but automatically become the current date"
    )
    val erolDt: String, //Enrollment Date (YYYYMMDD)

    @field:Pattern(
        regexp="\\d{8}",
        message = "Abandonment Date must be in YYYYMMDD format but automatically become the datewhen student abandons the class"
    )
    val abndDt: String //Abandant Dt
)