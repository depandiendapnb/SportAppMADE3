package id.ac.polbeng.depandi.sportappmade.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.polbeng.depandi.sportappmade.core.data.source.local.entity.PlayerEntity
import id.ac.polbeng.depandi.sportappmade.core.data.source.local.entity.SportEntity

@Database(entities = [SportEntity::class, PlayerEntity::class], version = 1, exportSchema = false)
abstract class SportDatabase : RoomDatabase(){
    abstract fun sportDao(): SportDao
}