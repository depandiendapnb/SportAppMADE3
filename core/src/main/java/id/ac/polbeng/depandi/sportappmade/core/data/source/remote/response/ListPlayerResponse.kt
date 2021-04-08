package id.ac.polbeng.depandi.sportappmade.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListPlayerResponse(
    @field:SerializedName("player")
    val players: List<PlayerResponse>
)
