package com.academy.k_academy_manager_spring.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType 

@Entity
@Table(name = "bm_tbm_clss")
data class Clss(
    @Id
    @SequenceGenerator(
        name = "clss_seq",             // JPA 안에서 사용할 이름
        sequenceName = "clss_seq",     // 실제 DB 시퀀스 이름
        initialValue = 101,            // from 101
        allocationSize = 1             // add 1 at once
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "clss_seq"
    )
    @Column(name = "clss_no")
    val clss_no: Int,      

    @Column(name = "clss_nm", length = 100)
    val clss_nm: String,     

    @Column(name = "subject", length = 15)
    val subject: String ? = null, //fill this part in Service      

    @Column(name = "clss_srt_dt", length = 8)
    val clss_srt_dt: String,      

    @Column(name = "clss_end_dt", length = 8)
    val clss_end_dt: String,

    @Column(name = "emp_id", length = 5)
    val emp_no: String,      

    @Column(name = "emp_nm", length = 15)
    val emp_nm: String ? = null //fill this part in Service
)
