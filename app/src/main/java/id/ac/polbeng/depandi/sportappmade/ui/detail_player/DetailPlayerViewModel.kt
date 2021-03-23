package id.ac.polbeng.depandi.sportappmade.ui.detail_player

import androidx.lifecycle.*
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Player
import id.ac.polbeng.depandi.sportappmade.core.domain.usecase.SportUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class DetailPlayerViewModel(private val sportUseCase: SportUseCase) : ViewModel() {

    private val _isFavoritePlayer = MutableLiveData<Boolean>()
    var isFavoritePlayer: LiveData<Boolean> = _isFavoritePlayer

    init {
        _isFavoritePlayer.postValue(false)
    }

    fun getFavoritePlayer(player: Player) = viewModelScope.launch {
        sportUseCase.getAllFavoritePlayer().collect {
            var isFound = false
            for(item in it){
                if(item.idPlayer == player.idPlayer){
                    isFound = true
                    break
                }
            }
            _isFavoritePlayer.postValue(isFound)
        }
    }

    suspend fun insertFavoritePlayer(player: Player){
        sportUseCase.insertFavoritePlayer(player)
    }

    fun deleteFavoritePlayer(player: Player){
        sportUseCase.deleteFavoritePlayer(player)
    }
}