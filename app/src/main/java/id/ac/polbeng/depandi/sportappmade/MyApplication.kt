package id.ac.polbeng.depandi.sportappmade

import android.app.Application
import id.ac.polbeng.depandi.sportappmade.core.di.databaseModule
import id.ac.polbeng.depandi.sportappmade.core.di.networkModule
import id.ac.polbeng.depandi.sportappmade.core.di.repositoryModule
import id.ac.polbeng.depandi.sportappmade.di.useCaseModule
import id.ac.polbeng.depandi.sportappmade.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}