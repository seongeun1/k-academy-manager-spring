package com.academy.k_academy_manager_spring.service

import com.academy.k_academy_manager_spring.dto.*
import com.academy.k_academy_manager_spring.model.StdClssRegInfoId
import com.academy.k_academy_manager_spring.repository.StdClssRegInfoRepository
import com.academy.k_academy_manager_spring.service.ClssService
import com.academy.k_academy_manager_spring.service.StudentService

import org.springframework.stereotype.Service
import org.springframework.data.repository.*

import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class StdClssRegInfoService(
    private val repo: StdClssRegInfoRepository,
    private val clssServ: ClssService,
    private val stdServ: StudentService)
{
    private var now = LocalDate.now()
    private var strNow = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"))

    fun genAll() : List<StdClssRegInfoDto> = repo.findAll().map{it.toDto()}
    
    fun getByClss(clssNo : Int): List<StdClssRegInfoDto> =
        repo.findAllByIdClssNo(clssNo).map{it.toDto()}

    fun getByStd(stdNo : String): List<StdClssRegInfoDto> =
        repo.findAllByIdStdNo(stdNo).map{it.toDto()}

    fun createStdClssRegInfo(dto: StdClssRegInfoDto): StdClssRegInfoDto {

        //check if there is a class with clssNo input
        val clssInfo = clssServ.getClssById(dto.clssNo)
        ?: throw IllegalArgumentException("No such class: ${dto.clssNo}")

        //check if there is a student with stdNo input
        val stdInfo = stdServ.getStudentById(dto.stdNo)
        ?: throw IllegalArgumentException("No such student: ${dto.stdNo}")


        val pkid      = StdClssRegInfoId(dto.clssNo, dto.stdNo)
        val orgDtoEnt = dto.toEntity()
      
        val DtoEnt    = orgDtoEnt.copy( id = pkid, erolDt=strNow, abndDt="99999999") //Register today
        return repo.save(DtoEnt).toDto()

    }
    fun updateStdClssRegInfo(clssNo : Int, stdNo : String, dto: StdClssRegInfoDto): StdClssRegInfoDto?{
        val pkid = StdClssRegInfoId(clssNo, stdNo)

        return if (repo.existsById(pkid)) {
            repo.save(dto.toEntity()).toDto()
        } else null
    }

    fun abndStdClssRegInfo(clssNo : Int, stdNo : String ): StdClssRegInfoDto? {
        val pkid = StdClssRegInfoId(clssNo, stdNo)
        val orgEnt = repo.findByIdOrNull(pkid) ?: return null
        val updEnt = orgEnt.copy(abndDt=strNow) //Abndand today

        return repo.save(updEnt).toDto()
          
    }


}