package id.ac.polbeng.depandi.sportappmade.core.data.source.local

import id.ac.polbeng.depandi.sportappmade.core.data.source.local.entity.PlayerEntity
import id.ac.polbeng.depandi.sportappmade.core.data.source.local.entity.SportEntity
import id.ac.polbeng.depandi.sportappmade.core.data.source.local.room.SportDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val sportDao: SportDao) {
    fun getAllSport(): Flow<List<SportEntity>> = sportDao.getAllSport()
    suspend fun insertListSport(sportList: List<SportEntity>) = sportDao.insertListSport(sportList)
    fun getAllFavoritePlayer(): Flow<List<PlayerEntity>> = sportDao.getAllFavoritePlayer()
    suspend fun insertFavoritePlayer(player: PlayerEntity) = sportDao.insertFavoritePlayer(player)
    fun deleteFavoritePlayer(player: PlayerEntity) = sportDao.deleteFavoritePlayer(player)
}