package com.academy.k_academy_manager_spring.model

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

/*
 * Entity models how you persist data to the database.
 */

@Entity
@Table(name = "bm_tbd_clss_reg_info")
data class StdClssRegInfo(
    //use StdClssRegInfoId() Entity as primary key */
    @EmbeddedId
    val id: StdClssRegInfoId = StdClssRegInfoId(),
    
 
    @Column(name = "erol_dt", length=8, nullable = false)
    val erolDt: String = "",

    @Column(name = "abnd_dt", length=8, nullable = false)
    val abndDt: String = ""

)

