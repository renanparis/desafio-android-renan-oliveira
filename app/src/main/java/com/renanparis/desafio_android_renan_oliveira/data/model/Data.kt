package com.renanparis.desafio_android_renan_oliveira.data.model

data class Data(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Character>
) {
}