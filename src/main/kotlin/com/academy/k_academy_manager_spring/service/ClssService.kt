//Business Logic
package com.academy.k_academy_manager_spring.service


import com.academy.k_academy_manager_spring.model.Clss
import com.academy.k_academy_manager_spring.repository.ClssRepository
import com.academy.k_academy_manager_spring.service.EmpService
import org.springframework.stereotype.Service



@Service
class ClssService
(private val clssRepository: ClssRepository 
, private val empService: EmpService)
{
    fun getAllClss(): List<Clss> = clssRepository.findAll()
    
    fun getClssById(clssNo: Int): Clss? = clssRepository.findById(clssNo).orElse(null)
    
    fun createClss(clss: Clss): Clss {
       val empInfo = empService.getEmpById(clss.emp_no)
       ?: throw IllegalArgumentException("No such employee: ${clss.emp_no}")
       
       val clssWithEmpNm = clss.copy(emp_nm = empInfo.emp_nm, subject = empInfo.subject)
       return clssRepository.save(clssWithEmpNm)

    }
    fun updateClss(clssNo: Int, clss: Clss): Clss?{
        return if (clssRepository.existsById(clssNo)) {
            clssRepository.save(clss.copy(clss_no = clssNo))
        } else null
    }

    fun deleteClss(clssNo: Int) {
        clssRepository.deleteById(clssNo)
    }
}

//generate next student No
private fun generateNextStdNo (maxStdNo : String): String {
    val nextNo = maxStdNo.toInt() + 1
    return nextNo.toString().padStart(5, '0')

}