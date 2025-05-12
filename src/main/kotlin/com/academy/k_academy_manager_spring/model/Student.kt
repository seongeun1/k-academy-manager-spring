package com.academy.k_academy_manager_spring.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "bm_tbm_std")
data class Student(
    @Id
    @Column(length = 5)
    val std_no: String,      // StudentNo CHAR(5)

    @Column(length = 15)
    val std_nm: String,      // StudentNm CHAR(15)

    @Column(length = 8)
    val bday: String,        // Birthday CHAR(8) YYYYMMDD

    @Column(length = 11)
    val phone: String,       // PhoneNumber CHAR(11)

    @Column(length = 8)
    val erol_dt: String      // Enroll date CHAR(8)
)
