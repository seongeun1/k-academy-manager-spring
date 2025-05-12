package com.academy.k_academy_manager_spring.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "bm_tbm_emp")
data class Emp(
    @Id
    @Column(name = "emp_id", length = 5)
    val emp_no: String,      

    @Column(length = 15)
    val emp_nm: String,      

    @Column(length = 1)
    val sex: String,       

    @Column(length = 15)
    val subject: String,       

    @Column(length = 8)
    val emp_srt_dt: String,
    
    @Column(length = 8)
    val emp_end_dt: String   

)

