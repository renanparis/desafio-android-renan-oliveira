package com.renanparis.desafio_android_renan_oliveira.usecase

import androidx.lifecycle.liveData
import com.renanparis.desafio_android_renan_oliveira.data.model.comic.Comic
import com.renanparis.desafio_android_renan_oliveira.data.repository.MarvelRepository
import com.renanparis.desafio_android_renan_oliveira.utils.Resource
import kotlinx.coroutines.Dispatchers

class ComicUseCase(private val repository: MarvelRepository) {

    fun getComic(id: Int) = liveData(Dispatchers.IO) {
        emit(getExpensiveComic(id))
    }

    private suspend fun getLisComics(id: Int): List<Comic> {
        return repository.getAllComics(id).data.results
    }

    private suspend fun getExpensiveComic(id: Int): Resource<Comic?> {
        return try {
            val listComics = getLisComics(id)
            var comicExpensive: Comic? = null
            var firstPrice: Float = 0.0F
            for (comic in listComics) {
                var listPrice = comic.prices
                var maxPrice: Float? = listPrice.maxBy { it.price }?.price
                maxPrice?.let {
                    if (it > firstPrice) {
                        comicExpensive = comic
                        firstPrice = it
                    }
                }
            }
            Resource.success(data = comicExpensive)
        }catch (e: java.lang.Exception) {
            Resource.error(data = null, message = e.message.toString())
        }
    }
}