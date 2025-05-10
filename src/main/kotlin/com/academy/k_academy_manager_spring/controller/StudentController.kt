//API Controller
package com.academy.k_academy_manager_spring.controller

import com.academy.k_academy_manager_spring.model.Student
import com.academy.k_academy_manager_spring.service.StudentService

import org.springframework.web.bind.annotation.*



@RestController
@RequestMapping("/api/Students")
class StudentController(private val studentService: StudentService) {

    @GetMapping
    fun getAllStudents() = studentService.genAllStudents()

    @GetMapping("/{stdNo}")
    fun getStudentById(@PathVariable stdNo: String) = studentService.getStudentById(stdNo)

    @PostMapping
    fun createStudent(@RequestBody student: Student) = studentService.createStudent(student)

    @PutMapping("/{stdNo}")
    fun updateStudent(@PathVariable stdNo: String, @RequestBody student:Student) =
        studentService.updateStudent(stdNo, student) 

    @DeleteMapping("/{stdNo}")
    fun deleteStudent(@PathVariable stdNo: String) = studentService.deleteStudent(stdNo)

}
