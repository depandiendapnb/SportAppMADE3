package id.ac.polbeng.depandi.sportappmade.ui.sport

import id.ac.polbeng.depandi.sportappmade.core.domain.model.Sport

interface SportFragmentCallback {
    fun onItemClick(sport: Sport)
}