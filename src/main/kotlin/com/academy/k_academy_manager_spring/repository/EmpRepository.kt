//Interface to connect DB
package com.academy.k_academy_manager_spring.repository


import com.academy.k_academy_manager_spring.model.Emp
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.Query

@Repository
interface EmpRepository : JpaRepository<Emp, String>{
    @Query(value = "SELECT COALESCE(MAX(emp_no), '00000') FROM bm_tbm_emp", nativeQuery = true)
    fun findMaxEmpNo() : String

    

}
