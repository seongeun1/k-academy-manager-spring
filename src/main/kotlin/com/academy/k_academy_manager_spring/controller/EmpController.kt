//API Controller
package com.academy.k_academy_manager_spring.controller

import com.academy.k_academy_manager_spring.model.Emp
import com.academy.k_academy_manager_spring.service.EmpService

import org.springframework.web.bind.annotation.*
import org.slf4j.LoggerFactory


@RestController
@RequestMapping("/api/emp")
class EmpController(private val empService: EmpService) {

    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping
    fun getAllEmp() : List<Emp>{
        log.info("◼︎◼︎◼︎◼︎ GET /api/emp ▶ getAllemp()")
        return empService.genAllEmp()
    }

    @GetMapping("/{empNo}")
    fun getEmpById(@PathVariable empNo: String) : Emp? {
        log.info("◼︎◼︎◼︎◼︎ Get /api/emp/$empNo")
        return empService.getEmpById(empNo)
    }
    @PostMapping
    fun createEmp(@RequestBody emp: Emp) : Emp{

        log.info("◼︎◼︎◼︎◼︎ Post /api/emp ▶ createStudent() input $emp")
        return empService.createEmp(emp)
    }  

    @PutMapping("/{empNo}")
    fun updateEmp(@PathVariable empNo: String, @RequestBody emp:Emp) : Emp? {
        log.info("◼︎◼︎◼︎◼︎ Put /api/students/$empNo ▶ UpdateStudent() input $emp")
        return empService.updateEmp(empNo, emp) 
    }

    @DeleteMapping("/{empNo}")
    fun deleteEmp(@PathVariable empNo: String) {
        log.info("◼︎◼︎◼︎◼︎ Put /api/students/$empNo ▶ deleteStudent()")
        return empService.deleteEmp(empNo)


    } 
}
