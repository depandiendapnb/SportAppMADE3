package id.ac.polbeng.depandi.sportappmade.ui.favorite_player

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.ac.polbeng.depandi.sportappmade.core.domain.usecase.SportUseCase

class FavoritePlayerViewModel(sportUseCase: SportUseCase) : ViewModel() {
    val listPlayer = sportUseCase.getAllFavoritePlayer().asLiveData()
}