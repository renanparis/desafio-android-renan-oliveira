package com.renanparis.desafio_android_renan_oliveira.di

import com.renanparis.desafio_android_renan_oliveira.data.api.MarvelClient
import com.renanparis.desafio_android_renan_oliveira.data.repository.MarvelRepository
import com.renanparis.desafio_android_renan_oliveira.ui.adapter.ListCharactersAdapter
import com.renanparis.desafio_android_renan_oliveira.ui.viewmodel.ComicViewModel
import com.renanparis.desafio_android_renan_oliveira.ui.viewmodel.ListCharactersViewModel
import com.renanparis.desafio_android_renan_oliveira.usecase.ComicUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    factory<ListCharactersAdapter> { ListCharactersAdapter() }
}
val dataModule = module {
    single<MarvelClient> { MarvelClient() }
    single<MarvelRepository> { MarvelRepository(get()) }
    single<ComicUseCase> { ComicUseCase(get()) }
}
val viewModelModule = module {
    viewModel<ListCharactersViewModel> { ListCharactersViewModel(get()) }
    viewModel<ComicViewModel> { ComicViewModel(get()) }
 }

