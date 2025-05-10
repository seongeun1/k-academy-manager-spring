//Business Logic
package com.academy.k_academy_manager_spring.service

import com.academy.k_academy_manager_spring.model.Student
import com.academy.k_academy_manager_spring.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService(private val studentRepository: StudentRepository ){
    fun genAllStudents(): List<Student> = studentRepository.findAll()
    
    fun getStudentById(stdNo: String): Student? = studentRepository.findById(stdNo).orElse(null)
    
    fun createStudent(student: Student): Student {
       val maxStdNo = studentRepository.findMaxStdNo()
       val nextStdNo = generateNextStdNo(maxStdNo)

       val newStudent = student.copy(std_no = nextStdNo)
       return studentRepository.save(newStudent)

    }
    fun updateStudent(stdNo: String, student: Student): Student?{
        return if (studentRepository.existsById(stdNo)) {
            studentRepository.save(student.copy(std_no = stdNo))
        } else null
    }

    fun deleteStudent(stdNo: String) {
        studentRepository.deleteById(stdNo)
    }
}

//generate next student No
private fun generateNextStdNo (maxStdNo : String): String {
    val nextNo = maxStdNo.toInt() + 1
    return nextNo.toString().padStart(5, '0')

}