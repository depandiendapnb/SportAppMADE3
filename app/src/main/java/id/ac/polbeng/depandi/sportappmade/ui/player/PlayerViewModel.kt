package id.ac.polbeng.depandi.sportappmade.ui.player

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.polbeng.depandi.sportappmade.core.domain.usecase.SportUseCase

class PlayerViewModel(sportUseCase: SportUseCase) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text
}