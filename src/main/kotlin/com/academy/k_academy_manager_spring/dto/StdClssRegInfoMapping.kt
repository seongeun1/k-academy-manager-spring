package com.academy.k_academy_manager_spring.dto

import com.academy.k_academy_manager_spring.model.StdClssRegInfo
import com.academy.k_academy_manager_spring.model.StdClssRegInfoId

//Convert Entity to DTO
fun StdClssRegInfo.toDto() : StdClssRegInfoDto {
    return StdClssRegInfoDto(
        clssNo = this.id.clssNo,
        stdNo = this.id.stdNo,
        erolDt = this.erolDt,
        abndDt = this.abndDt
    )
}


// without considering composite key, be able to input/output with DTO
// Convert DTO to Entity
fun StdClssRegInfoDto.toEntity() : StdClssRegInfo {
    return StdClssRegInfo(
        id = StdClssRegInfoId(
            clssNo = this.clssNo,
            stdNo = this.stdNo
        ),
        erolDt = this.erolDt,
        abndDt = this.abndDt
    )
}