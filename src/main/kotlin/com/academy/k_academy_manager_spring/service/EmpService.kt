//Business Logic
package com.academy.k_academy_manager_spring.service


import com.academy.k_academy_manager_spring.model.Emp
import com.academy.k_academy_manager_spring.repository.EmpRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter
@Service
class EmpService(private val empRepository: EmpRepository ){
    fun genAllEmp(): List<Emp> = empRepository.findAll()
    
    fun getEmpById(empNo: String): Emp? = empRepository.findById(empNo).orElse(null)
    
    fun createEmp(emp: Emp): Emp {
       val maxEmpNo = empRepository.findMaxEmpNo()
       val nextEmpNo = generateNextEmpNo(maxEmpNo)
       val newEmp = emp.copy(empNo = nextEmpNo)
       return empRepository.save(newEmp)

    }
    fun updateEmp(empNo: String, emp: Emp): Emp?{
        return if (empRepository.existsById(empNo)) {
            empRepository.save(emp.copy(empNo = empNo))
        } else null
    }

    fun deleteEmp(empNo: String) {
        empRepository.deleteById(empNo)
    }
}

//generate next student No
private fun generateNextEmpNo (maxEmpNo : String): String {
    val nextNo = maxEmpNo.toInt() + 1
    return nextNo.toString().padStart(5, '0')

}