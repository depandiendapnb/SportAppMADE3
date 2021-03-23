package id.ac.polbeng.depandi.sportappmade.core.ui

import id.ac.polbeng.depandi.sportappmade.core.domain.model.Player

interface PlayerFragmentCallback {
    fun onItemClick(player: Player)
}