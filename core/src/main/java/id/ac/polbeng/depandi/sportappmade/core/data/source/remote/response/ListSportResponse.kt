package id.ac.polbeng.depandi.sportappmade.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListSportResponse (
    @field:SerializedName("sports")
    val sports: List<SportResponse>
)
