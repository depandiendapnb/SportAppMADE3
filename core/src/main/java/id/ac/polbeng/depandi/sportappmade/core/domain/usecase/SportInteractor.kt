package id.ac.polbeng.depandi.sportappmade.core.domain.usecase

import id.ac.polbeng.depandi.sportappmade.core.data.Resource
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Player
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Sport
import id.ac.polbeng.depandi.sportappmade.core.domain.repository.ISportRepository
import kotlinx.coroutines.flow.Flow

class SportInteractor(private val sportRepository: ISportRepository): SportUseCase {
    override fun getAllSport(): Flow<Resource<List<Sport>>> = sportRepository.getAllSport()
    override suspend fun getPlayerByName(name: String): Flow<Resource<List<Player>>> = sportRepository.getPlayerByName(name)
    override fun getAllFavoritePlayer(): Flow<List<Player>> = sportRepository.getAllFavoritePlayer()
    override suspend fun insertFavoritePlayer(player: Player) = sportRepository.insertFavoritePlayer(player)
    override fun deleteFavoritePlayer(player: Player) = sportRepository.deleteFavoritePlayer(player)
}