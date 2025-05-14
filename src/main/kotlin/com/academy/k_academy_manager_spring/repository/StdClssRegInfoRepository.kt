package com.academy.k_academy_manager_spring.repository

import com.academy.k_academy_manager_spring.model.StdClssRegInfo
import com.academy.k_academy_manager_spring.model.StdClssRegInfoId

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.Query




@Repository
interface StdClssRegInfoRepository : JpaRepository<StdClssRegInfo, StdClssRegInfoId>{
    //Primary key's type for this table is StdClssRegInfoId (Not defined in StdClssRegInfo)
    
    //find with only one key of primary keys
    fun findAllByIdClssNo(clssNo: Int): List<StdClssRegInfo>
   
    fun findAllByIdStdNo(stdNo: String): List<StdClssRegInfo>
}
