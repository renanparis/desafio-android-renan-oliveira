package com.renanparis.desafio_android_renan_oliveira.data.model.character

import com.renanparis.desafio_android_renan_oliveira.data.model.character.Character

data class CharacterData(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Character>
) {
}