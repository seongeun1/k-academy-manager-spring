//Interface to connect DB
package com.academy.k_academy_manager_spring.repository


import com.academy.k_academy_manager_spring.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.Query

@Repository
interface StudentRepository : JpaRepository<Student, String>{
    @Query(value = "SELECT COALESCE(MAX(std_no), '00000') FROM bm_tbm_std", nativeQuery = true)
    fun findMaxStdNo() : String

    

}
