package id.ac.polbeng.depandi.sportappmade.ui.favorite_player

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.polbeng.depandi.sportappmade.core.domain.usecase.SportUseCase

class FavoritePlayerViewModel(sportUseCase: SportUseCase) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }
    val text: LiveData<String> = _text
}