//API Controller
package com.academy.k_academy_manager_spring.controller

import com.academy.k_academy_manager_spring.model.Student
import com.academy.k_academy_manager_spring.service.StudentService

import org.springframework.web.bind.annotation.*
import org.slf4j.LoggerFactory


@RestController
@RequestMapping("/api/students")
class StudentController(private val studentService: StudentService) {

    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping
    fun getAllStudents() : List<Student>{
        log.info("◼︎◼︎◼︎◼︎ GET /api/students ▶ getAllstudents()")
        return studentService.genAllStudents()
    }

    @GetMapping("/{stdNo}")
    fun getStudentById(@PathVariable stdNo: String) : Student? {
        log.info("◼︎◼︎◼︎◼︎ Get /api/students/$stdNo")
        return studentService.getStudentById(stdNo)
    }
    @PostMapping
    fun createStudent(@RequestBody student: Student) : Student{

        log.info("◼︎◼︎◼︎◼︎ Post /api/students ▶ createStudent() input $student")
        return studentService.createStudent(student)
    }  

    @PutMapping("/{stdNo}")
    fun updateStudent(@PathVariable stdNo: String, @RequestBody student:Student) : Student? {
        log.info("◼︎◼︎◼︎◼︎ Put /api/students/$stdNo ▶ UpdateStudent() input $student")
        return studentService.updateStudent(stdNo, student) 
    }

    @DeleteMapping("/{stdNo}")
    fun deleteStudent(@PathVariable stdNo: String) {
        log.info("◼︎◼︎◼︎◼︎ Put /api/students/$stdNo ▶ deleteStudent()")
        return studentService.deleteStudent(stdNo)


    } 
}
