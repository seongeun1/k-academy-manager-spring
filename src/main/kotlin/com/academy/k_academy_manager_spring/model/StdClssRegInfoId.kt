package com.academy.k_academy_manager_spring.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable


/* class for Composite Key
 * - @Embeddable : allow to use this class's instance as other entitie's @EmbeddId
 * - Serializable : demand JPA to serialize key entities  
 * */

 @Embeddable
 data class StdClssRegInfoId(
    /* PK1. Clss_no */
    @Column(name = "clss_no", nullable = false)
    val clssNo: Int = 0,

    /* PK2. Std_no */
    @Column(name = "std_no", nullable = false)
    val stdNo: String = ""

 ) : Serializable //necessary for dulicate the key or save key in cache inside JPA
 

