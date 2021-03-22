package id.ac.polbeng.depandi.sportappmade.core.domain.usecase

import id.ac.polbeng.depandi.sportappmade.core.data.Resource
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Sport
import kotlinx.coroutines.flow.Flow

interface SportUseCase {
    fun getAllSport(): Flow<Resource<List<Sport>>>
}