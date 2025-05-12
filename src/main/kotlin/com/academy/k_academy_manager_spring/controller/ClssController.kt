//API Controller
package com.academy.k_academy_manager_spring.controller

import com.academy.k_academy_manager_spring.model.Clss
import com.academy.k_academy_manager_spring.service.ClssService

import org.springframework.web.bind.annotation.*
import org.slf4j.LoggerFactory


@RestController
@RequestMapping("/api/clss")
class ClssController(private val clssService: ClssService) {

    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping
    fun getAllClss() : List<Clss>{
        log.info("◼︎◼︎◼︎◼︎ GET /api/clss ▶ getAllClss()")
        return clssService.getAllClss()
    }

    @GetMapping("/{clssNo}")
    fun getClssById(@PathVariable clssNo: Int) : Clss? {
        log.info("◼︎◼︎◼︎◼︎ Get /api/clss/$clssNo")
        return clssService.getClssById(clssNo)
    }
    @PostMapping
    fun createClss(@RequestBody clss: Clss) : Clss{

        log.info("◼︎◼︎◼︎◼︎ Post /api/students ▶ createStudent() input $clss")
        return clssService.createClss(clss)
    }  

    @PutMapping("/{clssNo}")
    fun updateClss(@PathVariable clssNo: Int, @RequestBody clss:Clss) : Clss? {
        log.info("◼︎◼︎◼︎◼︎ Put /api/students/$clssNo ▶ UpdateStudent() input $clss")
        return clssService.updateClss(clssNo, clss) 
    }

    @DeleteMapping("/{clssNo}")
    fun deleteClss(@PathVariable clssNo: Int) {
        log.info("◼︎◼︎◼︎◼︎ Put /api/students/$clssNo ▶ deleteStudent()")
        return clssService.deleteClss(clssNo)

    } 
}
