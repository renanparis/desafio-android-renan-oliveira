package com.renanparis.desafio_android_renan_oliveira.data.api

import com.renanparis.desafio_android_renan_oliveira.data.model.character.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

    @GET("characters")
   suspend fun allCharacters(@Query("offset")offset: Int? = 0): CharacterResponse
}