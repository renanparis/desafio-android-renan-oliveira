package com.renanparis.desafio_android_renan_oliveira.data.repository

import com.renanparis.desafio_android_renan_oliveira.data.api.MarvelClient

class MarvelRepository(private val client: MarvelClient) {

    suspend fun getAllCharacters() = client.getAllCharacters()
}