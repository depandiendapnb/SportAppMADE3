package id.ac.polbeng.depandi.sportappmade.core.data.source.remote.network

import id.ac.polbeng.depandi.sportappmade.core.data.source.remote.response.ListSportResponse
import retrofit2.http.GET

interface ApiService {
    @GET("all_sports.php")
    suspend fun getSportList(): ListSportResponse
}