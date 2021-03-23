package id.ac.polbeng.depandi.sportappmade.core.data

import id.ac.polbeng.depandi.sportappmade.core.data.source.local.LocalDataSource
import id.ac.polbeng.depandi.sportappmade.core.data.source.remote.RemoteDataSource
import id.ac.polbeng.depandi.sportappmade.core.data.source.remote.network.ApiResponse
import id.ac.polbeng.depandi.sportappmade.core.data.source.remote.response.SportResponse
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Player
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Sport
import id.ac.polbeng.depandi.sportappmade.core.domain.repository.ISportRepository
import id.ac.polbeng.depandi.sportappmade.core.utils.AppExecutors
import id.ac.polbeng.depandi.sportappmade.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SportRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ISportRepository {

    override fun getAllSport(): Flow<Resource<List<Sport>>> =
        object : NetworkBoundResource<List<Sport>, List<SportResponse>>(){

            override fun loadFromDB(): Flow<List<Sport>> {
                return localDataSource.getAllSport().map {
                    DataMapper.mapSportEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Sport>?): Boolean =
                data == null || data.isEmpty() //true

            override suspend fun createCall(): Flow<ApiResponse<List<SportResponse>>> =
                remoteDataSource.getSportList()

            override suspend fun saveCallResult(data: List<SportResponse>) {
                val sportList = DataMapper.mapSportResponseToEntities(data)
                localDataSource.insertListSport(sportList)
            }
        }.asFlow()

    override suspend fun getPlayerByName(name: String): Flow<Resource<List<Player>>> =
            remoteDataSource.getPlayerByName(name).map {
                when (it) {
                    is ApiResponse.Success -> Resource.Success(DataMapper.mapPlayerResponseToDomain(it.data))
                    is ApiResponse.Empty -> Resource.Error(it.toString())
                    is ApiResponse.Error -> Resource.Error(it.errorMessage)
                }
            }

    override fun getAllFavoritePlayer(): Flow<List<Player>> =
            localDataSource.getAllFavoritePlayer().map {
                DataMapper.mapPlayerEntitiesToDomain(it)
            }

    override suspend fun insertFavoritePlayer(player: Player) {
        val playerEntity = DataMapper.mapPlayerDomainToEntity(player)
        localDataSource.insertFavoritePlayer(playerEntity)
    }

    override fun deleteFavoritePlayer(player: Player) {
        val playerEntity = DataMapper.mapPlayerDomainToEntity(player)
        appExecutors.diskIO().execute { localDataSource.deleteFavoritePlayer(playerEntity) }
    }
}