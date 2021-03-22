package id.ac.polbeng.depandi.sportappmade.ui.sport

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.ac.polbeng.depandi.sportappmade.core.domain.usecase.SportUseCase

class SportViewModel(sportUseCase: SportUseCase) : ViewModel() {

    val sportList = sportUseCase.getAllSport().asLiveData()
}