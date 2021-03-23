package id.ac.polbeng.depandi.sportappmade.core.data.source.remote.network

import id.ac.polbeng.depandi.sportappmade.core.data.source.remote.response.ListPlayerResponse
import id.ac.polbeng.depandi.sportappmade.core.data.source.remote.response.ListSportResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("all_sports.php")
    suspend fun getSportList(): ListSportResponse

    @GET("searchplayers.php")
    suspend fun getPlayerByName(
            @Query("p") name : String
    ): ListPlayerResponse
}