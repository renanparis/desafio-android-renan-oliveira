package com.renanparis.desafio_android_renan_oliveira.data.model.comic

data class Comic(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnail: ComicThumbnail,
    val prices: List<ComicPrice>
) {

}
