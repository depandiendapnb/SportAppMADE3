package id.ac.polbeng.depandi.sportappmade.core.di

import androidx.room.Room
import id.ac.polbeng.depandi.sportappmade.core.BuildConfig
import id.ac.polbeng.depandi.sportappmade.core.data.SportRepository
import id.ac.polbeng.depandi.sportappmade.core.data.source.local.LocalDataSource
import id.ac.polbeng.depandi.sportappmade.core.data.source.local.room.SportDatabase
import id.ac.polbeng.depandi.sportappmade.core.data.source.remote.RemoteDataSource
import id.ac.polbeng.depandi.sportappmade.core.data.source.remote.network.ApiService
import id.ac.polbeng.depandi.sportappmade.core.domain.repository.ISportRepository
import id.ac.polbeng.depandi.sportappmade.core.utils.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<SportDatabase>().sportDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes(BuildConfig.DB_PHRASE.toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            SportDatabase::class.java, BuildConfig.DB_NAME
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val certificatePinner = CertificatePinner.Builder()
            .add(BuildConfig.HOSTNAME, BuildConfig.PIN)
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ISportRepository> { SportRepository(get(), get(), get()) }
}