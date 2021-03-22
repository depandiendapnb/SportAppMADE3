package id.ac.polbeng.depandi.sportappmade.core.data.source.remote

import android.util.Log
import id.ac.polbeng.depandi.sportappmade.core.data.source.remote.network.ApiResponse
import id.ac.polbeng.depandi.sportappmade.core.data.source.remote.network.ApiService
import id.ac.polbeng.depandi.sportappmade.core.data.source.remote.response.SportResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getSportList(): Flow<ApiResponse<List<SportResponse>>> {
        return flow {
            try {
                val response = apiService.getSportList()
                val dataArray = response.sports
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.sports))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}