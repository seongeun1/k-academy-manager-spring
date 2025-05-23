//API Controller
package com.academy.k_academy_manager_spring.controller

import com.academy.k_academy_manager_spring.model.Student
import com.academy.k_academy_manager_spring.service.StudentService

import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory


@Tag(name = "students", description="Manage Student Info API")
@RestController
@RequestMapping("/api/students")
class StudentController(private val studentService: StudentService) {

    private val log = LoggerFactory.getLogger(javaClass)

    @Operation(
        summary = "Get students' list", 
        description = "Get all students' data without paging"
    )
    @GetMapping
    fun getAllStudents() : List<Student>{
        log.info("◼︎◼︎◼︎◼︎ GET /api/students ▶ getAllstudents()")
        return studentService.genAllStudents()
    }

    @Operation(
        summary = "Get each student's data", 
        description = "Get each student's data with his student number"
    )
    @GetMapping("/{stdNo}")
    fun getStudentById(
        @Parameter(description = "Student No", example = "00005")
        @PathVariable stdNo: String
        ) : Student? {

        log.info("◼︎◼︎◼︎◼︎ Get /api/students/$stdNo")
        return studentService.getStudentById(stdNo)
    }

    @Operation(
        summary = "Create New Student", 
        description = "Save new student's data"
    )
    @PostMapping
    fun createStudent(@RequestBody student: Student) : Student{

        log.info("◼︎◼︎◼︎◼︎ Post /api/students ▶ createStudent() input $student")
        return studentService.createStudent(student)
    }  

    @Operation(
        summary = "Update student's data", 
        description = "Update student's data using his student number and new information"
    )
    @PutMapping("/{stxdNo}")
    fun updateStudent(@PathVariable stdNo: String, @RequestBody student:Student) : Student? {
        log.info("◼︎◼︎◼︎◼︎ Put /api/students/$stdNo ▶ UpdateStudent() input $student")
        return studentService.updateStudent(stdNo, student) 
    }

    @Operation(
        summary = "Delete student's information", 
        description = "Remove student's information using his student number"
    )
    @DeleteMapping("/{stdNo}")
    fun deleteStudent(@PathVariable stdNo: String) {
        log.info("◼︎◼︎◼︎◼︎ Put /api/students/$stdNo ▶ deleteStudent()")
        return studentService.deleteStudent(stdNo)


    } 
}
