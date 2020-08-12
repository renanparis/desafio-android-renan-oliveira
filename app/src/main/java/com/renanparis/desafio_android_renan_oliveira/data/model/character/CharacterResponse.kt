package com.renanparis.desafio_android_renan_oliveira.data.model.character

data class CharacterResponse(
    val code: Int,
    val etag: String,
    val data: CharacterData
) {
}