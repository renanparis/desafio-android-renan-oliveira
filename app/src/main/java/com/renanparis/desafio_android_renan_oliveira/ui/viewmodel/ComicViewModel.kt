package com.renanparis.desafio_android_renan_oliveira.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.renanparis.desafio_android_renan_oliveira.usecase.ComicUseCase

class ComicViewModel(private val useCase: ComicUseCase) : ViewModel() {

    fun getExpensiveComic(id: Int) = useCase.getComic(id)
}
