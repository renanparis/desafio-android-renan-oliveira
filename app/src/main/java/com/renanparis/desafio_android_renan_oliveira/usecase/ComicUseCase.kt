package com.renanparis.desafio_android_renan_oliveira.usecase

import androidx.lifecycle.MutableLiveData
import com.renanparis.desafio_android_renan_oliveira.data.model.comic.Comic
import com.renanparis.desafio_android_renan_oliveira.data.model.comic.ComicResponse
import com.renanparis.desafio_android_renan_oliveira.data.repository.MarvelRepository
import com.renanparis.desafio_android_renan_oliveira.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ComicUseCase(private val repository: MarvelRepository) {

    fun getComic(id: Int): MutableLiveData<Resource<Comic>> {
        val response = MutableLiveData<Resource<Comic>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val expensiveComic = getExpensiveComic(repository.getAllComics(id))
                expensiveComic?.let {
                    response.value = Resource.success(data = it)
                }
            } catch (e: Exception) {
                response.value = Resource.error(data = null, message = e.message ?: "Erro Api")
            }
        }
        return response
    }

    private fun getExpensiveComic(allComics: ComicResponse): Comic? {

        val listComics = allComics.data.results
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
            return comicExpensive
    }
}