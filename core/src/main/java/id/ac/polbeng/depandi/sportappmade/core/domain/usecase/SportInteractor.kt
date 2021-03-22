package id.ac.polbeng.depandi.sportappmade.core.domain.usecase

import id.ac.polbeng.depandi.sportappmade.core.data.Resource
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Sport
import id.ac.polbeng.depandi.sportappmade.core.domain.repository.ISportRepository
import kotlinx.coroutines.flow.Flow

class SportInteractor(private val sportRepository: ISportRepository): SportUseCase {
    override fun getAllSport(): Flow<Resource<List<Sport>>> = sportRepository.getAllSport()
}