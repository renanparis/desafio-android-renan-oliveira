package com.renanparis.desafio_android_renan_oliveira.usecase

import androidx.lifecycle.liveData
import com.renanparis.desafio_android_renan_oliveira.data.model.comic.Comic
import com.renanparis.desafio_android_renan_oliveira.data.repository.MarvelRepository
import com.renanparis.desafio_android_renan_oliveira.usecase.UseCaseHelper.getExpensiveComic
import kotlinx.coroutines.Dispatchers

class ComicUseCase(private val repository: MarvelRepository) {

    fun getComic(id: Int) = liveData(Dispatchers.IO) {
        emit(getExpensiveComic(getLisComics(id)))
    }

    private suspend fun getLisComics(id: Int): List<Comic> {
        return repository.getAllComics(id).data.results
    }

}