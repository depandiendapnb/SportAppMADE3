package id.ac.polbeng.depandi.sportappmade.core.utils

import id.ac.polbeng.depandi.sportappmade.core.data.source.local.entity.SportEntity
import id.ac.polbeng.depandi.sportappmade.core.data.source.remote.response.SportResponse
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Sport

object DataMapper {
    fun mapSportResponseToEntities(sportResponseList: List<SportResponse>): List<SportEntity>{
        val sportEntityList = ArrayList<SportEntity>()
        sportResponseList.map {
            val sportEntity = SportEntity(
                idSport = it.idSport,
                strSport = it.strSport,
                strFormat = it.strFormat,
                strSportThumb = it.strSportThumb,
                strSportDescription = it.strSportDescription
            )
            sportEntityList.add(sportEntity)
        }
        return sportEntityList
    }
    fun mapSportEntitiesToDomain(sportEntityList: List<SportEntity>): List<Sport> =
        sportEntityList.map {
            Sport(
                idSport = it.idSport,
                strSport = it.strSport,
                strFormat = it.strFormat,
                strSportThumb = it.strSportThumb,
                strSportDescription = it.strSportDescription
            )
        }
}