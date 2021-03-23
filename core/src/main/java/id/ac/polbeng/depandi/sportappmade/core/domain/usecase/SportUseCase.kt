package id.ac.polbeng.depandi.sportappmade.core.domain.usecase

import id.ac.polbeng.depandi.sportappmade.core.data.Resource
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Player
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Sport
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

interface SportUseCase {
    fun getAllSport(): Flow<Resource<List<Sport>>>
    suspend fun getPlayerByName(
            @Query("p") name : String
    ): Flow<Resource<List<Player>>>
    fun getAllFavoritePlayer(): Flow<List<Player>>
    suspend fun insertFavoritePlayer(player: Player)
    fun deleteFavoritePlayer(player: Player)
}