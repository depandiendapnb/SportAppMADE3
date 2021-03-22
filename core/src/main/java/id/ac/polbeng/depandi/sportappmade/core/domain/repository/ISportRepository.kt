package id.ac.polbeng.depandi.sportappmade.core.domain.repository

import com.bumptech.glide.load.engine.Resource
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Sport
import kotlinx.coroutines.flow.Flow

interface ISportRepository {
    fun getAllSport(): Flow<Resource<List<Sport>>>
}