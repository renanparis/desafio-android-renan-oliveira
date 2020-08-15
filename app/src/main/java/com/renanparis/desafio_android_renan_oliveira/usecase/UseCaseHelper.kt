package com.renanparis.desafio_android_renan_oliveira.usecase

import com.renanparis.desafio_android_renan_oliveira.data.model.comic.Comic
import com.renanparis.desafio_android_renan_oliveira.utils.Resource

object UseCaseHelper {

     fun getExpensiveComic(comics: List<Comic>): Resource<Comic?> {
        return try {
            var comicExpensive: Comic? = comics[0]
            var firstPrice: Float = 0.0F
            for (comic in comics) {
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