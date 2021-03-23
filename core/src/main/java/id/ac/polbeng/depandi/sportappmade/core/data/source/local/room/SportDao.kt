package id.ac.polbeng.depandi.sportappmade.core.data.source.local.room

import androidx.room.*
import id.ac.polbeng.depandi.sportappmade.core.data.source.local.entity.PlayerEntity
import id.ac.polbeng.depandi.sportappmade.core.data.source.local.entity.SportEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SportDao {
    @Query("SELECT * FROM tb_sport")
    fun getAllSport(): Flow<List<SportEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListSport(sportList: List<SportEntity>)

    @Query("SELECT * FROM tb_favorite_player")
    fun getAllFavoritePlayer(): Flow<List<PlayerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoritePlayer(player: PlayerEntity)

    @Delete
    fun deleteFavoritePlayer(player: PlayerEntity)
}