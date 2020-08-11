package com.renanparis.desafio_android_renan_oliveira.data.api

class MarvelClient(
    private val service: MarvelService
    = RetrofitBuilder.service
) {

    suspend fun getAllCharacters(offset: Int = 0) = service.allCharacters(offset)

}