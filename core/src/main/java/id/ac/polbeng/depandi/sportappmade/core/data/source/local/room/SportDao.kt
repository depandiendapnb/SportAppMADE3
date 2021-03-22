package id.ac.polbeng.depandi.sportappmade.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.ac.polbeng.depandi.sportappmade.core.data.source.local.entity.SportEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SportDao {
    @Query("SELECT * FROM tb_sport")
    fun getAllSport(): Flow<List<SportEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListSport(sportList: List<SportEntity>)
}