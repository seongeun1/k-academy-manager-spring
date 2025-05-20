//API Controller
package com.academy.k_academy_manager_spring.controller


import com.academy.k_academy_manager_spring.dto.*
import com.academy.k_academy_manager_spring.service.StdClssRegInfoService
import com.academy.k_academy_manager_spring.model.StdClssRegInfoId
import com.academy.k_academy_manager_spring.repository.StdClssRegInfoRepository


import org.springframework.http.ResponseEntity
import java.net.URI

import org.springframework.web.bind.annotation.*

import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import org.slf4j.LoggerFactory
import jakarta.validation.constraints.*
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated


@RestController
@RequestMapping("/api/registration")
class StdClssRegInfoController(private val serv: StdClssRegInfoService) {

    private val log = LoggerFactory.getLogger(javaClass)
    private var dto: StdClssRegInfoDto? = null

    @GetMapping
    fun getAll(): ResponseEntity<List<StdClssRegInfoDto>> {
        log.info("◼︎◼︎◼︎◼︎ GET /api/registration ▶ getAll()")
        val list: List<StdClssRegInfoDto> = serv.genAll()

        return if (list.isNotEmpty()) {
            ResponseEntity.ok(list)
        } else {
            ResponseEntity.noContent().build()
        }
    }

    @GetMapping("/std/{stdNo}")
    fun getByStd(@PathVariable stdNo: String): ResponseEntity<List<StdClssRegInfoDto>> {
        log.info("◼︎◼︎◼︎◼︎ Get /api/students/$stdNo")
        val list: List<StdClssRegInfoDto> = serv.getByStd(stdNo)

        return if (list.isNotEmpty()) {
            ResponseEntity.ok(list)
        } else {
            ResponseEntity.noContent().build()
        }
    }

    @GetMapping("/clss/{clssNo}")
    fun getByClss(@PathVariable clssNo: Int): ResponseEntity<List<StdClssRegInfoDto>> {
        log.info("◼︎◼︎◼︎◼︎ Get /api/students/$clssNo")
        val list: List<StdClssRegInfoDto> = serv.getByClss(clssNo)

        return if (list.isNotEmpty()) {
            ResponseEntity.ok(list)
        } else {
            ResponseEntity.noContent().build()
        } 
    }
    
    @PostMapping
    fun createRegistration(@Valid @RequestBody dto: StdClssRegInfoDto): ResponseEntity<StdClssRegInfoDto>{

        log.info("◼︎◼︎◼︎◼︎ Post /api/students ▶ createStudent() input $dto")
        val newReg: StdClssRegInfoDto = serv.createStdClssRegInfo(dto)
        
        val location: URI = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{clssNo}/{dto.stdNo}")
        .buildAndExpand(newReg.clssNo, newReg.stdNo)
        .toUri()

        return ResponseEntity.created(location).body(newReg)

    }  

    @PutMapping("upd/{clssNo}/{stdNo}")
    fun updateStdClssRegInfo(
        @PathVariable clssNo : Int, 
        @PathVariable stdNo : String, 
        @RequestBody dto:StdClssRegInfoDto): ResponseEntity<StdClssRegInfoDto>? {
        log.info("◼︎◼︎◼︎◼︎ Put /api/registration/$clssNo/$stdNo ▶ updateStudent() input $dto")
        val updReg: StdClssRegInfoDto? = serv.updateStdClssRegInfo(clssNo, stdNo, dto)

        return if (updReg != null){
            ResponseEntity.ok().body(updReg)
        } else {
            ResponseEntity.badRequest().build()
        }
    }


    @PutMapping("abnd/{clssNo}/{stdNo}")
    fun abndStdClssRegInfo(@PathVariable clssNo : Int, @PathVariable stdNo : String) : ResponseEntity<StdClssRegInfoDto>? {
        log.info("◼︎◼︎◼︎◼︎ Put /api/registration/abnd/$clssNo/$stdNo ▶ abndStudent()")

        val abndReg: StdClssRegInfoDto? = serv.abndStdClssRegInfo(clssNo, stdNo)

        return if (abndReg != null){
            ResponseEntity.ok().body(abndReg)
        } else {
            ResponseEntity.badRequest().build()
        }

    }


}
