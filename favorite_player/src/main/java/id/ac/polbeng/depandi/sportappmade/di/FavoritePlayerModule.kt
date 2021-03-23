package id.ac.polbeng.depandi.sportappmade.di

import id.ac.polbeng.depandi.sportappmade.favorite_player.FavoritePlayerViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoritePlayerModule = module {
    viewModel { FavoritePlayerViewModel(get()) }
}