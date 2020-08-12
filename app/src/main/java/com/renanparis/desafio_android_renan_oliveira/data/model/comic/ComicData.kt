package com.renanparis.desafio_android_renan_oliveira.data.model.comic

data class ComicData(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Comic>
) {

}
