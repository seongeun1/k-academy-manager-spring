//Interface to connect DB
package com.academy.k_academy_manager_spring.repository


import com.academy.k_academy_manager_spring.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student, String>{
    @Query("SELECT COALESCE(MAX(std_no), '00000') FROM bm_tbm_std")
    fun findMaxStdNo() : String

    

}
