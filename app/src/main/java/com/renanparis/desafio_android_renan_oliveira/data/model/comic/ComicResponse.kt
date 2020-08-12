package com.renanparis.desafio_android_renan_oliveira.data.model.comic

data class ComicResponse(
    val code: Int,
    val etag: String,
    val data: ComicData
) {
}