package com.renanparis.desafio_android_renan_oliveira.data.repository

import com.renanparis.desafio_android_renan_oliveira.data.api.MarvelClient

class MarvelRepository(private val client: MarvelClient) {

    suspend fun getAllCharacters(offset: Int = 0) = client.getAllCharacters(offset)

    suspend fun getAllComics(id: Int) = client.getAllComics(id)
}