//API Controller
package com.academy.k_academy_manager_spring.controller


import com.academy.k_academy_manager_spring.dto.*
import com.academy.k_academy_manager_spring.service.StdClssRegInfoService
import com.academy.k_academy_manager_spring.model.StdClssRegInfoId
import com.academy.k_academy_manager_spring.repository.StdClssRegInfoRepository

import org.springframework.web.bind.annotation.*
import org.slf4j.LoggerFactory


@RestController
@RequestMapping("/api/registration")
class StdClssRegInfoController(private val serv: StdClssRegInfoService) {

    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping
    fun getAll() : List<StdClssRegInfoDto>{
        log.info("◼︎◼︎◼︎◼︎ GET /api/registration ▶ getAll()")
        return serv.genAll()
    }

    @GetMapping("/std/{stdNo}")
    fun getByStd(@PathVariable stdNo: String) : List<StdClssRegInfoDto> {
        log.info("◼︎◼︎◼︎◼︎ Get /api/students/$stdNo")
        return serv.getByStd(stdNo)
    }

    @GetMapping("/clss/{clssNo}")
    fun getByStd(@PathVariable clssNo: Int) : List<StdClssRegInfoDto> {
        log.info("◼︎◼︎◼︎◼︎ Get /api/students/$clssNo")
        return serv.getByClss(clssNo)
    }
    
    @PostMapping
    fun createRegistration(@RequestBody dto: StdClssRegInfoDto) : StdClssRegInfoDto{

        log.info("◼︎◼︎◼︎◼︎ Post /api/students ▶ createStudent() input $dto")
        return serv.createStdClssRegInfo(dto)
    }  

    @PutMapping("upd/{clssNo}/{stdNo}")
    fun updateStdClssRegInfo(
        @PathVariable clssNo : Int, 
        @PathVariable stdNo : String, 
        @RequestBody dto:StdClssRegInfoDto) : StdClssRegInfoDto? {
        log.info("◼︎◼︎◼︎◼︎ Put /api/registration/$clssNo/$stdNo ▶ updateStudent() input $dto")
        return serv.updateStdClssRegInfo(clssNo, stdNo, dto) }


    @PutMapping("abnd/{clssNo}/{stdNo}")
    fun abndStdClssRegInfo(@PathVariable clssNo : Int, @PathVariable stdNo : String) : StdClssRegInfoDto? {
        log.info("◼︎◼︎◼︎◼︎ Put /api/registration/abnd/$clssNo/$stdNo ▶ abndStudent()")
        return serv.abndStdClssRegInfo(clssNo, stdNo) 
    }


}
