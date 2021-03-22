package id.ac.polbeng.depandi.sportappmade.core.domain.repository

import id.ac.polbeng.depandi.sportappmade.core.data.Resource
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Sport
import kotlinx.coroutines.flow.Flow

interface ISportRepository {
    fun getAllSport(): Flow<Resource<List<Sport>>>
}