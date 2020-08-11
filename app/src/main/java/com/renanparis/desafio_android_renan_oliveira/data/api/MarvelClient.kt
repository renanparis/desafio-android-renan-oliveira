package com.renanparis.desafio_android_renan_oliveira.data.api

class MarvelClient(
    private val service: MarvelService
    = RetrofitBuilder.service
) {

    suspend fun getAllCharacters() = service.allCharacters()

}