package id.ac.polbeng.depandi.sportappmade.ui.player

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import id.ac.polbeng.depandi.sportappmade.core.data.Resource
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Player
import id.ac.polbeng.depandi.sportappmade.core.domain.usecase.SportUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class PlayerViewModel(private val sportUseCase: SportUseCase) : ViewModel() {

    lateinit var listPlayer: LiveData<Resource<List<Player>>>

    fun getPlayerByName(name: String) = viewModelScope.launch {
        listPlayer = sportUseCase.getPlayerByName(name)
                .onStart {
                    emit(Resource.Loading())
                    Log.d("PlayerViewModel", "getPlayerByName: $name")
                }
                .catch { exception -> Resource.Error(exception.toString(), null) }
                .asLiveData()
    }
}