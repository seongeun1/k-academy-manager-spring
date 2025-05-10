//Entity for Student.kt
package com.academy.k_academy_manager_spring.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Student(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val std_no: String ="",     //StudentNo Char(5)
    val std_nm: String,         //StudentNm Char(15)
    val bday : String,          //Birthday Char(8) YYYYMMDD
    val phone : String,         //PhoneNumber char(11)
    val erol_dt : String        //Enroll date char(8)
)