package id.ac.polbeng.depandi.sportappmade.di

import id.ac.polbeng.depandi.sportappmade.core.domain.usecase.SportInteractor
import id.ac.polbeng.depandi.sportappmade.core.domain.usecase.SportUseCase
import id.ac.polbeng.depandi.sportappmade.ui.detail_player.DetailPlayerViewModel
import id.ac.polbeng.depandi.sportappmade.ui.player.PlayerViewModel
import id.ac.polbeng.depandi.sportappmade.ui.sport.SportViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<SportUseCase> { SportInteractor(get()) }
}

val viewModelModule = module {
    viewModel { SportViewModel(get()) }
    viewModel { PlayerViewModel(get()) }
    viewModel { DetailPlayerViewModel(get()) }
}