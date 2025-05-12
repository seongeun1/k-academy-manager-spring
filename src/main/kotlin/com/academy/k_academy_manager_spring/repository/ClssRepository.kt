//Interface to connect DB
package com.academy.k_academy_manager_spring.repository


import com.academy.k_academy_manager_spring.model.Clss
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.Query

@Repository
interface ClssRepository : JpaRepository<Clss, Int>{
    //Primary key's type for this table is Integer
    

}
