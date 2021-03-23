package id.ac.polbeng.depandi.sportappmade.core.utils

import id.ac.polbeng.depandi.sportappmade.core.data.source.local.entity.PlayerEntity
import id.ac.polbeng.depandi.sportappmade.core.data.source.local.entity.SportEntity
import id.ac.polbeng.depandi.sportappmade.core.data.source.remote.response.PlayerResponse
import id.ac.polbeng.depandi.sportappmade.core.data.source.remote.response.SportResponse
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Player
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
    fun mapPlayerResponseToDomain(playerResponseList: List<PlayerResponse>): List<Player>{
        val playerList = ArrayList<Player>()
        playerResponseList.map {
            val player = Player(
                    idPlayer = it.idPlayer,
                    idTeam = it.idTeam,
                    strNationality = it.strNationality,
                    strPlayer = it.strPlayer,
                    strTeam = it.strTeam,
                    strSport = it.strSport,
                    dateBorn = it.dateBorn,
                    strBirthLocation = it.strBirthLocation,
                    strDescriptionEN = it.strDescriptionEN,
                    strGender = it.strGender,
                    strPosition = it.strPosition,
                    strFacebook = it.strFacebook,
                    strTwitter = it.strTwitter,
                    strInstagram = it.strInstagram,
                    strHeight = it.strHeight,
                    strWeight = it.strWeight,
                    strThumb = it.strThumb
            )
            playerList.add(player)
        }
        return playerList
    }
    fun mapPlayerDomainToEntity(player: Player) : PlayerEntity =
            PlayerEntity(
                    idPlayer = player.idPlayer,
                    idTeam = player.idTeam,
                    strNationality = player.strNationality,
                    strPlayer = player.strPlayer,
                    strTeam = player.strTeam,
                    strSport = player.strSport,
                    dateBorn = player.dateBorn,
                    strBirthLocation = player.strBirthLocation,
                    strDescriptionEN = player.strDescriptionEN,
                    strGender = player.strGender,
                    strPosition = player.strPosition,
                    strFacebook = player.strFacebook,
                    strTwitter = player.strTwitter,
                    strInstagram = player.strInstagram,
                    strHeight = player.strHeight,
                    strWeight = player.strWeight,
                    strThumb = player.strThumb
            )
    fun mapPlayerEntitiesToDomain(playerEntities: List<PlayerEntity>) : List<Player> {
        val playerList = ArrayList<Player>()
        playerEntities.map {
            val player = Player(
                    idPlayer = it.idPlayer,
                    idTeam = it.idTeam,
                    strNationality = it.strNationality,
                    strPlayer = it.strPlayer,
                    strTeam = it.strTeam,
                    strSport = it.strSport,
                    dateBorn = it.dateBorn,
                    strBirthLocation = it.strBirthLocation,
                    strDescriptionEN = it.strDescriptionEN,
                    strGender = it.strGender,
                    strPosition = it.strPosition,
                    strFacebook = it.strFacebook,
                    strTwitter = it.strTwitter,
                    strInstagram = it.strInstagram,
                    strHeight = it.strHeight,
                    strWeight = it.strWeight,
                    strThumb = it.strThumb
            )
            playerList.add(player)
        }
        return playerList
    }
}