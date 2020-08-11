package com.renanparis.desafio_android_renan_oliveira.di

import com.renanparis.desafio_android_renan_oliveira.data.api.MarvelClient
import com.renanparis.desafio_android_renan_oliveira.data.repository.MarvelRepository
import com.renanparis.desafio_android_renan_oliveira.ui.viewmodel.ListCharactersViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val dataModule = module {
    single<MarvelClient> { MarvelClient() }
    single<MarvelRepository> { MarvelRepository(get()) }
}
val viewModelModule = module {
    viewModel<ListCharactersViewModel> { ListCharactersViewModel(get()) }
 }

